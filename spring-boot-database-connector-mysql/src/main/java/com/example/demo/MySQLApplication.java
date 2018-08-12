package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * doc: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class MySQLApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySQLApplication.class, args);
    }

}
