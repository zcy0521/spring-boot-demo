package com.example.demo.mapper;

import com.example.demo.entity.DemoDO;
import com.example.demo.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * MyBatisMapper示例
 *
 * @author zcy
 * @date 2018/07/10
 */
@Mapper
public interface DemoMapper extends BaseMapper<DemoDO> {
}
