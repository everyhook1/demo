/**
 * @(#)ClientProxy.java, 6月 15, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo;

import io.grpc.justtest.Peer;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liubin01
 */
@Slf4j
public class ClientProxy {
    int serverId;
    Map<Integer, Peer> peerMap;
    Map<Integer, RaftClient> clientMap;

    public ClientProxy(int serverId, Map<Integer, Peer> peerMap) {
        this.peerMap = peerMap;
        this.serverId = serverId;
        clientMap = new HashMap<>();
        peerMap.forEach((k, v) -> {
            if (serverId != k) {
                clientMap.put(k, new RaftClient(v));
            }
        });
    }
}
