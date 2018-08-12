package com.example.demo.service.jpa.base;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService
 *
 * @author zcy
 * @date 2018/07/08
 */
public interface BaseService<T, ID extends Serializable> {

    /**
     * 查询全部
     * @return List<T>
     */
    List<T> findAll();

    /**
     * 查询全部 -- 分页
     * @param pageNumber 当前页
     * @param pageSize 每页显示条数
     * @return Page<T>
     */
    Page<T> findAll(int pageNumber, int pageSize);

    /**
     * 主键查询
     * @param id 主键
     * @return T
     */
    T findById(ID id);

    /**
     * 主键查询
     * @param ids 主键集合
     * @return List<T>
     */
    List<T> findAllById(Iterable<ID> ids);

    /**
     * 条件查询
     * @param entity 查询条件
     * @return T
     */
    T findOne(T entity);

    /**
     * 条件查询
     * @param entity 查询条件
     * @return List<T>
     */
    List<T> findAll(T entity);

    /**
     * 条件查询 -- 分页
     * @param entity 查询条件
     * @param pageNumber 当前页
     * @param pageSize 每页显示条数
     * @return Page<T>
     */
    Page<T> findAll(T entity, int pageNumber, int pageSize);

    /**
     * 新增/更新
     * @param entity 新增更新的对象
     * @return T 包含主键信息
     */
    T save(T entity);

    /**
     * 主键删除
     * @param id 主键
     */
    void deleteById(ID id);

    /**
     * 条件删除
     * @param entity 删除条件
     */
    void delete(T entity);

    /**
     * 是否存在对象
     * @param id 主键
     * @return boolean
     */
    boolean existsById(ID id);

    /**
     * 是否存在对象
     * @param entity 查询条件
     * @return boolean
     */
    boolean exists(T entity);

    /**
     * 对象总数
     * @return long
     */
    long count();

    /**
     * 符合条件的对象个数
     * @param entity 查询条件
     * @return long
     */
    long count(T entity);

}
