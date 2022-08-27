package cn.tedu.csmall.product.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

//类别与属性模版关联表
@Data
public class CategoryAttributeTemplate {
    Long id;//记录id',
    Long categoryId;//类别id',
    Long attributeTemplateId;//属性模版id',
    LocalDateTime gmtCreate;//数据创建时间',
    LocalDateTime gmtModified;//数据最后修改时间',
}
