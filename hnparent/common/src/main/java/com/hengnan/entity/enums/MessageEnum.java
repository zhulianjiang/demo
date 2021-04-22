package com.hengnan.entity.enums;

import com.wise.framework.basic.IEnum;

/**
 * @description: 消息枚举
 * @author: leozhu
 * @create: 2021/4/21
 **/
public enum MessageEnum implements IEnum<Integer> {

    SUCCESS(200,"成功"),
    FAIL(400,"失败"),

    ERR_USER_NAME(1001001001,"登录失败，用户不存在"),
    ERR_USER_PASSWORD(1001001002,"登录失败，密码错误");

    private int value;
    private String title;

    MessageEnum(int value,String title){
        this.value = value;
        this.title = title;
    }

    @Override
    public Integer value() {
        return this.value;
    }

    @Override
    public String title() {
        return this.title;
    }
}
