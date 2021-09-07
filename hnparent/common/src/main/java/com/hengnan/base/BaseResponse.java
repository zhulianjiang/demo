package com.hengnan.base;

import com.hengnan.entity.enums.MessageEnum;
import lombok.Data;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/4/21
 **/
@Data
public class BaseResponse<T> {

    private int code;
    private String message;
    private T result;

    public BaseResponse() {
    }

    public BaseResponse(int code, String message, T result) {
        this.setCode(code);
        this.setMessage(message);
        this.setResult(result);
    }

    public static BaseResponse success() {
        return new BaseResponse(MessageEnum.SUCCESS.value(), MessageEnum.SUCCESS.title(), null);
    }

    public static BaseResponse success(Object t) {
        return new BaseResponse(MessageEnum.SUCCESS.value(), MessageEnum.SUCCESS.title(), t);
    }

    public static BaseResponse fail() {
        return new BaseResponse(MessageEnum.FAIL.value(), MessageEnum.FAIL.title(), null);
    }

    public static BaseResponse fail(int value, String title) {
        return new BaseResponse(value, title, null);
    }


}
