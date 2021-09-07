package com.hengnan.test;

import org.springframework.context.ApplicationEvent;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/7/22
 **/
public class EmailEvent extends ApplicationEvent {

    private String address;
    private String text;

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public EmailEvent(Object source) {
        super(source);
    }

    //初始化全部成员变量的构造器
    public EmailEvent(Object source,String address,String text) {
        super(source);
        this.address=address;
        this.text=text;
    }
}
