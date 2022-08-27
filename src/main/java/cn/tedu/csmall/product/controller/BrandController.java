package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.mapper.BrandMapper;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Brand;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody // 响应正文
@RestController
public class BrandController {
    @Autowired
    BrandMapper brandMapper;

    //http://localhost:9080/add-new
    @RequestMapping("/add-new")
    public String addNew(BrandAddNewDTO brandAddNewDTO){
        System.out.println("即将处理【添加品牌】的请求……");
        System.out.println("brandAddNewDTO = " + brandAddNewDTO);

        //检查品牌名称是否已经被占用
        int count = brandMapper.countByName(brandAddNewDTO.getName());
        if (count>0){
            return "新增失败，品牌已存在";
        }

        Brand brand = new Brand();
        /*brand.setName(brandAddNewDTO.getName());*/
        BeanUtils.copyProperties(brandAddNewDTO,brand);
        brand.setSales(0);
        brand.setProductCount(0);
        brand.setPositiveCommentCount(0);

        brandMapper.insert(brand);

        return "已经完成处理【添加品牌】的请求";
    }

    // http://localhost:9080/delete
    @RequestMapping("/delete")
    public String delete() {
        System.out.println("即将处理【删除品牌】的请求……");

        return "已经完成处理【删除品牌】的请求";
    }
}
