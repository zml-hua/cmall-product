package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Picture;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import cn.tedu.csmall.product.pojo.vo.PictureStandardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PictureMapperTests {

    @Autowired

    PictureMapper mapper;

    @Test
    void test2Insert() {
        Picture picture = new Picture();
        picture.setDescription("测试相册998");
        int rows= mapper.insert2(picture);
        System.out.printf("插入相册完成，受影响的行数=" + rows);
    }

    @Test
    void  testCountP() {
        int count = mapper.countP();
        System.out.println("统计相册的数量完成，相册的数量=" + count);
    }

    @Test
    void testCetStandardByIdP(){
        Long id = 3L;
        PictureStandardVO result = mapper.getStandardByIdP(id);
        System.out.println("根据id=" + id + "查询相册详情，结果=" + result);
    }

}
