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
    /**
     * 插入类别数据
     *
     * @param category 类别数据
     * @return 受影响的行数
     */
    int insert1(Category category);

    /**
     * 统计种类数据的数量
     *
     * @return 种类数据的数量
     */
    int countC();

    /**
     * 根据id获取类别的标准信息
     *
     * @param id 类别id
     * @return 返回匹配的类别的标准信息，如果没有匹配的数据，将返回null
     */
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
     * 根据父级类别的id查询类别列表
     *
     * @param parentId 父级类别的id
     * @return 类别列表
     */
    List<CategoryListItemVO> listByParentId(Long parentId);


    /**
     * 根据类别名称统计当前表中类别数据的数量
     *
     * @param name 类别名称
     * @return 当前表中匹配名称的类别数据的数量
     */
    int countCategoryByName(String name);

    /**
     * 根据父级类别，统计其子级类别的数量
     *
     * @param parentId 父级类别的id
     * @return 此类别的子级类别的数量
     */
    int countByParentId(Long parentId);
}
