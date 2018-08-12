package com.example.demo.converter;

import com.example.demo.enums.DemoEnum;

import javax.persistence.AttributeConverter;

/**
 * DemoEnum JPA自定义转换器:
 * AttributeConverter<attribute, database>
 * 在entity.Demo对象的DemoEnum类型的getter属性上添加@Convert(converter = DemoEnumConverter.class)
 *
 * @author zcy
 * @date 2018/07/11
 */
public class DemoEnumConverter implements AttributeConverter<DemoEnum, Integer> {

    /**
     * 将DemoEnum类型属性存入数据库时调用的方法
     * @param attribute 对象中的DemoEnum类型属性
     * @return DemoEnum类型存入数据库时的实际值
     */
    @Override
    public Integer convertToDatabaseColumn(DemoEnum attribute) {
        // 存入数据库时，无值时返回null存入数据库
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    /**
     * 从数据库中取出数据赋值给DemoEnum类型属性时调用的方法
     * @param dbData 数据库中存储的DemoEnum类型实际值
     * @return 数据库中存储值对应value的DemoEnum
     */
    @Override
    public DemoEnum convertToEntityAttribute(Integer dbData) {
        // 从数据库中取值时，如果数据库中为null值返回
        if (dbData == null) {
            return null;
        }
        return DemoEnum.findByValue(dbData);
    }
}
