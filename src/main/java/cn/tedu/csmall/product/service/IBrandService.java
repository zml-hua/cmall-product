package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.BrandUpdateDTO;

public interface IBrandService {
    /**
     * 添加品牌
     * @param brandAddNewDTO 品牌数据
     */
    void addNew(BrandAddNewDTO brandAddNewDTO);

    /**
     *根据品牌id，删除品牌数据
     *
     * @param id 尝试删除的品牌的id
     */
    void deleteById(Long id);

    void setEnable(Long id);

    void setDisable(Long id);

    /**
     * 根据品牌id，修改品牌详情
     *
     * @param id             品牌id
     * @param brandUpdateDTO 新的品牌数据
     */
    void updateById(Long id, BrandUpdateDTO brandUpdateDTO);
}
