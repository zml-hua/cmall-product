package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;

public interface ICategoryService {
    /**
     * 添加品牌
     * @param categoryAddNewDTO 品牌数据
     */
    void addNew(CategoryAddNewDTO categoryAddNewDTO);

}
