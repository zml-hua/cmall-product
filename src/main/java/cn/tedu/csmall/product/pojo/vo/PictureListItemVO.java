package cn.tedu.csmall.product.pojo.vo;

import lombok.Data;

@Data
public class PictureListItemVO {
    private Long id;
    private Long albumId;
    private String url;
    private String description;
    private Short width;
    private Short height;
    private Integer isCover;
    private Integer sort;
}
