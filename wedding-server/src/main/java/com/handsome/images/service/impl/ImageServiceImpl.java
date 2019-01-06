package com.handsome.images.service.impl;

import com.handsome.images.bean.Image;
import com.handsome.images.dao.ImageDao;
import com.handsome.images.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageDao imageDao;

    @Override
    public List<String> getImages(Long userId) {
        return imageDao.getImages(userId);
    }

    @Override
    public List<String> getImagesPage(Long userId, int offset, Integer pageSize) {
        return imageDao.getImagesPage(userId, offset, pageSize);
    }

    @Override
    @Transactional(value = "serviceTxManager", rollbackFor = Exception.class)
    public boolean insert(Image image) {
        return imageDao.insert(image);
    }
}
