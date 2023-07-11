package com.ruoyi.web.controller.lottery;

import com.ruoyi.lottery.entity.message.Client2ServerMessage;
import com.ruoyi.lottery.entity.message.Server2Client;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestStomp {

    @MessageMapping("/hello")
    @SendTo("/websocket/getResponse")
    public Server2Client say(Client2ServerMessage message) throws Exception {
        return new Server2Client("hello,"+ message.getName() + "!");
    }
}
