package com.example.demo.service.mybatis.base.impl;

import com.example.demo.mapper.base.BaseMapper;
import com.example.demo.service.mybatis.base.BaseService;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.Set;

/**
 * BaseService实现类
 *
 * @author zcy
 * @date 2018/07/10
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

    /**
     * 默认显示第1页
     */
    private static final int PAGE_NUMBER = 0;

    /**
     * 默认每页显示10条
     */
    private static final int PAGE_SIZE = 10;

    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

    private BaseMapper<T> mapper;

    /*--------------------------------------------
    |  A C C E S S O R S / M O D I F I E R S    |
    ============================================*/

    public void setMapper(BaseMapper<T> mapper) {
        this.mapper = mapper;
    }

    /*--------------------------------------------
    |               M E T H O D S               |
    ============================================*/

    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }

    @Override
    public List<T> findAll(int pageNumber, int pageSize) {
        startPage(pageNumber, pageSize);
        return mapper.selectAll();
    }

    @Override
    public T findById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAllById(Set<Object> ids) {
        return null;
    }

    @Override
    public T findOne(T entity) {
        return mapper.selectOne(entity);
    }

    @Override
    public List<T> findAll(T entity) {
        return mapper.select(entity);
    }

    @Override
    public List<T> findAll(T entity, int pageNumber, int pageSize) {
        startPage(pageNumber, pageSize);
        return mapper.select(entity);
    }

    @Override
    public int insert(T entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public boolean update(T entity) {
        int count = mapper.updateByPrimaryKeySelective(entity);
        return count > 0;
    }

    @Override
    public boolean deleteById(Object id) {
        int count = mapper.deleteByPrimaryKey(id);
        return count > 0;
    }

    @Override
    public boolean delete(T entity) {
        int count = mapper.delete(entity);
        return count > 0;
    }

    @Override
    public boolean existsById(Object id) {
        return mapper.existsWithPrimaryKey(id);
    }

    @Override
    public long count(T entity) {
        return mapper.selectCount(entity);
    }

    /*-------------------------------------------
    |               Example & Page              |
    ============================================*/

    /**
     * 开启分页
     * https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
     * @param pageNumber 当前显示第几页 1 2 3 ...
     * @param pageSize 当前页显示几条 1 2 3 ...
     */
    private void startPage(int pageNumber, int pageSize) {
        // 处理page
        if (pageNumber < 1) {
            pageNumber = PAGE_NUMBER;
        }
        // 处理size
        if (pageSize < 1) {
            pageSize = PAGE_SIZE;
        }
        PageHelper.startPage(pageNumber, pageSize);
    }

}
