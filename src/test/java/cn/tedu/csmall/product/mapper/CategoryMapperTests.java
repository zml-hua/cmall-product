package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
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
    void testDeleteById() {
        Long id = 3L;
        int rows = mapper.deleteCategoryById(id);
        log.debug("根据id删除相册完成，受影响的行数={}",rows);
    }

    @Test
    void testDeleteByIds(){
        int rows = mapper.deleteCategoryByIds(4L,5L);
        log.debug("根据id批量删除相册完成，受影响的行数={}",rows);
    }

    @Test
    void testUpdateById(){
        Category category = new Category();
        category.setId(4L);
        category.setName("测试相册-1111");
        category.setIcon("这是一个测试哈哈");

        int rows = mapper.updateCategoryById(category);
        log.debug("根据id修改品牌完成，受影响的行数={}", rows);
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
