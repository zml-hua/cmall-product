package cn.tedu.csmall.product.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 品牌类别关联
 *
 * @author zml
 * @version 0.0.1
 */
@Data
public class BrandCategoryListItemVO implements Serializable {

    /**
     * 记录id
     */
    private Long id;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 类别id
     */
    private Long categoryId;

}
