package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class BrandMapperTests {

    @Autowired
    BrandMapper mapper;

    @Test
    void testInsert() {
        Brand brand = new Brand();
        brand.setName("测试品牌998");
        log.debug
("插入品牌之前，参数对象=" + brand);
        int rows = mapper.insert(brand);
        log.debug("插入品牌完成，受影响的行数={}",rows);
        log.debug("插入品牌之后，参数对象={}",brand);
    }

    @Test
    void testDeleteById() {
        Long id = 10L;
        int rows = mapper.deleteById(id);
        log.debug("根据id删除品牌完成，受影响的行数={}",rows);
    }

    @Test
    void testDeleteByIds(){
      /*  List<Long> ids = new ArrayList<>();
        ids.add(8L);
        ids.add(9L);*/

        /*int rows = mapper.deleteByIds(ids);*/
/*
        Long[] ids = {7L,6L};

        int rows = mapper.deleteByIds(ids);*/

        int rows = mapper.deleteByIds(11L,12L);
        log.debug("根据id批量删除品牌完成，受影响的行数={}",rows);
    }

    @Test
    void testGetStandardById(){
        Long id = 3L;
        BrandStandardVO result = mapper.getStandardById(id);
        log.info("根据id={}查询品牌详情，结果={}",id,result);
    }

    @Test
    void  testCount() {
        int count = mapper.count();
    }

    @Test
    void testList(){
        List<BrandListItemVO> list = mapper.list();
        log.debug("品牌受影响数量：{}",list.size());
        for (BrandListItemVO brandListItemVO : list) {
            log.debug("{}",brandListItemVO);
        }
    }

    @Test
    void testCountByName(){
        String name = "小米";
        int count = mapper.countByName(name);
        log.debug("count={}",count);
    }


}
