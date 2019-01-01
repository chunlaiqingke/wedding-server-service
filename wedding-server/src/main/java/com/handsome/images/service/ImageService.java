package com.handsome.images.service;

import java.util.List;

public interface ImageService {

    List<String> getImages(Long userId);

    List<String> getImagesPage(Long userId, int offset, Integer pageSize);
}
