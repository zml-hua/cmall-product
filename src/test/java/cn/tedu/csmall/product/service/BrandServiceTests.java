package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class BrandServiceTests {

    @Autowired
    IBrandService service;

    @Test
    void testAddNew(){
        BrandAddNewDTO brandAddNewDTO = new BrandAddNewDTO();
        brandAddNewDTO.setName("海尔冰箱");

        try{
            service.addNew(brandAddNewDTO);
            log.debug("添加品牌成功！");
        }catch (ServiceException e){
            log.debug("serviceCode : {}", e.getServiceCode());
            log.debug("message : {}", e.getMessage());
        }
    }

    @Test
    void testDeleteById() {
        Long id = 1L;

        try {
            service.deleteById(id);
            log.debug("删除成功！");
        } catch (ServiceException e) {
            log.debug("serviceCode: {}", e.getServiceCode());
            log.debug("message: {}", e.getMessage());
        }
    }

    @Test
    void testsetEnable() {
        Long id = 2L;

        try {
            service.setEnable(id);
            log.debug("启用成功！");
        } catch (ServiceException e) {
            log.debug("serviceCode: {}", e.getServiceCode());
            log.debug("message: {}", e.getMessage());
        }
    }

    @Test
    void testsetDisable() {
        Long id = 2L;

        try {
            service.setDisable(id);
            log.debug("关闭成功！");
        } catch (ServiceException e) {
            log.debug("serviceCode: {}", e.getServiceCode());
            log.debug("message: {}", e.getMessage());
        }
    }

}
