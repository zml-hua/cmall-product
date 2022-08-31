package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceCode;
import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.CategoryMapper;
import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import cn.tedu.csmall.product.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void addNew(CategoryAddNewDTO categoryAddNewDTO) {
        log.debug("开始处理【添加类别】的业务：{}",categoryAddNewDTO);
        // 调用Mapper对象的【根据名称统计数量】方法进行统计
        int count = categoryMapper.countCategoryByName(categoryAddNewDTO.getName());
        // 判断统计结果是否大于0
        if (count > 0) {
            // 是：名称已经被占用，抛出异常（CONFLICT）
            String message = "添加种类失败！类别名称【" + categoryAddNewDTO.getName() + "】已经被占用！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);
        }

        // 声明局部变量depth，默认值为1
        Integer depth = 1;
        CategoryStandardVO parentCategory = null;
        // 取出参数中的parentId
        Long parentId = categoryAddNewDTO.getParentId();
        // 判断parentId是否不为0
        if (parentId != 0) {
            // 是：调用Mapper对象的【根据id查询详情】，使用parentId作为参数，执行查询
            parentCategory = categoryMapper.getCategoryStandardById(parentId);
            // -- 判断查询结果是否不为null
            if (parentCategory != null) {
                // -- 是：局部变量depth=父级depth+1
                depth +=parentCategory.getDepth();
            }else {
                // -- 否：父级类别不存在，抛出异常（NOT_FOUND）
                String message = "添加种类失败！选定的父级类别不存在！";
                log.warn(message);
                throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
            }
        }
        // 创建Category实体类的对象
        Category category = new Category();
        // 将参数DTO的各属性值复制到Category实体类对象中
        BeanUtils.copyProperties(categoryAddNewDTO, category);
        // 补全Category实体类对象的属性：depth
        category.setDepth(0);
        // 补全Category实体类对象的属性：is_parent：固定为0
        category.setIsParent(0);
        // 调用Mapper对象的方法，将数据插入到数据库，并获取返回值
        log.debug("准备插入品牌数据：{}",category);
        int rows = categoryMapper.insert1(category);
        if (rows != 1){
            // -- -- -- 是：抛出异常（ERR_UPDATE）
            String message = "添加类别失败,服务器忙，请稍后再次尝试！";
            ServiceException serviceException = new ServiceException(ServiceCode.ERR_INSERT,message);
            throw serviceException;
        }

        // 判断parentId是否不为0
        if (parentId !=0) {
            // 是：判断父级类别的isParent是否为0
            if (parentCategory.getParentId() == 0) {
                // -- 是：创建新的Category对象，封装：parentId，isParent(1)
                Category updateParentCategory = new Category();
                updateParentCategory.setId(parentId);
                updateParentCategory.setIsParent(1);
                // -- -- 调用Mapper对象的【更新】方法，执行修改数据，并获取返回值
                int updateRows = categoryMapper.updateCategoryById(updateParentCategory);
                // -- -- 判断返回值是否不为1
                if (updateRows != 1) {
                    // 是：抛出异常（ERR_UPDATE）
                    String message = "添加类别失败，服务器忙，请稍后再尝试！";
                    log.warn(message);
                    throw new ServiceException(ServiceCode.ERR_UPDATE, message);
                }
            }
        }
    }
}
