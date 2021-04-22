package com.hengnan.core.exception.http;

/**
 * @description: 禁止异常
 * @author: leozhu
 * @create: 2020-09-24 22:43
 **/
public class ForbiddenException extends HttpException {
    public ForbiddenException(int code) {
        this.code = code;
        this.httpStatusCode = 403;
    }
}
