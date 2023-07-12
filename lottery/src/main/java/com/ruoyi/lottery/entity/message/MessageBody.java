package com.ruoyi.lottery.entity.message;

import lombok.Data;

@Data
public class MessageBody {

    /**
     * 发消息的用户
     */
    private String from;
    /** 消息内容 */
    private String content;
    /**
     * 目标用户
     */
    private String targetUser;
    /** 广播转发的目标地址（告知 STOMP 代理转发到哪个地方） */
    private String destination;
}
