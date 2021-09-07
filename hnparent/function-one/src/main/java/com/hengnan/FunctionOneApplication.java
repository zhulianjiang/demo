package com.hengnan;

import com.hengnan.test.EmailNotifier;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @description:
 * @author: leozhu
 * @create: 2020-12-06 17:13
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.hengnan.mapper.test1", sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class FunctionOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(FunctionOneApplication.class, args);
    }

    @Bean
    MessageConverter createMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public EmailNotifier appApplicationListener(){
        return new EmailNotifier();
    }

}
