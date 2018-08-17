package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * doc: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Log4j2Application {

    public static void main(String[] args) {
        SpringApplication.run(Log4j2Application.class, args);
    }

}
