package cn.tedu.csmall.product.pojo.entity;

import java.time.LocalDateTime;

//SPU详情表
public class SPUDetail {
    Long id;//记录id
    Long spuId;//SPU id
    String detail;//SPU详情，应该使用HTML富文本，通常内容是若干张图片
    LocalDateTime gmtCreate;//数据创建时间
    LocalDateTime gmtModified;//数据最后修改时间
}
