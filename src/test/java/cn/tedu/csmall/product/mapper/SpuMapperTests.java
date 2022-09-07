package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.SPU;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SpuMapperTests {

    @Autowired
    SpuMapper mapper;

    @Test
    public void testInsert() {
        SPU spu = new SPU();
        spu.setId(1100L); // 重要，必须
        spu.setName("小米13");

        log.debug("插入数据之前，参数={}", spu);
        int rows = mapper.insert(spu);
        log.debug("rows = {}", rows);
        log.debug("插入数据之后，参数={}", spu);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        int rows = mapper.deleteById(id);
        log.debug("删除完成，受影响的行数={}", rows);
    }

    @Test
    public void testDeleteByIds() {
        int rows = mapper.deleteByIds(1L, 3L, 5L, 7L, 9L);
        log.debug("批量删除完成，受影响的行数={}", rows);
    }

    @Test
    public void testCountByBrand() {
        Long brandId = 1L;
        int countByBrand = mapper.countByBrand(brandId);
        log.debug("根据品牌={}统计完成，数量={}", brandId, countByBrand);
    }

    @Test
    public void testCountByCategory() {
        Long categoryId = 1L;
        int countByBrand = mapper.countByCategory(categoryId);
        log.debug("根据类别={}统计完成，数量={}", categoryId, countByBrand);
    }

    @Test
    public void testCountByAlbum() {
        Long albumId = 1L;
        int countByBrand = mapper.countByAlbum(albumId);
        log.debug("根据相册={}统计完成，数量={}", albumId, countByBrand);
    }


}
