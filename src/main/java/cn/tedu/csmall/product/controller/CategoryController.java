package cn.tedu.csmall.product.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/categories")
@Api(tags = "01. 类别管理模块")
public class CategoryController {

    @GetMapping("/test")
    public void test() {}

}
