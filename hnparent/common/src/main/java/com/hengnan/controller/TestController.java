package com.hengnan.controller;

import com.hengnan.base.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/21
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/getInfo")
    public BaseResponse getInfo(@RequestParam int id){
        int paramId = id;
        return BaseResponse.success("this is common");
    }

}
