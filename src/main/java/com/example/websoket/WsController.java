package com.example.websoket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WsController {

    @Autowired
    public SimpMessagingTemplate template;

    /**
     * Message mapping path queue, request this path can execute the following methods
     */
    @MessageMapping("/queue")
    public void queue(Payload payload) {
      /*
      Use convertAndSendToUser, and the subscription address in JS is
       'user / + user ID + / message ', where' / user 'is fixed
       */
        template.convertAndSendToUser(payload.getName(), "message", "user=" + payload.getName());
    }

}
