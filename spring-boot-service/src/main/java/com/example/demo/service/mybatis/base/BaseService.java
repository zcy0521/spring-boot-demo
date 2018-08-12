package com.example.demo.service.mybatis.base;

import java.util.List;
import java.util.Set;

/**
 * BaseService
 *
 * @author zcy
 * @date 2018/07/10
 */
public interface BaseService<T> {

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
    List<T> findAll(int pageNumber, int pageSize);

    /**
     * 主键查询
     * @param id 主键
     * @return T
     */
    T findById(Object id);

    /**
     * 主键查询
     * @param ids 主键集合
     * @return List<T>
     */
    List<T> findAllById(Set<Object> ids);

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
    List<T> findAll(T entity, int pageNumber, int pageSize);

    /**
     * 新增
     * @param entity 新增的对象
     * @return 主键
     */
    int insert(T entity);

    /**
     * 更新
     * @param entity 更新的对象
     * @return 是否更新成功
     */
    boolean update(T entity);

    /**
     * 主键删除
     * @param id 主键
     * @return 是否删除成功
     */
    boolean deleteById(Object id);

    /**
     * 条件删除
     * @param entity 删除条件
     */
    boolean delete(T entity);

    /**
     * 是否存在对象
     * @param id 主键
     * @return boolean
     */
    boolean existsById(Object id);

    /**
     * 符合条件的对象个数
     * @param entity 查询条件
     * @return long
     */
    long count(T entity);

}
