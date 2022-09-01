package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Picture;
import cn.tedu.csmall.product.pojo.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
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
    void testDeleteById() {
        Long id = 3L;
        int rows = mapper.deletePictureById(id);
        log.debug("根据id删除图片完成，受影响的行数={}",rows);
    }

    @Test
    void testDeleteByIds(){
        int rows = mapper.deletePictureByIds(4L,5L);
        log.debug("根据id批量删除图片完成，受影响的行数={}",rows);
    }

    /*@Test
    void  testCountP() {
        int count = mapper.countP();
        System.out.println("统计图片的数量完成，相册的数量=" + count);
    }*/

    @Test
    void testCetStandardByIdP(){
        Long id = 3L;
        PictureStandardVO result = mapper.getStandardByIdP(id);
        System.out.println("根据id=" + id + "查询图片详情，结果=" + result);
    }

    @Test
    void testList(){
        Long albumId = 1L;
        List<PictureListItemVO> list = mapper.listPicture(albumId);
        log.debug("根据相册（{}）查询列表完成，结果集中的数据的数量={}", albumId, list.size());
        for (PictureListItemVO pictureListItemVO : list) {
            log.debug("{}",pictureListItemVO);
        }
    }

}
