package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.AlbumUpdateDTO;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IAlbumService {

    /**
     * 添加相册
     *
     * @param albumAddNewDTO 添加的相册对象
     */
    void addNew(AlbumAddNewDTO albumAddNewDTO);

    /**
     * 删除相册
     *
     * @param id 被删除的相册的id
     */
    void deleteById(Long id);

    /**
     * 根据相册id，修改相册详情
     *
     * @param id             相册id
     * @param albumUpdateDTO 新的相册数据
     */
    void updateById(Long id, AlbumUpdateDTO albumUpdateDTO);

    /**
     * 查询相册列表
     *
     * @return 相册列表
     */
    List<AlbumListItemVO> list();
}
