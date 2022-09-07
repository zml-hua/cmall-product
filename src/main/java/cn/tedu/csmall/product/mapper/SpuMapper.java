package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.SPU;
import org.springframework.stereotype.Repository;

@Repository
public interface SpuMapper {
    /**
     * 插入SPU数据
     *
     * @param spu SPU数据
     * @return 受影响的行数
     */
    int insert(SPU spu);

    /**
     * 根据id删除SPU
     *
     * @param id 被删除的SPU的id
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 根据多个id批量删除SPU数据
     *
     * @param ids 期望删除的多个SPU数据的id
     * @return 受影响的行数，将返回成功删除的数据量
     */
    int deleteByIds(Long... ids);

    /**
     * 根据品牌统计SPU数量
     *
     * @param brandId 品牌ID
     * @return 关联了此品牌的SPU数量
     */
    int countByBrand(Long brandId);

    /**
     * 根据类别统计SPU数量
     *
     * @param categoryId 品牌ID
     * @return 关联了此类别的SPU数量
     */
    int countByCategory(Long categoryId);

    /**
     * 根据相册统计SPU数量
     *
     * @param albumId 相册ID
     * @return 关联了此相册的SPU数量
     */
    int countByAlbum(Long albumId);
}
