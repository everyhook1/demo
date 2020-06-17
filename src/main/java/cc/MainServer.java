/**
 * @(#)MainServer.java, 6月 15, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cc;

import io.grpc.justtest.Peer;

import java.util.Map;

/**
 * argv[0] serverId 1
 * argv[1] peerList 127.0.0.1:3001:1,127.0.0.1:3002:2,127.0.0.1:3003:3
 *
 * @author liubin01
 */
public class MainServer {

    public static void main(String[] argv) throws Throwable {
        int serverId = Integer.parseInt(argv[0]);
        Map<Integer, Peer> peerMap = Util.parsePeers(argv[1]);
        RaftServer raftServer = new RaftServer(serverId, peerMap);
        raftServer.start();
        raftServer.blockUntilShutdown();
    }
}
