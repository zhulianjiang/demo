package com.hengnan.controller;

import com.hengnan.entity.UserAdmin;
import com.hengnan.service.UserAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: leozhu
 * @create: 2020-12-06 20:38
 **/
@Api(tags = "用户管理")
@RestController
@RequestMapping("/api/userAdmin")
public class UserAdminController {

    @Autowired
    private UserAdminService userAdminService;

    @ApiOperation("查询用户列表")
    @GetMapping("/getList")
    public List<UserAdmin> getList() {
        List<UserAdmin> userAdmins = userAdminService.getList();
        return userAdmins;
    }

    @ApiOperation("新增用户接口")
    @PostMapping("/add")
    public UserAdmin add(@RequestBody UserAdmin userAdmin) {
        UserAdmin user = userAdminService.add(userAdmin);
        return user;
    }


}
