package cn.tedu.csmall.product.pojo.vo;

import lombok.Data;

@Data
public class CategoryListItemVO {
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
