package cn.tedu.csmall.product.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/albums")
@Api(tags = "03. 相册管理模块")
public class AlbumController {

    public AlbumController() {
        log.info("创建控制器：AlbumController");
    }


    @GetMapping("/test")
    public void test() {}

}
