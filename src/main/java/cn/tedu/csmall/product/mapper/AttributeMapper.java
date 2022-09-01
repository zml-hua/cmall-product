package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.entity.Attribute;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.pojo.vo.AttributeListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  处理属性数据的Mapper接口
 *
 *  @author zml
 *  @version 0.0.1
 */
@Repository
public interface AttributeMapper {

/**
    *插入属性数据
    *
    * @param attribute 属性数据的对象
    * @return 受影响的额行数
    */
    int insertAttribute(Attribute attribute);

    /**
     * 根据id删除属性数据
     * @param id 参数
     * @return 受影响的行数
     */
    int deleteAttributeById(Long id);

    /**
     * 根据多个id批量删除属性数据
     *
     * @param ids 期望删除的若干个属性数据的id
     * @return 受影响的行数，将返回成功删除的数据量
     */
    int deleteAttributeByIds(Long... ids);

    /**
     * 根据id修改属性数据详情
     *
     * @param attribute 封装了id与新数据的属性对象
     * @return 受影响的行数
     */
    int updateAttributeById(Attribute attribute);

    /**
     * 统计当前表中属性数据的数量
     *
     * @return 当前表中属性数据的数量
     */
    int countAttribute();


    /**
     * 根据id获取属性详情
     *
     * @param id 属性id
     * @return 返回与id匹配的属性数据详情，如果没有匹配的数据，则返回null
     */
    AttributeStandardVO getAttributeStandardById(Long id);

    /**
     * 查询属性列表
     *
     * @return 品牌列表，如果没有匹配的属性，将返回长度为0的列表
     */
    List<AttributeListItemVO> listAttribute();

}
