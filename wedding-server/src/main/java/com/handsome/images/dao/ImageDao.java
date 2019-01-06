package com.handsome.images.dao;

import com.handsome.images.bean.Image;

import java.util.List;

public interface ImageDao {

    List<String> getImages(Long userId);

    List<String> getImagesPage(Long userId, int offset, Integer pageSize);

    boolean insert(Image image);
}
