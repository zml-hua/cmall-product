package cn.tedu.csmall.product.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AlbumListItemVO {
    private Long id;
    private String name;
    private String description;
    private Integer sort;
}
