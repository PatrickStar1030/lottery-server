package com.ruoyi.lottery.service.impl;

import com.ruoyi.lottery.entity.message.MessageBody;
import com.ruoyi.lottery.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;


    /**
     * 消息体，查看发送消息是否匹配规则
     * @param messageBody 自定义消息体
     * @return true-符合，false不符合
     */
    @Override
    public boolean checkUserMessage(MessageBody messageBody) {
        log.info("进入消息校验:{}",messageBody.toString());
        return false;
    }
}
