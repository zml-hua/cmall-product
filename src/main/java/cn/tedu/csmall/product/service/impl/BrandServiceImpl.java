package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceCode;
import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.BrandMapper;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.BrandUpdateDTO;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import cn.tedu.csmall.product.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    BrandMapper brandMapper;

    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO) {
        log.debug("开始处理【添加品牌】的业务：{}",brandAddNewDTO);
        // 检查品牌名称是否已经被占用
        int count = brandMapper.countByName(brandAddNewDTO.getName());
        if (count > 0) {
            // return "增加品牌失败！品牌名称【" + brandAddNewDTO.getName() + "】已经被占用！";
            String message = "添加品牌失败！品牌名称【" + brandAddNewDTO.getName() + "】已经被占用！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);
        }

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandAddNewDTO, brand);
        brand.setSales(0);
        brand.setProductCount(0);
        brand.setCommentCount(0);
        brand.setPositiveCommentCount(0);
        log.debug("准备插入品牌数据：{}",brand);
        int rows = brandMapper.insert(brand);
        if (rows != 1){
            String message = "添加品牌失败,服务器忙，请稍后再次尝试！";
            ServiceException serviceException = new ServiceException(ServiceCode.ERR_INSERT,message);
//            serviceException.setCode(2);
            throw serviceException;
        }
    }

    @Override
    public void deleteById(Long id) {
        // 调用Mapper对象的getDetailsById()方法执行查询
        BrandStandardVO queryResult = brandMapper.getStandardById(id);
        // 判断查询结果是否为null
        if (queryResult == null) {
            // 是：此id对应的数据不存在，则抛出异常(ERR_NOT_FOUND)
            String message = "删除品牌失败，尝试删除的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }

        // 调用Mapper对象的deleteById()执行删除，并获取返回值
        int rows = brandMapper.deleteById(id);
        // 判断以上返回值是否不为1
        if (rows !=1){
            // 是：此id抛出异常(ERR_DELETE)
            String message = "删除品牌失败，服务器正忙，请稍后再次尝试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_DELETE,message);
        }

    }

    @Override
    public void setEnable(Long id) {
        // 调用Mapper对象的getDetailsById()方法执行查询
        BrandStandardVO queryResult = brandMapper.getStandardById(id);
        // 判断查询结果是否为null
        if (queryResult == null) {
            // 是：此id对应的数据不存在，则抛出异常(ERR_NOT_FOUND)
            String message = "启用品牌失败，尝试访问的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        // 判断查询结果中的enable是否为1
        if (queryResult.getEnable() == 1) {
            // 是：此id对应的品牌已经是启用状态，则抛出异常(ERR_CONFLICT)
            String message = "已是启用状态";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);
        }
        // 创建Brand对象（作为修改数据的方法的参数）
        Brand brand = new Brand();
        // 向Brand对象中封装id（参数id）与enable（固定为1）属性的值
        brand.setId(queryResult.getId());
        brand.setEnable(1);
        // 调用Mapper对象的updateById()修改品牌数据，并获取返回值
        int rows = brandMapper.updateById(brand);
        // 判断以上返回值是否不为1
        if (rows == 1){
        // 是：抛出异常(ERR_UPDATE)
            String message = "添加品牌失败，服务器忙，请稍后再次尝试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_INSERT, message);
        }
    }

    @Override
    public void setDisable(Long id) {
        // 调用Mapper对象的getDetailsById()方法执行查询
        BrandStandardVO queryResult = brandMapper.getStandardById(id);
        // 判断查询结果是否为null
        if (queryResult == null) {
            // 是：此id对应的数据不存在，则抛出异常(ERR_NOT_FOUND)
            String message = "禁用品牌失败，尝试访问的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        // 判断查询结果中的enable是否为1
        if (queryResult.getEnable() == 0) {
            // 是：此id对应的品牌已经是启用状态，则抛出异常(ERR_CONFLICT)
            String message = "已是禁用状态";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);
        }
        // 创建Brand对象（作为修改数据的方法的参数）
        Brand brand = new Brand();
        // 向Brand对象中封装id（参数id）与enable（固定为1）属性的值
        brand.setId(queryResult.getId());
        brand.setEnable(0);
        // 调用Mapper对象的updateById()修改品牌数据，并获取返回值
        int rows = brandMapper.updateById(brand);
        // 判断以上返回值是否不为1
        if (rows == 1){
            // 是：抛出异常(ERR_UPDATE)
            String message = "禁用失败，服务器忙，请稍后再次尝试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE, message);
        }

    }

    @Override
    public void updateById(Long id, BrandUpdateDTO brandUpdateDTO) {
        log.debug("开始处理【修改品牌详情】的业务，参数：{}", id);
        // 调用Mapper对象的getDetailsById()方法执行查询
        BrandStandardVO queryResult = brandMapper.getStandardById(id);
        // 判断查询结果是否为null
        if (queryResult == null) {
            // 是：此id对应的数据不存在，则抛出异常(ERR_NOT_FOUND)
            String message = "修改品牌详情失败，尝试访问的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        Brand brand = new Brand();
        BeanUtils.copyProperties(brandUpdateDTO, brand);
        brand.setId(id);

        // 修改数据
        log.debug("即将修改数据：{}", brand);
        int rows = brandMapper.updateById(brand);
        if (rows != 1) {
            String message = "修改品牌详情失败，服务器忙，请稍后再次尝试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE, message);
        }
    }
}
