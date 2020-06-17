/**
 * @(#)TestClient.java, Jun 12, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cc;

import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.justtest.GreeterGrpc;
import io.grpc.justtest.Peer;
import io.grpc.justtest.VoteRequest;
import io.grpc.justtest.VoteResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 客户端
 */
@Slf4j
public class RaftClient {
    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterFutureStub blockingStub;

    public RaftClient(Peer peer) {
        //usePlaintext表示明文传输，否则需要配置ssl
        //channel  表示通信通道

        channel = ManagedChannelBuilder.forAddress(peer.getHost(), peer.getPort()).usePlaintext().build();
        //存根
        blockingStub = GreeterGrpc.newFutureStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public ListenableFuture<VoteResponse> vote(VoteRequest voteRequest) {
        return blockingStub.vote(voteRequest);
    }
}
