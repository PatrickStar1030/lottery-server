package com.ruoyi.web.controller.lottery;

import com.ruoyi.lottery.entity.message.MessageBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/app")
public class MessageController {

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/test")
    public void sendTo(MessageBody messageBody){
        log.info("lottery成功进入",messageBody.toString());
        simpMessageSendingOperations.convertAndSend(messageBody.getDestination(),messageBody);
    }

}
