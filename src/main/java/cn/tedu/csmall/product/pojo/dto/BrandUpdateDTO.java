package cn.tedu.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class BrandUpdateDTO implements Serializable {
    /**
     * 品牌名称的拼音
     */
    @ApiModelProperty(value = "品牌名称的拼音")
    private String pinyin;

    /**
     * 品牌logo的URL
     */
    @ApiModelProperty("品牌logo的URL")
    private String logo;

    /**
     * 品牌简介
     */
    @ApiModelProperty("品牌简介")
    private String description;

    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    @ApiModelProperty("关键词列表，各关键词使用英文的逗号分隔")
    private String keywords;

    /**
     * 自定义排序序号
     */
    @ApiModelProperty(value = "自定义排序序号")
    private Integer sort;
}
