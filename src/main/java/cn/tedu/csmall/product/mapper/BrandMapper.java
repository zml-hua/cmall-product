package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  处理品牌数据的Mapper接口
 *
 *  @author zml
 *  @version 0.0.1
 */
@Repository
public interface BrandMapper {

    /**
    *插入品牌数据
    *
    * @param brand 品牌数据的对象
    * @return 受影响的额行数
    */
    int insert(Brand brand);

    /**
     * 根据id删除品牌数据
     * @param id 参数
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /*int deleteByIds(List<Long> ids);*/
    /*int deleteByIds(Long[] ids);*/

    int deleteByIds(Long... ids);

    int updateById(Brand brand);

    /**
     * 统计品牌数据的数量
     *
     * @return 品牌数据的数量
     */
    int count();


    /**
     * 根据id获取品牌详情
     *
     * @param id 品牌id
     * @return 返回与id匹配的品牌数据详情，如果没有匹配的数据，则返回null
     */
    BrandStandardVO getStandardById(Long id);

    /**
     * 查询品牌列表
     *
     * @return 品牌列表，如果没有匹配的品牌，将返回长度为0的列表
     */
    List<BrandListItemVO> list();

    /**
     * 根据品牌名称统计数据的数量
     *
     * @param name 品牌名称
     * @return 匹配名称的品牌数据的数量
     */
    int countByName(String name);

}
