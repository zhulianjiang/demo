package com.hengnan.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 异常配置类
 * @author: leozhu
 * @create: 2020-09-28 23:16
 **/
@ConfigurationProperties(prefix = "hengnan")
@PropertySource(value = {"classpath:config/exception-code.properties"},encoding = "utf-8")
@Component
public class ExceptionCodeConfiguration {

    private Map<Integer,String> codes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setCodes(Map<Integer, String> codes) {
        this.codes = codes;
    }

    public String getMessage(int code){
        String message = codes.get(code);
        return message;
    }

}
