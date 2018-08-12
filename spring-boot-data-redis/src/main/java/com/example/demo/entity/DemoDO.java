package com.example.demo.entity;

import com.example.demo.converter.DemoEnumConverter;
import com.example.demo.entity.base.BaseDO;
import com.example.demo.enums.DemoEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Demo实体
 *
 * lombok: @Data @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
 * JPA: @Entity @Table(name = "demo")
 * MyBatis: @Table(name = "demo")
 *
 * @author zcy
 * @date 2018/07/11
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "demo")
public class DemoDO extends BaseDO {
    
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

    @Column(name="demo_integer")
    private Integer demoInteger;

    @Column(name="demo_float")
    private Float demoFloat;

    @Column(name="demo_double")
    private Double demoDouble;

    @Column(name="demo_decimal")
    private BigDecimal demoDecimal;

    @Column(name="demo_string")
    private String demoString;

    @Column(name="demo_text")
    private String demoText;

    /**
     * Boolean:
     * MySQL类型为BIT(1)
     * Boolean.TRUE  存1
     * Boolean.FALSE 存0
     */
    @Column(name="demo_boolean")
    private Boolean demoBoolean;

    /**
     * 货币:
     * MySQL类型为DECIMAL(19,2)
     */
    @Column(name="demo_currency")
    private BigDecimal demoCurrency;

    /**
     * 百分比:
     * MySQL类型为DECIMAL(19,4)
     */
    @Column(name="demo_percent")
    private BigDecimal demoPercent;

    /**
     * 日期:
     * MySQL类型为TIMESTAMP
     */
    @Column(name="demo_date")
    private Date demoDate;

    @Column(name="demo_time")
    private Date demoTime;

    @Column(name="demo_date_time")
    private Date demoDateTime;

    /**
     * 枚举:
     * 通过DemoEnumConverter实现枚举自定义持久化规则
     * getter属性上添加@Convert(converter = DemoEnumConverter.class)
     */
    @Column(name="demo_enum")
    @Convert(converter = DemoEnumConverter.class)
    private DemoEnum demoEnum;

    /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

    /*--------------------------------------------
    |  A C C E S S O R S / M O D I F I E R S    |
    ============================================*/

}
