package com.example.demo.repository;

import com.example.demo.entity.DemoDO;
import com.example.demo.repository.base.BaseRepository;
import com.example.demo.repository.customer.DemoRepositoryCustom;

/**
 * JPARepository接口示例
 *
 * @author zcy
 * @date 2018/07/09
 */
public interface DemoRepository extends BaseRepository<DemoDO, Long>, DemoRepositoryCustom {
}
