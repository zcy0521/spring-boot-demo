package com.example.demo.api;

import com.example.demo.entity.DemoDO;
import com.example.demo.service.jpa.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/demo")
public class DemoApiController {

    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

    private com.example.demo.service.jpa.DemoService jpaDemoService;

    private com.example.demo.service.mybatis.DemoService mybatisDemoService;

    @Inject
    public void setJpaDemoService(DemoService jpaDemoService) {
        this.jpaDemoService = jpaDemoService;
    }

    @Inject
    public void setMybatisDemoService(com.example.demo.service.mybatis.DemoService mybatisDemoService) {
        this.mybatisDemoService = mybatisDemoService;
    }

    @GetMapping(value = "/get/jpa")
    public List<DemoDO> getJpa() {
        return jpaDemoService.findAll();
    }

    @GetMapping(value = "/get/mybatis")
    public List<DemoDO> getMyBatis() {
        return mybatisDemoService.findAll();
    }

}
