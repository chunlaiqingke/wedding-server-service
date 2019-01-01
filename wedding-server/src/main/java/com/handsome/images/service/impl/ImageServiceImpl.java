package com.handsome.images.service.impl;

import com.handsome.images.dao.ImageDao;
import com.handsome.images.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
