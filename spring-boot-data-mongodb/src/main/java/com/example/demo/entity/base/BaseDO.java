package com.example.demo.entity.base;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Base实体
 * @author zcy
 */
@Data
@MappedSuperclass
public class BaseDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="gmt_create")
    private Date gmtCreate;

    @Column(name="gmt_modified")
    private Date gmtModified;

}
