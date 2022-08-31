package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrandAddNewDTO implements Serializable {

    private Long id;
    private String name;
    private Long parentId;
    private Integer depth;
    private String keywords;
    private Integer sort;
    private String icon;
    private Integer enable;
    private Integer isParent;
    private Integer isDisplay;
}
