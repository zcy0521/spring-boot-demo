package com.example.demo.service.jpa.base.impl;

import com.example.demo.repository.base.BaseRepository;
import com.example.demo.service.jpa.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * BaseService实现类
 *
 * @author zcy
 * @date 2018/07/08
 */
@Slf4j
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

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

    private BaseRepository<T, ID> repository;

    /*--------------------------------------------
    |  A C C E S S O R S / M O D I F I E R S    |
    ============================================*/

    public void setRepository(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    /*--------------------------------------------
    |               M E T H O D S               |
    ============================================*/

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<T> findAll(int pageNumber, int pageSize) {
        Pageable pageable = createPageRequest(pageNumber, pageSize);
        return repository.findAll(pageable);
    }

    @Override
    public T findById(ID id) {
        /*
         * Option 使用
         * 1. 存在即返回, 无则提供默认值
         * return entity.orElse(null);
         * 2. 存在即返回, 无则由函数来产生
         * return user.orElseGet(() -> fetchAUserFromDatabase());
         * 3. 存在才对它做点什么
         * return entity.ifPresent(System.out::println);
         * 4. map处理
         * return entity.map(entity -> entity.getList()).orElse(Collections.emptyList());
         */
        Optional<T> entity = repository.findById(id);
        return entity.orElse(null);
    }

    @Override
    public List<T> findAllById(Iterable<ID> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public T findOne(T entity) {
        Example<T> example = createExample(entity);
        return repository.findOne(example).orElse(null);
    }

    @Override
    public List<T> findAll(T entity) {
        Example<T> example = createExample(entity);
        return repository.findAll(example);
    }

    @Override
    public Page<T> findAll(T entity, int pageNumber, int pageSize) {
        Example<T> example = createExample(entity);
        Pageable pageable = createPageRequest(pageNumber, pageSize);
        return repository.findAll(example, pageable);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public boolean exists(T entity) {
        Example<T> example = createExample(entity);
        return repository.exists(example);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public long count(T entity) {
        Example<T> example = createExample(entity);
        return repository.count(example);
    }


    /*-------------------------------------------
    |               Example & Page              |
    ============================================*/

    /**
     * 创建查询Example
     * @param entity 查询实体对象
     * @return 创建的Example对象
     */
    private Example<T> createExample(T entity) {
        /*
         * 构造matcher
         * withIgnoreCase 忽略大小写
         * withStringMatcher 字符串like拼接
         */
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        //返回Example
        return Example.of(entity, matcher);
    }

    /**
     * 创建分页PageRequest
     * @param pageNumber 当前显示第几页 1 2 3 ...
     * @param pageSize 当前页显示几条 1 2 3 ...
     * @return 创建的分页排序对象
     */
    private PageRequest createPageRequest(int pageNumber, int pageSize) {
        // 处理page
        if (pageNumber < 1) {
            pageNumber = PAGE_NUMBER;
        } else {
            // pageNumber从0开始
            pageNumber = pageNumber - 1;
        }
        // 处理size
        if (pageSize < 1) {
            pageSize = PAGE_SIZE;
        }
        return PageRequest.of(pageNumber, pageSize);
    }

}
