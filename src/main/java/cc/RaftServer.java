/**
 * @(#)TestServer.java, Jun 12, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.justtest.Peer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

/**
 * 服务端
 */
@Slf4j
public class RaftServer {
    //服务
    private Server server;
    private final Peer peer;
    private final RaftNode raftNode;

    public RaftServer(int serverId, Map<Integer, Peer> peerMap) {
        this.peer = peerMap.get(serverId);
        this.raftNode = new RaftNode(serverId, peerMap);
    }

    //启动服务,并且接受请求
    public void start() throws IOException {
        this.server = ServerBuilder.forPort(peer.getPort()).addService(new GreeterImpl(raftNode)).build().start();
        log.info("服务开始启动-------");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("------shutting down gRPC server since JVM is shutting down-------");
            this.stop();
            log.info("------server shut down------");
        }));
    }

    //stop服务
    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    //server阻塞到程序退出
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
