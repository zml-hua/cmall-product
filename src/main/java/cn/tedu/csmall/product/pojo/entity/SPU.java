package cn.tedu.csmall.product.pojo.entity;

import java.time.LocalDateTime;

//SPU（Standard Product Unit）表
public class SPU {
    Long id;//记录id
    String name;//SPU名称
    String typeNumber;//SPU编号
    String title;//标题
    String description;//简介
    Double listPrice;//价格（显示在列表中）
    Integer stock;//当前库存（冗余）
    Integer stockThreshold;//库存预警阈值（冗余）
    String unit;//计件单位
    Long brandId;//品牌id
    String brandName;//品牌名称（冗余）
    Long categoryId;//类别id
    String categoryName;//类别名称（冗余）
    Long attributeTemplateId;//属性模版id
    Long albumId;//相册id
    String pictures;//组图URLs，使用JSON数组表示
    String keywords;//关键词列表，各关键词使用英文的逗号分隔
    String tags;//标签列表，各标签使用英文的逗号分隔，原则上最多3个
    Integer sales;//销量（冗余）
    Integer commentCount;//买家评论数量总和（冗余）
    Integer positiveCommentCount;//买家好评数量总和（冗余）
    Integer sort;//自定义排序序号
    Integer isDeleted;//是否标记为删除，1=已删除，0=未删除
    Integer isPublished;//是否上架（发布），1=已上架，0=未上架（下架）
    Integer isNewArrival;//是否新品，1=新品，0=非新品
    Integer isRecommend;//是否推荐，1=推荐，0=不推荐
    Integer isChecked;//是否已审核，1=已审核，0=未审核
    String checkUser;//审核人（冗余）
    LocalDateTime gmtCheck;//审核通过时间（冗余）
    LocalDateTime gmtCreate;//数据创建时间
    LocalDateTime gmtModified;//数据最后修改时间
}
