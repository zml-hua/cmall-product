package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceCode;
import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AlbumMapper;
import cn.tedu.csmall.product.mapper.PictureMapper;
import cn.tedu.csmall.product.mapper.SpuMapper;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.dto.AlbumUpdateDTO;
import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.service.IAlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 处理相册业务的实现类
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Slf4j
@Service
@Transactional
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
    private AlbumMapper albumMapper;
    @Autowired
    private PictureMapper pictureMapper;
    @Autowired
    private SpuMapper spuMapper;

    public AlbumServiceImpl() {
        log.info("创建业务对象：AlbumServiceImpl");
    }

    @Override
    public void addNew(AlbumAddNewDTO albumAddNewDTO) {
        log.debug("开始处理【添加相册】的业务，参数：{}", albumAddNewDTO);
        // 调用AlbumMapper对象的int countByName(String name)方法统计此名称的相册的数量
        String name = albumAddNewDTO.getName();
        int countByName = albumMapper.countAlbumByName(name);
        log.debug("尝试添加的相册名称是：{}，在数据库中此名称的相册数量为：{}", name, countByName);
        // 判断统计结果是否大于0
        if (countByName > 0) {
            // 是：相册名称已经存在，抛出RuntimeException异常
            String message = "添加相册失败！相册名称【" + name + "】已存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        // 创建Album对象
        Album album = new Album();
        BeanUtils.copyProperties(albumAddNewDTO, album);
        // 调用AlbumMapper对象的int insert(Album album)方法插入相册数据
        log.debug("即将向数据库中插入数据：{}", album);
        int rows = albumMapper.insertAlbum(album);
        // 判断插入数据时受影响的行数是否有误
        if (rows != 1) {
            String message = "添加相册失败！服务器忙，请稍后再次尝试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_INSERT, message);
        }
    }

    @Override
    public void deleteById(Long id) {
        log.debug("开始处理【删除相册】的业务，参数：{}", id);
        // 检查尝试删除的相册是否存在
        Object queryResult = albumMapper.getAlbumStandardById(id);
        if (queryResult == null) {
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, "删除相册失败，尝试访问的数据不存在！");
        }

        // 检查此相册是否关联了图片
        {
            int count = pictureMapper.countByAlbum(id);
            if (count > 0) {
                String message = "删除相册失败！当前相册中仍有图片！";
                log.warn(message);
                throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
            }
        }

        // 检查此相册是否关联了SPU
        {
            int count = spuMapper.countByAlbum(id);
            if (count > 0) {
                String message = "删除相册失败！当前相册仍关联了商品！";
                log.warn(message);
                throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
            }
        }

        // 执行删除
        log.debug("即使删除id为{}的相册……", id);
        int rows = albumMapper.deleteAlbumById(id);
        if (rows != 1) {
            throw new ServiceException(ServiceCode.ERR_DELETE, "删除相册失败，服务器忙，请稍后再次尝试！");
        }
        log.debug("删除完成！");
    }

    @Override
    public void updateById(Long id, AlbumUpdateDTO albumUpdateDTO) {
        log.debug("开始处理【修改相册详情】的业务，参数：{}", id);
        // 调用Mapper对象的getDetailsById()方法执行查询
        AlbumStandardVO queryResult = albumMapper.getAlbumStandardById(id);
        // 判断查询结果是否为null
        if (queryResult == null) {
            // 是：此id对应的数据不存在，则抛出异常(ERR_NOT_FOUND)
            String message = "修改相册详情失败，尝试访问的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        Album album = new Album();
        BeanUtils.copyProperties(albumUpdateDTO, album);
        album.setId(id);

        // 修改数据
        log.debug("即将修改数据：{}", album);
        int rows = albumMapper.updateAlbumById(album);
        if (rows != 1) {
            String message = "修改相册详情失败，服务器忙，请稍后再次尝试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_UPDATE, message);
        }
    }

    @Override
    public List<AlbumListItemVO> list() {
        log.debug("开始处理【查询相册列表】的业务……");
        return albumMapper.listAlbum();
    }

}