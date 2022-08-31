package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryListItemVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  处理类别数据的Mapper接口
 *
 *  @author zml
 *  @version 0.0.1
 */
@Repository
public interface CategoryMapper {
    int insert1(Category category);

    /**
     * 统计种类数据的数量
     *
     * @return 种类数据的数量
     */
    int countC();

    CategoryStandardVO getStandardByIdC(Long id);

    /**
     * 根据id删除品牌数据
     * @param id 参数
     * @return 受影响的行数
     */
    int deleteCategoryById(Long id);

    /*int deleteByIds(List<Long> ids);*/
    /*int deleteByIds(Long[] ids);*/

    int deleteCategoryByIds(Long... ids);

    int updateCategoryById(Category category);

    /**
     * 根据id获取品牌详情
     *
     * @param id 品牌id
     * @return 返回与id匹配的品牌数据详情，如果没有匹配的数据，则返回null
     */
    CategoryStandardVO getCategoryStandardById(Long id);

    /**
     * 查询品牌列表
     *
     * @return 品牌列表，如果没有匹配的品牌，将返回长度为0的列表
     */
    List<CategoryListItemVO> listCategory();

    int countCategoryByName(String name);
}
