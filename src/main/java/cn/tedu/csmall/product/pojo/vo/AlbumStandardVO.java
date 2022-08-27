package cn.tedu.csmall.product.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AlbumStandardVO {
    private Long id;
    private String name;
    private String description;
    private Integer sort;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
