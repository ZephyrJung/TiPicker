package org.b3log.zephyr.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by yaya on 17-3-12.
 */
@Controller
public class WsController {
    @MessageMapping("/welcome") //页面发送信息的url映射
    @SendTo("/topic/getResponse") //页面接收信息的url映射
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        return new ResponseMessage("welcome," + message.getName() + " !");
    }
}