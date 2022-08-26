package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Picture;
import cn.tedu.csmall.product.pojo.vo.PictureStandardVO;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureMapper {
    int insert2(Picture picture);

    int countP();

    PictureStandardVO getStandardByIdP(Long id);
}
