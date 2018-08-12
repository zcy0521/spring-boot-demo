package com.example.demo.repository.base.impl;

import com.example.demo.repository.base.BaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * 全局Repository接口的实现类
 * extends SimpleJpaRepository(JpaRepository接口的实现类)
 * implements BaseRepository
 * ApplicationContext中<jpa:repositories base-class="" /> 设置全局Repository接口实现类，不配置会抛出异常
 *
 * @author zcy
 * @date 2018/07/09
 */
@Slf4j
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

    private final EntityManager entityManager;


    /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

    public BaseRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }


    /*--------------------------------------------
    |               M E T H O D S               |
    ============================================*/

    @Override
    public void baseCustomMethod() {
        log.info("全局自定义方法baseCustomMethod()的实现");
    }

}
