package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
public class AlbumServiceTests {
    @Autowired
    IAlbumService service;

/*    @Test
    void testAddNew() {
        AlbumAddNewDTO albumAddNewDTO = new AlbumAddNewDTO();
        albumAddNewDTO.setName("华为Mate77的相册");
        albumAddNewDTO.setDescription("华为Mate77的相册的简介");
        albumAddNewDTO.setSort(58);

        try {
            service.addNew(albumAddNewDTO);
            log.debug("添加相册成功！");
        } catch (ServiceException e) {
            log.debug(e.getMessage());
        }
    }*/

   /* @Test
    public void testList() {
        List<?> list = service.list();
        log.debug("查询列表完成，结果集中的数据的数量={}", list.size());
        for (Object item : list) {
            log.debug("{}", item);
        }
    }*/
}
