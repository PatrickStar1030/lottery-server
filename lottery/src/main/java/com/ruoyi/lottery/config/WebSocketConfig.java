package com.ruoyi.lottery.config;


import com.ruoyi.lottery.constant.SocketConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * STOMP 配置类
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    /**
     * 配置 WebSocket 进入点，及开启使用 SockJS，这些配置主要用配置连接端点，用于 WebSocket 连接
     *
     * @param registry STOMP 端点
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(SocketConstants.WEBSOCKET_PATH).setAllowedOriginPatterns("*").withSockJS();
    }

    /**
     * 配置消息代理选项
     *
     * @param registry 消息代理注册配置
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 配置服务端推送消息给客户端的代理路径
        registry.enableSimpleBroker(SocketConstants.BROKER.BROKER_TOPIC);
        // 定义点对点推送时的前缀为
        registry.setUserDestinationPrefix(SocketConstants.BROKER.BROKER_QUEUE);
        // 访问服务端消息接口前缀
        registry.setApplicationDestinationPrefixes(SocketConstants.WS_PREFIX);
    }
}
