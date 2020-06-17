/**
 * @(#)GreeterImpl.java, 6月 15, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cc;

import io.grpc.justtest.GreeterGrpc;
import io.grpc.justtest.VoteRequest;
import io.grpc.justtest.VoteResponse;
import io.grpc.stub.StreamObserver;

/**
 * @author liubin01
 */
//实现服务接口的类
public class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    private final RaftNode raftNode;

    public GreeterImpl(RaftNode raftNode) {
        this.raftNode = raftNode;
    }

    public void vote(VoteRequest request,
                     StreamObserver<VoteResponse> responseObserver) {
        VoteResponse voteResponse = VoteResponse.newBuilder().build();
        if (request.getTerm() < raftNode.getCurrentTerm()) {
            voteResponse.toBuilder().setGranted(false).build();
        } else {
            if (raftNode.getVotedFor() == 0 || raftNode.getVotedFor() == request.getServerId()) {

            }
        }
        responseObserver.onNext(voteResponse);
        responseObserver.onCompleted();
    }
}