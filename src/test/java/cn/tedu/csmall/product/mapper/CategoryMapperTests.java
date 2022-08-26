package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryMapperTests {

    @Autowired
   CategoryMapper mapper;

    @Test
    void test1Insert() {
        Category category = new Category();
        category.setName("测试种类998");
        int rows= mapper.insert1(category);
        System.out.printf("插入种类完成，受影响的行数=" + rows);
    }

    @Test
    void  testCountC() {
      int count = mapper.countC();
        System.out.println("统计种类的数量完成，种类的数量=" + count);
     }

     @Test
    void testCetStandardByIdC(){
        Long id = 3L;
         CategoryStandardVO result = mapper.getStandardByIdC(id);
         System.out.println("根据id=" + id + "查询品牌详情，结果=" + result);
     }

}
