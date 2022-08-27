package cn.tedu.csmall.product.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

//SKU规格参数表（存储各SKU的属性与值，即规格参数）
@Data
public class SKUSpecification {
    Long id;//记录id
    Long skuId;//SKU id
    Long attributeId;//属性id
    String attributeName;//属性名称
    String attributeValue;//属性值
    String unit;//自动补充的计量单位
    Integer sort;//自定义排序序号
    LocalDateTime gmtCreate;//数据创建时间
    LocalDateTime gmtModified;//数据最后修改时间
}
