/**
 * @(#)RaftNode.java, 6月 15, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo;

import io.grpc.justtest.Peer;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author liubin01
 */
public class RaftNode {
    public enum NodeState {
        STATE_FOLLOWER,
        STATE_PRE_CANDIDATE,
        STATE_CANDIDATE,
        STATE_LEADER
    }

    private int serverId;
    private Map<Integer, Peer> peerMap;
    private ClientProxy proxy;

    private NodeState state = NodeState.STATE_FOLLOWER;
    // 服务器最后一次知道的任期号（初始化为 0，持续递增）
    private long currentTerm;
    // 在当前获得选票的候选人的Id
    private int votedFor;
    private int leaderId; // leader节点id
    // 已知的最大的已经被提交的日志条目的索引值
    private long commitIndex;
    // 最后被应用到状态机的日志条目索引值（初始化为 0，持续递增）
    private volatile long lastAppliedIndex;

    private ExecutorService executorService;
    private ScheduledExecutorService scheduledExecutorService;


    public RaftNode(int serverId, Map<Integer, Peer> peerMap) {
        this.serverId = serverId;
        this.peerMap = peerMap;
        this.proxy = new ClientProxy(serverId, peerMap);

        scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(() -> {

        }, 2, 3, TimeUnit.MILLISECONDS);
    }
}
