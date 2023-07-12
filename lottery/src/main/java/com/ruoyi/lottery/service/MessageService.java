package com.ruoyi.lottery.service;

import com.ruoyi.lottery.entity.message.MessageBody;

public interface MessageService {
    boolean checkUserMessage(MessageBody messageBody);
}
