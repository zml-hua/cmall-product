package cn.tedu.csmall.product.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PictureStandardVO implements Serializable {
    private Long id;
    private Long albumId;
    private String url;
    private String description;
    private Short width;
    private Short height;
    private Integer isCover;
    private Integer sort;
}
