package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
 * logging-log4j2: https://github.com/apache/logging-log4j2
 * aliyun-sls: https://github.com/aliyun/aliyun-log-log4j2-appender
 */
@SpringBootApplication
public class Log4j2Application {

    public static void main(String[] args) {
        SpringApplication.run(Log4j2Application.class, args);
    }

}
