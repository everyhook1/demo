/**
 * @(#)GreeterImpl.java, 6月 15, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo;

import io.grpc.justtest.GreeterGrpc;
import io.grpc.justtest.VoteRequest;
import io.grpc.justtest.VoteResponse;
import io.grpc.stub.StreamObserver;

/**
 * @author liubin01
 */
//实现服务接口的类
public class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    private RaftNode raftNode;

    public GreeterImpl(RaftNode raftNode) {
        this.raftNode = raftNode;
    }

    public void vote(VoteRequest request,
                     StreamObserver<VoteResponse> responseObserver) {
        VoteResponse voteResponse = VoteResponse.newBuilder().build();
        responseObserver.onNext(voteResponse);
        responseObserver.onCompleted();
    }
}