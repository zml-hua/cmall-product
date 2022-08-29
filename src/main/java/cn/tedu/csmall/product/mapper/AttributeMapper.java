package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.entity.Attribute;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  处理相册数据的Mapper接口
 *
 *  @author zml
 *  @version 0.0.1
 */
@Repository
public interface AttributeMapper {

 /*   *//**
    *插入相册数据
    *
    * @param attribute 品牌数据的对象
    * @return 受影响的额行数
    *//*
    int insertAttribute(Attribute attribute);

    *//**
     * 根据id删除品牌数据
     * @param id 参数
     * @return 受影响的行数
     *//*
    int deleteAttributeById(Long id);

    *//*int deleteByIds(List<Long> ids);*//*
    *//*int deleteByIds(Long[] ids);*//*

    int deleteAttributeByIds(Long... ids);

    int updateAttributeById(Album album);

    *//**
     * 统计品牌数据的数量
     *
     * @return 品牌数据的数量
     *//*
    int countAttribute();


    *//**
     * 根据id获取品牌详情
     *
     * @param id 品牌id
     * @return 返回与id匹配的品牌数据详情，如果没有匹配的数据，则返回null
     *//*
    AttributeStandardVO getAttributeStandardById(Long id);

    *//**
     * 查询品牌列表
     *
     * @return 品牌列表，如果没有匹配的品牌，将返回长度为0的列表
     *//*
    List<AttributeListItemVO> listAttribute();

    int countAttributeByName(String name);*/

}
