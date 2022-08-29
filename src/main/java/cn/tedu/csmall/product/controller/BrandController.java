package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody // 响应正文
@RestController
public class BrandController {
    @Autowired
    private IBrandService brandService;

    //http://localhost:9080/add-new
    @RequestMapping("/add-new")
    public String addNew(BrandAddNewDTO brandAddNewDTO){
        System.out.println("即将处理【添加品牌】的请求……");
        System.out.println("brandAddNewDTO = " + brandAddNewDTO);

        try {
            brandService.addNew(brandAddNewDTO);
            return "已经完成处理【添加品牌】的请求";
        } catch (ServiceException e) {
            return e.getMessage();
        }
    }

    // http://localhost:9080/delete
    @RequestMapping("/delete")
    public String delete() {
        System.out.println("即将处理【删除品牌】的请求……");

        return "已经完成处理【删除品牌】的请求";
    }
}
