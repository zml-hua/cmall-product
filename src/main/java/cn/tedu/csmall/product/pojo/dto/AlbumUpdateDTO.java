package cn.tedu.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AlbumUpdateDTO implements Serializable {
    /**
     * 相册简介
     */
    @ApiModelProperty(value = "相册简介", example = "小米80的相册的简介", required = true)
    private String description;

    /**
     * 自定义排序序号
     */
    @ApiModelProperty(value = "自定义排序序号", example = "88", required = true)
    private Integer sort;
}
