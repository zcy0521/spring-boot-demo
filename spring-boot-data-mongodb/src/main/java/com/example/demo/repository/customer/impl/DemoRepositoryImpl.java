package com.example.demo.repository.customer.impl;

import com.example.demo.repository.customer.DemoRepositoryCustom;
import lombok.extern.slf4j.Slf4j;

/**
 * DemoRepository自定义方法实现
 * ApplicationContext中<jpa:repositories repository-impl-postfix="" /> 控制*RepositoryCustom接口实现类的后缀 不配置默认找*Impl类 作为自定义Custom接口实现类
 *
 * @author zcy
 * @date 2018/07/09
 */
@Slf4j
public class DemoRepositoryImpl implements DemoRepositoryCustom {

    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/



    /*--------------------------------------------
    |               M E T H O D S               |
    ============================================*/

    @Override
    public void demoCustomMethod() {
        log.info("DemoRepository自定义方法demoCustomMethod()的实现");
    }

}
