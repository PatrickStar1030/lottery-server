package com.ruoyi.lottery.interceptor;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.lottery.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Component;

import java.security.Principal;


/**
 * websocket消息拦截器
 * 在此处校验token
 * 消息过滤等等
 */
@Component
@Slf4j
public class MessageInterceptor implements ChannelInterceptor {
    /**
     * 消息发送前
     *
     * @param message 消息对象
     * @param channel 通道对象
     * @return 验证后的用户信息
     */
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        log.info("accessor message:{}",accessor.getMessage());
        log.info("消息发送前,{}",message.toString());
        return ChannelInterceptor.super.preSend(message, channel);
    }

    /**
     * 发送后
     * @param message 消息对象
     * @param channel 通道对象
     * @param sent 处理后的信息
     */
    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        ChannelInterceptor.super.postSend(message, channel, sent);
    }

    /**
     * 发送成功后的消息处理
     * @param message 消息替
     * @param channel 信道
     * @param sent 处理后的信息
     * @param ex 异常信息
     */
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        ChannelInterceptor.super.afterSendCompletion(message, channel, sent, ex);
    }

    /**
     * 接受消息之前的处理
     * @param channel 通道
     * @return 处理后的消息
     */
    @Override
    public boolean preReceive(MessageChannel channel) {
        return ChannelInterceptor.super.preReceive(channel);
    }

    /**
     * 接受消息后的处理
     * @param message 消息体
     * @param channel 信道
     * @return 处理完成后的消息
     */
    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        return ChannelInterceptor.super.postReceive(message, channel);
    }

    /**
     * 成功接受消息后的处理
     * @param message 消息
     * @param channel 信道
     * @param ex 异常信息
     */
    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
        ChannelInterceptor.super.afterReceiveCompletion(message, channel, ex);
    }


    private String getToken(MessageHeaders headers){
        if (null == headers){
            return null;
        }
        String token = (String) headers.get("Authorization");
        if (StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)){
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }
}
