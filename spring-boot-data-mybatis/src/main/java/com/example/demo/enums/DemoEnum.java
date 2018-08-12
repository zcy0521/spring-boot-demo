package com.example.demo.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 枚举示例
 *
 * @author zcy
 * @date 2018/07/11
 */
public enum DemoEnum {

    /**
     * 枚举UNKNOWN
     */
    ENUM_UNKNOWN(10, "未知"),

    /**
     * 枚举A
     */
    ENUM_A(11, "枚举A"),

    /**
     * 枚举B
     */
    ENUM_B(12, "枚举B"),

    /**
     * 枚举value值
     */
    ENUM_C(13, "枚举C", true);

    DemoEnum(int value, String description) {
        this.value = value;
        this.description = description;
        this.disabled = false;
    }

    DemoEnum(int value, String description, boolean disabled) {
        this.value = value;
        this.description = description;
        this.disabled = disabled;
    }

    /**
     * 枚举常量value值
     */
    private int value;

    /**
     * 枚举常量描述
     */
    private String description;

    /**
     * 是否被禁用 true禁用
     */
    private boolean disabled;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }


    /**
     * findByValue
     *
     * jpa.converter.enums.DemoEnumConverter 使用
     * DemoEnumConverter implements AttributeConverter<DemoEnum, Integer>
     * DemoEnumConverter 类上添加注释@Converter
     * Entity 中DemoEnum类型字段getter方法上添加注释@Convert(converter = DemoEnumConverter.class)
     * 依赖 hibernate-jpa-2.1-api-1.0.0.Final.jar (注意 : hibernate-jpa-2.0版本无效)
     * saveEntity()时 jpa会将DemoEnum的value值存入数据库
     * findEntity()时 jpa会将数据库中取出的值解析为对应value值的DemoEnum
     *
     * web.StringToDemoEnumConverter 使用
     * ValueToDemoEnumConverter implements Converter<String, DemoEnum>
     * applicationContext-mvc.xml中设置converters : StringToDemoEnumConverter
     * 依赖 springMvc
     * 接收前台传值时 前台应传递DemoEnum的(String)value值 springMvc会将value值解析为对应的DemoEnum
     */
    public static DemoEnum findByValue(int value) {
        for (DemoEnum demoEnum : DemoEnum.values()) {
            if (demoEnum.value == value) {
                return demoEnum;
            }
        }
        return DemoEnum.ENUM_UNKNOWN;
    }

    /**
     * findAll
     *
     * 向前台传递枚举列表时使用
     * Controller中添加Enum[] : model.addAttribute("demoEnums", DemoEnum.findAll());
     * 页面 : <form:select path="demoEnum" items="${demoEnums}" itemLabel="name" itemValue="name or value"/>
     */
    public static DemoEnum[] findAll() {
        List<DemoEnum> result = new ArrayList<>();
        for (DemoEnum demoEnum : DemoEnum.values()) {
            //禁用时select中不现实该option
            if (!demoEnum.disabled) {
                result.add(demoEnum);
            }
        }
        return result.toArray(new DemoEnum[result.size()]);
    }

}
