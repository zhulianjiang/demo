package com.hengnan.core.exception.http;

/**
 * @description: http异常
 * @author: leozhu
 * @create: 2020-09-24 22:40
 **/
public class HttpException extends RuntimeException {
    protected Integer code;
    protected Integer httpStatusCode = 500;

    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
}
