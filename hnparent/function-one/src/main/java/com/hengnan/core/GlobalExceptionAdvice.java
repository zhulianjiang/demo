package com.hengnan.core;


import com.hengnan.core.configuration.ExceptionCodeConfiguration;
import com.hengnan.core.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @description: 全局异常处理
 * @author: leozhu
 * @create: 2020-09-23 23:25
 **/
@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration codeConfiguration;

    /**
     * 捕获通用类异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest req,Exception e){
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
//        String msg = String.valueOf(e).substring(String.valueOf(e).indexOf(":")+2);
        System.out.println(e);
        UnifyResponse unifyResponse = new UnifyResponse(1111,"服务器异常",method +" "+requestUrl);
        return unifyResponse;
    }

    /**
     * 捕获HTTP异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest req, HttpException e){
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        UnifyResponse message = new UnifyResponse(e.getCode(),codeConfiguration.getMessage(e.getCode()),method +" "+requestUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());
        ResponseEntity<UnifyResponse> responseEntity = new ResponseEntity<UnifyResponse>(message,headers,httpStatus);
        return responseEntity;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UnifyResponse handleMethodArgumentNotValidException(HttpServletRequest req,MethodArgumentNotValidException e){
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String msg = this.getMsg(allErrors);
        return new UnifyResponse(10001,msg,method +" "+requestUrl);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public UnifyResponse handleConstraintViolationException(HttpServletRequest req,ConstraintViolationException e){
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        String message = e.getMessage();
        return new UnifyResponse(10001,message,method +" "+requestUrl);
//        for (ConstraintViolation error : e.getConstraintViolations()) {
//            ConstraintViolation a = error;
//        }
    }

    public String getMsg(List<ObjectError> errors){
        StringBuilder messageSbr = new StringBuilder();
        errors.forEach(err->{
            messageSbr.append(err.getDefaultMessage()).append(";");
        });
        return messageSbr.toString();
    }
}
