package com.hengnan.controller;

import org.dromara.soul.client.springmvc.annotation.SoulSpringMvcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/25
 **/
@RestController
@RequestMapping("/soul")
@SoulSpringMvcClient(path = "/soul/**")
public class HttpTestController {
    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello I'm come on";
    }
}
