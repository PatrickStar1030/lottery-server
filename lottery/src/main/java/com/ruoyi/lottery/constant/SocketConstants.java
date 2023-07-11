package com.ruoyi.lottery.constant;

public class SocketConstants {

    // stomp端点地址
    public static final String WEBSOCKET_PATH = "/websocket";

    // websocket前缀
    public static final String WS_PREFIX = "/app";

    // 消息订阅地址常量
    public static final class BROKER {
        // 点对点消息代理地址
        public static final String BROKER_QUEUE = "/queue";
        // 广播消息代理地址
        public static final String BROKER_TOPIC = "/topic";
    }
}
