package cn.tedu.csmall.product.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

//SKU（Stock Keeping Unit）表
@Data
public class SKU {
    Long id;//记录id
    Long spuId;//SPU id
    String title;//标题
    String barCode;//条型码
    Long attributeTemplateId;//属性模版id
    String specifications;//全部属性，使用JSON格式表示（冗余）
    Long albumId;//相册id
    String pictures;//组图URLs，使用JSON格式表示
    Double price;//单价
    Integer stock;//当前库存
    Integer stockThreshold;//库存预警阈值
    Integer sales;//销量（冗余）
    Integer commentCount;//买家评论数量总和（冗余）
    Integer positiveCommentCount;//买家好评数量总和（冗余）
    Integer sort;//自定义排序序号
    LocalDateTime gmtCreate;//数据创建时间
    LocalDateTime gmtModified;//数据最后修改时间
}
