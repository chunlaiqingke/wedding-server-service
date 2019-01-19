package com.handsome.images.dao;

import com.handsome.images.bean.Image;

import java.util.List;

public interface ImageDao {

    List<Image> getImagesPage(Long userId, int offset, Integer pageSize);

    List<Image> getImagesPageByPrefix(Long userId, String prefix, int offset, Integer pageSize);

    boolean insert(Image image);

    Image getImageById(Long userId, Long imageId);
}
