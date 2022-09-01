package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
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

    /**
     * 根据多个id批量删除相册
     *
     * @param ids 期望删除的多个相册数据的id
     * @return 受影响的行数
     */
    int deleteAlbumByIds(Long... ids);

    /**
     * 根据id修改相册数据详情
     *
     * @param album 封装了id与新数据的相册对象
     * @return 受影响的行数
     */
    int updateAlbumById(Album album);

    /**
     * 统计相册数据的数量
     *
     * @return 相册数据的数量
     */
    int countAlbum();


    /**
     * 根据id获取品牌详情
     *
     * @param id 相册id
     * @return 返回与id匹配的相册数据详情，如果没有匹配的数据，则返回null
     */
     AlbumStandardVO getAlbumStandardById(Long id);

    /**
     * 查询品牌列表
     *
     * @return 品牌列表，如果没有匹配的品牌，将返回长度为0的列表
     */
    List<AlbumListItemVO> listAlbum();

    /**
     * 根据相册名称统计当前表中相册数据的数量
     *
     * @param name 相册名称
     * @return 当前表中匹配名称的相册数据的数量
     */
    int countAlbumByName(String name);

}
