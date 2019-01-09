package com.handsome.images.service;

import com.handsome.images.bean.Image;

import java.util.List;

public interface ImageService {

    List<String> getImageUrl(Long userId);

    List<String> getImageUrlPage(Long userId, Integer offset, Integer pageSize);

    List<String> getImageUrlPrefixPage(Long userId, String prefix, Integer offset, Integer pageSize);

    boolean insert(Image image);
}
