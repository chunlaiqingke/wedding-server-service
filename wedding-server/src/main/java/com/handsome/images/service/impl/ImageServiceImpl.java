package com.handsome.images.service.impl;

import com.handsome.common.utils.OssClientUtils;
import com.handsome.images.bean.Image;
import com.handsome.images.dao.ImageDao;
import com.handsome.images.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageDao imageDao;

    @Override
    public List<String> getImageUrlPage(Long userId, Integer offset, Integer pageSize) {
        List<Image> images = imageDao.getImagesPage(userId, offset, pageSize);
        List<String> result = new ArrayList<>();
        if(images != null && images.size() > 0) {
            for (Image image : images) {
                result.add(OssClientUtils.getObjectExpirUrl(image.getPrefix(), image.getFileName()));
            }
        }
        return result;
    }

    @Override
    public List<String> getImageUrlPrefixPage(Long userId, String prefix, Integer offset, Integer pageSize) {
        List<Image> images = imageDao.getImagesPageByPrefix(userId, prefix, offset, pageSize);
        List<String> result = new ArrayList<>();
        if(images != null && images.size() > 0) {
            for (Image image : images) {
                result.add(OssClientUtils.getObjectExpirUrl(image.getThumbnailPrefix(), image.getThumbnail()));
            }
        }
        return result;
    }

    @Override
    public String getImageById(Long userId, Long imageId) {
        Image image = imageDao.getImageById(userId, imageId);
        if(image != null) {
            return OssClientUtils.getObjectExpirUrl(image.getPrefix(), image.getFileName());
        }
        return null;
    }

    @Override
    @Transactional(value = "serviceTxManager", rollbackFor = Exception.class)
    public boolean insert(Image image) {
        return imageDao.insert(image);
    }
}
