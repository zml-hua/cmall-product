package cn.tedu.csmall.product.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttributeListItemVO {
    Long id;//记录id
    Long templateId;//所属属性模版id
    String name;//属性名称
    String description;//简介（某些属性名称可能相同，通过简介补充描述）
    Integer type;//属性类型，1=销售属性，0=非销售属性
    Integer inputType;//输入类型，0=手动录入，1=单选，2=多选，3=单选（下拉列表），4=多选（下拉列表）
    String valueList;//备选值列表
    String unit;//计量单位
    Integer sort;//自定义排序序号
    Integer isAllowCustomize;//是否允许自定义，1=允许，0=禁止
}
