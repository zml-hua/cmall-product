package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryAddNewDTO implements Serializable {

    private String name;
    private Long parentId;
    private String description;
    private String keywords;
    private Integer sort;
    private String icon;
    private Integer enable;
    private Integer isDisplay;
}
