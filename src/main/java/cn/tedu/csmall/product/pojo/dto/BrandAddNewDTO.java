package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrandAddNewDTO implements Serializable {

    private String name;
    private String pinyin;
    private String logo;
    private String description;
    private String keywords;
    private Integer sort;
    private Integer enable;
}
