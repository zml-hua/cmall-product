package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class AlbumMapperTests {

    @Autowired
    AlbumMapper mapper;

    @Test
    void testInsert() {
        Album album = new Album();
        album.setName("测试相册118");
        log.debug
("插入相册之前，参数对象=" + album);
        int rows = mapper.insertAlbum(album);
        log.debug("插入相册完成，受影响的行数={}",rows);
        log.debug("插入相册之后，参数对象={}",album);
    }

    @Test
    void testDeleteById() {
        Long id = 3L;
        int rows = mapper.deleteAlbumById(id);
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

        int rows = mapper.deleteAlbumByIds(4L,5L);
        log.debug("根据id批量删除相册完成，受影响的行数={}",rows);
    }

    @Test
    void testUpdateById(){
        Album album = new Album();
        album.setId(4L);
        album.setName("测试相册-1111");
        album.setDescription("这是一个测试哈哈");

        int rows = mapper.updateAlbumById(album);
        log.debug("根据id修改品牌完成，受影响的行数={}", rows);
    }

    @Test
    void  testCountAblum() {
        int count = mapper.countAlbum();
        log.debug("统计相册的数量完成，品牌的数量={}", count);
    }

    @Test
    void testCountByName(){
        String name = "iPhone 13";
        int count = mapper.countAlbumByName(name);
        log.debug("count={}",count);
    }

    @Test
    void testGetStandardById(){
        Long id = 2L;
        AlbumStandardVO result = mapper.getAlbumStandardById(id);
        log.info("根据id={}查询相册详情，结果={}",id,result);
    }

    @Test
    void testList(){
        List<AlbumListItemVO> list = mapper.listAlbum();
        log.debug("相册受影响数量：{}",list.size());
        for (AlbumListItemVO albumListItemVO : list) {
            log.debug("{}",albumListItemVO);
        }
    }
}
