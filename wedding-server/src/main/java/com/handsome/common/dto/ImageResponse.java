package com.handsome.common.dto;

import java.util.List;

public class ImageResponse extends Response {

    private List<String> images;

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
