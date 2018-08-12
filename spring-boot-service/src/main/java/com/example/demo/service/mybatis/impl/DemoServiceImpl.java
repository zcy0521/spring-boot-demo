package com.example.demo.service.mybatis.impl;

import com.example.demo.entity.DemoDO;
import com.example.demo.mapper.DemoMapper;
import com.example.demo.service.mybatis.DemoService;
import com.example.demo.service.mybatis.base.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * DemoService实现类
 *
 * @author zcy
 * @date 2018/07/09
 */
@Slf4j
@Service("mybatisDemoService")
public class DemoServiceImpl extends BaseServiceImpl<DemoDO> implements DemoService {

    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

    private DemoMapper demoMapper;

    /*--------------------------------------------
    |  A C C E S S O R S / M O D I F I E R S    |
    ============================================*/

    /**
     * 注入demoRepository(setter注入)
     * JSR-330写法 @Inject @Named("beanName")
     * Spring写法 @Autowired @Qualifier("beanName")
     */
    @Inject
    public void setDemoMapper(DemoMapper demoMapper) {
        // 将"demoMapper"注入BaseServiceImpl中
        super.setMapper(demoMapper);

        // 将"demoMapper"注入DemoServiceImpl中
        this.demoMapper = demoMapper;
    }

    /*--------------------------------------------
    |               M E T H O D S               |
    ============================================*/

}
