package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
public class BrandMapperTests {

    @Autowired
    BrandMapper mapper;

    @Test
    void testInsert() {
        Brand brand = new Brand();
        brand.setName("测试品牌998");
        System.out.println("插入品牌之前，参数对象=" + brand);
        int rows = mapper.insert(brand);
        System.out.println("插入品牌完成，受影响的行数=" + rows);
        System.out.println("插入品牌之后，参数对象=" + brand);
    }

    @Test
    void testDeleteById() {
        Long id = 10L;
        int rows = mapper.deleteById(id);
        System.out.println("根据id删除品牌完成，受影响的行数=" + rows);
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
        System.out.println("根据id批量删除品牌完成，受影响的行数=" + rows);
    }

    @Test
    void testGetStandardById(){
        Long id = 3L;
        BrandStandardVO result = mapper.getStandardById(id);
        System.out.println("根据id=" + id + "查询品牌详情，结果=" + result);
    }

    @Test
    void  testCount() {
        int count = mapper.count();
    }

}
