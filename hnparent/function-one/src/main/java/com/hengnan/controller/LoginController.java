package com.hengnan.controller;


import com.hengnan.base.BaseResponse;
import com.hengnan.base.PassToken;
import com.hengnan.entity.UserAdmin;
import com.hengnan.entity.enums.MessageEnum;
import com.hengnan.service.TokenService;
import com.hengnan.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api")
public class LoginController {
    @Autowired
    private UserAdminService userService;
    @Autowired
    private TokenService tokenService;

    //登录
    @PassToken
    @PostMapping("/login")
    public BaseResponse login(@RequestBody UserAdmin user) {
        UserAdmin userInfo = userService.findByLoginId(user.getLoginId());
        if (Objects.isNull(userInfo)) {
            return BaseResponse.fail(MessageEnum.ERR_USER_NAME.value(),MessageEnum.ERR_USER_NAME.title());
        }
        if (!Objects.equals(userInfo.getPassWord(),user.getPassWord())) {
            return BaseResponse.fail(MessageEnum.ERR_USER_PASSWORD.value(),MessageEnum.ERR_USER_PASSWORD.title());
        }
        String token = tokenService.getToken(userInfo);
        userInfo.setToken(token);
        return BaseResponse.success(userInfo);
    }


    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }
}
