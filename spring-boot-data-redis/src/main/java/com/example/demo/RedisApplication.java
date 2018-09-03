package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
 * spring-data-redis: https://github.com/spring-projects/spring-data-redis
 */
@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

}
