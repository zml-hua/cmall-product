package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.entity.Attribute;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.pojo.vo.AttributeListItemVO;
import cn.tedu.csmall.product.pojo.vo.AttributeStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class AttributeMapperTests {

    @Autowired
    AttributeMapper mapper;

    @Test
    void testInsert() {
        Attribute attribute = new Attribute();
        attribute.setName("测试相册118");
        log.debug
("插入相册之前，参数对象=" + attribute);
        int rows = mapper.insertAttribute(attribute);
        log.debug("插入相册完成，受影响的行数={}",rows);
        log.debug("插入相册之后，参数对象={}",attribute);
    }

    @Test
    void testDeleteById() {
        Long id = 3L;
        int rows = mapper.deleteAttributeById(id);
        log.debug("根据id删除相册完成，受影响的行数={}",rows);
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

        int rows = mapper.deleteAttributeByIds(4L,5L);
        log.debug("根据id批量删除相册完成，受影响的行数={}",rows);
    }

    @Test
    void testUpdateById(){
        Attribute attribute = new Attribute();
        attribute.setId(4L);
        attribute.setName("测试相册-1111");
        attribute.setDescription("这是一个测试哈哈");

        int rows = mapper.updateAttributeById(attribute);
        log.debug("根据id修改品牌完成，受影响的行数={}", rows);
    }

    @Test
    void  testCountAblum() {
        int count = mapper.countAttribute();
        log.debug("统计相册的数量完成，品牌的数量={}", count);
    }

  /*  @Test
    void testCountByName(){
        String name = "iPhone 13";
        int count = mapper.countAttributeByName(name);
        log.debug("count={}",count);
    }*/

    @Test
    void testGetStandardById(){
        Long id = 2L;
        AttributeStandardVO result = mapper.getAttributeStandardById(id);
        log.info("根据id={}查询相册详情，结果={}",id,result);
    }

    @Test
    void testList(){
        List<AttributeListItemVO> list = mapper.listAttribute();
        log.debug("相册受影响数量：{}",list.size());
        for (AttributeListItemVO attributeListItemVO : list) {
            log.debug("{}",attributeListItemVO);
        }
    }
}
