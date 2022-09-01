package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Picture;
import cn.tedu.csmall.product.pojo.vo.PictureListItemVO;
import cn.tedu.csmall.product.pojo.vo.PictureStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureMapper {

    /**
     * 插入图片数据
     *
     * @param picture 图片数据
     * @return 受影响的行数
     */
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


    /**
     * 根据id获取图片的标准信息
     *
     * @param id 图片id
     * @return 返回匹配的图片的标准信息，如果没有匹配的数据，将返回null
     */
    PictureStandardVO getStandardByIdP(Long id);

    /**
     * 根据相册查询图片列表
     *
     * @param albumId 相册id
     * @return 匹配的图片列表，如果没有匹配的数据，则返回长度为0的列表
     */
    List<PictureListItemVO> listPicture(Long albumId);
}
