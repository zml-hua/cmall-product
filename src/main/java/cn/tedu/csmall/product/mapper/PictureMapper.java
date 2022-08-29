package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Picture;
import cn.tedu.csmall.product.pojo.vo.PictureListItemVO;
import cn.tedu.csmall.product.pojo.vo.PictureStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureMapper {
    int insert2(Picture picture);

    /**
     * 根据id删除品牌数据
     * @param id 参数
     * @return 受影响的行数
     */
    int deletePictureById(Long id);

    /*int deleteByIds(List<Long> ids);*/
    /*int deleteByIds(Long[] ids);*/

    int deletePictureByIds(Long... ids);

    int countP();

    PictureStandardVO getStandardByIdP(Long id);

    List<PictureListItemVO> listPicture();
}
