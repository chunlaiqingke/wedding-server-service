package com.handsome.images.dao;

import java.util.List;

public interface ImageDao {

    List<String> getImages(Long userId);
}
