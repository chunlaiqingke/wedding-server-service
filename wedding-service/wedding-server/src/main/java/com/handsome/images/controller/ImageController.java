package com.handsome.images.controller;

import com.handsome.common.dto.ImageResponse;
import com.handsome.common.dto.Response;
import com.handsome.images.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("images")
    public ImageResponse getBasicImages(){
        ImageResponse response = new ImageResponse();
        List<String> images = imageService.getImages(1L);
        response.setImages(images);
        response.setResultCode(200);
        return response;
    }
}
