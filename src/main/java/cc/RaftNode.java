/**
 * @(#)RaftNode.java, 6月 15, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cc;

import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.justtest.Peer;
import io.grpc.justtest.VoteRequest;
import io.grpc.justtest.VoteResponse;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author liubin01
 */
@Data
public class RaftNode {
    public enum NodeState {
        STATE_FOLLOWER,
        STATE_CANDIDATE,
        STATE_LEADER
    }

    private int serverId;
    private Map<Integer, Peer> peerMap;
    private ClientProxy proxy;

    private volatile NodeState state = NodeState.STATE_FOLLOWER;
    // 服务器最后一次知道的任期号（初始化为 0，持续递增）
    private volatile long currentTerm;
    // 在当前获得选票的候选人的Id
    private volatile int votedFor;
    private volatile int leaderId; // leader节点id
    // 已知的最大的已经被提交的日志条目的索引值
    private volatile long commitIndex;
    // 最后被应用到状态机的日志条目索引值（初始化为 0，持续递增）
    private volatile long lastAppliedIndex;

    private ExecutorService executorService;
    private ScheduledExecutorService scheduledExecutorService;

    private ScheduledFuture electFuture;//选举
    private ScheduledFuture heartFuture;//心跳

    public RaftNode(int serverId, Map<Integer, Peer> peerMap) {
        this.serverId = serverId;
        this.peerMap = peerMap;
        this.proxy = new ClientProxy(serverId, peerMap);

        scheduledExecutorService = Executors.newScheduledThreadPool(2);
        electFuture = scheduledExecutorService.scheduleAtFixedRate(election, 200, 300, TimeUnit.MILLISECONDS);
    }

    private Runnable hearBeater = () -> {
        if (state != NodeState.STATE_LEADER) {
            return;
        }
    };

    private Runnable election = () -> {
        if (state == NodeState.STATE_LEADER) {
            return;
        }
        this.currentTerm++;
        VoteRequest voteRequest = VoteRequest.newBuilder()
                .setTerm(currentTerm)
                .setServerId(serverId)
                .setLastLogTerm(0)
                .setLastLogIndex(0)
                .build();
        int voteCount = 1;
        Map<Integer, ListenableFuture<VoteResponse>> futureMap = new ConcurrentHashMap<>();
        proxy.clientMap.forEach((key, v) -> futureMap.put(key, v.vote(voteRequest)));
        for (Map.Entry<Integer, ListenableFuture<VoteResponse>> entry : futureMap.entrySet()) {
            ListenableFuture<VoteResponse> v = entry.getValue();
            VoteResponse response;
            try {
                response = v.get(50, TimeUnit.MILLISECONDS);
                if (response.getGranted()) {
                    voteCount++;
                } else {
                    if (response.getTerm() > currentTerm) {
                        currentTerm = response.getTerm();
                    }
                }
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        if (voteCount > (peerMap.size() + 1) / 2) {
            becomeLeader();
        }
    };

    private void becomeLeader() {
        state = NodeState.STATE_LEADER;
    }
}
