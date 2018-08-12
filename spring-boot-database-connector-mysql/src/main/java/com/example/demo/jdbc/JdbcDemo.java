package com.example.demo.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class JdbcDemo {

    @Inject
    private JdbcTemplate jdbcTemplate;

    public void getDemo() {
    }

}
