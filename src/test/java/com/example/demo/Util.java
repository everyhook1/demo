/**
 * @(#)Util.java, 6月 15, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo;

import io.grpc.justtest.Peer;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liubin01
 */
public class Util {
    public static Peer parsePeer(String address) {
        String[] adds = address.split("[:]");
        return Peer.newBuilder()
                .setHost(adds[0])
                .setPort(Integer.parseInt(adds[1]))
                .setServerId(Integer.parseInt(adds[2]))
                .build();
    }

    public static Map<Integer, Peer> parsePeers(String address) {
        return Arrays.stream(address.split("[,]")).map(Util::parsePeer).collect(Collectors.toMap(Peer::getServerId, peer -> peer, (a, b) -> b));
    }
}
