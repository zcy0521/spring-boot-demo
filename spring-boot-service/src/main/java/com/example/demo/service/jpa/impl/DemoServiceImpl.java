package com.example.demo.service.jpa.impl;

import com.example.demo.entity.DemoDO;
import com.example.demo.repository.DemoRepository;
import com.example.demo.service.jpa.DemoService;
import com.example.demo.service.jpa.base.impl.BaseServiceImpl;
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
@Service("jpaDemoService")
public class DemoServiceImpl extends BaseServiceImpl<DemoDO, Long> implements DemoService {

    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

    private DemoRepository demoRepository;

    /*--------------------------------------------
    |  A C C E S S O R S / M O D I F I E R S    |
    ============================================*/

    /**
     * 注入demoRepository(setter注入)
     * JSR-330写法 @Inject @Named("beanName")
     * Spring写法 @Autowired @Qualifier("beanName")
     */
    @Inject
    public void setRepository(DemoRepository demoRepository) {
        // 将"sampleRepository"注入BaseServiceImpl中
        super.setRepository(demoRepository);

        // 将"sampleRepository"注入DemoServiceImpl中
        this.demoRepository = demoRepository;
    }

    /*--------------------------------------------
    |               M E T H O D S               |
    ============================================*/

}
