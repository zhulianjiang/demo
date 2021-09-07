package com.hengnan.core;

/**
 * @description: 错误返回信息
 * @author: leozhu
 * @create: 2020-09-24 23:11
 **/
public class UnifyResponse {
    private Integer code;
    private String message;
    private String url;

    public UnifyResponse(int code, String message, String url) {
        this.code = code;
        this.message = message;
        this.url = url;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
