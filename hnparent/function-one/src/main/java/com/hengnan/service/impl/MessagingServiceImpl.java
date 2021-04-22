package com.hengnan.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/9 16:00
 **/
public class MessagingServiceImpl {

    @Autowired
    RabbitTemplate rabbitTemplate;

//    public void sendRegistrationMessage(RegistrationMessage msg){
//        rabbitTemplate.convertAndSend("registration","",msg);
//    }
//
//    public void sendLoginMessage(LoginMessage msg) {
//        String routingKey = msg.success ? "" : "login_failed";
//        rabbitTemplate.convertAndSend("login", routingKey, msg);
//    }


}
