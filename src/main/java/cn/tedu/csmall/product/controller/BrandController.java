package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.service.IBrandService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody // 响应正文
@RestController
@Slf4j
@RequestMapping("/brands")
@Api(tags = "02. 品牌管理模块")
public class BrandController {
    @Autowired
    private IBrandService brandService;

    // http://localhost:9080/brands/add-new
    @ApiOperation("添加品牌")
    @ApiOperationSupport(order = 100)
    @RequestMapping("/add-new")
    public JsonResult addNew(BrandAddNewDTO brandAddNewDTO){
        System.out.println("即将处理【添加品牌】的请求……");
        System.out.println("brandAddNewDTO = " + brandAddNewDTO);

        brandService.addNew(brandAddNewDTO);
        return JsonResult.ok();
    }

    // http://localhost:9080/delete
    @ApiOperation("删除品牌")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id",value = "品牌id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> delete(@PathVariable Long id) {
        log.debug("即将处理【删除品牌】的请求，id={}", id);

        brandService.deleteById(id);
        return JsonResult.ok();
    }

    // http://localhost:9080/brands/enable?id=1
    @ApiOperation("启用品牌")
    @ApiOperationSupport(order = 300)
    @ApiImplicitParam(name = "id",value = "品牌id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/enable\"")
    public JsonResult<Void> setEnable(Long id) {
        log.debug("即将处理【启用品牌】的请求，id={}", id);

        brandService.setEnable(id);
        return JsonResult.ok();
    }

    // http://localhost:9080/brands/disable?id=1
    @ApiOperation("禁用品牌")
    @ApiOperationSupport(order = 301)
    @ApiImplicitParam(name = "id",value = "品牌id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/disable")
    public JsonResult<Void> setDisable(Long id) {
        log.debug("即将处理【禁用品牌】的请求，id={}", id);

        brandService.setDisable(id);
        return JsonResult.ok();
    }

    // http://localhost:9080/brands/hello/delete
    @ApiOperation("测试根据名称删除品牌")
    @ApiOperationSupport(order = 900)
    @PostMapping("/{name:[a-zA-Z]+}/delete")
    public String delete(@PathVariable String name) {
        log.debug("接收到【根据名称删除品牌（测试）】的请求，品牌名={}", name);
        throw new RuntimeException("此接口仅用于测试，并未实现任何功能！");
    }

    // http://localhost:9080/brands/test/delete
    @ApiOperation("测试删除品牌")
    @ApiOperationSupport(order = 901)
    @PostMapping("/test/delete")
    public String delete() {
        log.debug("接收到【删除品牌（测试）】的请求");
        throw new RuntimeException("此接口仅用于测试，并未实现任何功能！");
    }

}

