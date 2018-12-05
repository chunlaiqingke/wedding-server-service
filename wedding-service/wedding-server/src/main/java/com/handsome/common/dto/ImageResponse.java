package com.handsome.common.dto;

import java.util.List;

public class ImageResponse extends Response {

    private List<String> images;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
