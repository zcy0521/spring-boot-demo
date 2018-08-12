package com.example.demo.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 全局Repository接口
 *
 * @author zcy
 * @date 2018/07/09
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    /*--------------------------------------------
    |               M E T H O D S               |
    ============================================*/

    /**
     * Adding custom behavior to all repositories
     */
    void baseCustomMethod();

}
