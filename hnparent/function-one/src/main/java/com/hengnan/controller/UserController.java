package com.hengnan.controller;

import com.hengnan.entity.User;
import com.hengnan.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: leozhu
 * @create: 2020-12-06 16:52
 **/
@RestController
@Api(tags = "村民管理")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("查询村民列表")
    @GetMapping("/getUserList")
    public List<User> getUserList() {
        List<User> userList = userService.getUserList();
        return userList;
    }

    @ApiOperation("根据村民id获取村民信息")
    @GetMapping("/getUserById")
    public User getUserById(@RequestParam Integer id) {
        User user = userService.getUserById(id);
        return user;
    }

}
