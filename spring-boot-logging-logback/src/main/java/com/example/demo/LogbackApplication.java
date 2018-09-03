package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
 * logback: https://github.com/qos-ch/logback
 * aliyun-sls: https://github.com/aliyun/aliyun-log-logback-appender
 */
@SpringBootApplication
public class LogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
    }

}
