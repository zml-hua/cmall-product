package cn.tedu.csmall.product.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 相册列表项VO
 *
 * @author zml
 * @version 0.0.1
 */
@Data
public class AlbumListItemVO {
    /**
     * 记录id
     */
    private Long id;

    /**
     * 相册名称
     */
    private String name;

    /**
     * 相册简介
     */
    private String description;

    /**
     * 自定义排序序号
     */
    private Integer sort;
}
