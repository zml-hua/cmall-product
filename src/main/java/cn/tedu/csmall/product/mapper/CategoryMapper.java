package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

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
}
