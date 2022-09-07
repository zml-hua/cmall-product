package cn.tedu.csmall.product.pojo.entity;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BrandCategory {
   private Long id;
    private Long brandId;
    private Long categoryId;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
