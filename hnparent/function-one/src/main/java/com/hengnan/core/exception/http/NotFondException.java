package com.hengnan.core.exception.http;

/**
 * @description: 空异常
 * @author: leozhu
 * @create: 2020-09-24 22:42
 **/
public class NotFondException extends HttpException {
    public NotFondException(int code) {
        this.code = code;
        this.httpStatusCode = 404;
    }
}
