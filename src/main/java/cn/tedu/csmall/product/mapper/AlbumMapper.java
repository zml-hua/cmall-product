package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  处理相册数据的Mapper接口
 *
 *  @author zml
 *  @version 0.0.1
 */
@Repository
public interface AlbumMapper {

    /**
    *插入相册数据
    *
    * @param album 品牌数据的对象
    * @return 受影响的额行数
    */
    int insertAlbum(Album album);

    /**
     * 根据id删除品牌数据
     * @param id 参数
     * @return 受影响的行数
     */
    int deleteAlbumById(Long id);

    /*int deleteByIds(List<Long> ids);*/
    /*int deleteByIds(Long[] ids);*/

    int deleteAlbumByIds(Long... ids);

    int updateAlbumById(Album album);

    /**
     * 统计品牌数据的数量
     *
     * @return 品牌数据的数量
     */
    int countAlbum();


    /**
     * 根据id获取品牌详情
     *
     * @param id 品牌id
     * @return 返回与id匹配的品牌数据详情，如果没有匹配的数据，则返回null
     */
     AlbumStandardVO getAlbumStandardById(Long id);

    /**
     * 查询品牌列表
     *
     * @return 品牌列表，如果没有匹配的品牌，将返回长度为0的列表
     */
    List<BrandListItemVO> list();

    int countAlbumByName(String name);

}
