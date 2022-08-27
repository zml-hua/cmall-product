package cn.tedu.csmall.product.pojo.entity;

import com.sun.org.apache.bcel.internal.generic.DADD;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BrandCategory {
   private Long id;
    private Long brandId;
    private Long categoryId;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
