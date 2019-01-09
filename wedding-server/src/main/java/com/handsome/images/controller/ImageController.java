package com.handsome.images.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.UploadFileRequest;
import com.aliyun.oss.model.UploadFileResult;
import com.handsome.common.constant.OssConstants;
import com.handsome.common.dto.ImageResponse;
import com.handsome.common.dto.Response;
import com.handsome.common.utils.OssClientUtils;
import com.handsome.images.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "images", produces = "application/json")
    public ImageResponse getBasicImages(Long userId){
        ImageResponse response = new ImageResponse();
        List<String> images = imageService.getImageUrl(userId);
        response.setImages(images);
        response.setResultCode(200);
        return response;
    }

    @RequestMapping(value = "images/page", produces = "application/json")
    public ImageResponse getImagesPage(Long userId, Integer page, Integer pageSize){
        ImageResponse response = new ImageResponse();
        page = page == null ? 0 : page;
        pageSize = pageSize == null ? 10 : pageSize;
        List<String> images = imageService.getImageUrlPage(userId, page * pageSize, pageSize);
        response.setImages(images);
        response.setResultCode(200);
        return response;
    }

    @RequestMapping(value = "images/folder/page", produces = "application/json")
    public ImageResponse getImagesByFolderPage(Long userId, String prefix, Integer page, Integer pageSize){
        ImageResponse response = new ImageResponse();
        page = page == null ? 0 : page;
        pageSize = pageSize == null ? 10 : pageSize;
        List<String> images = imageService.getImageUrlPrefixPage(userId, prefix, page * pageSize, pageSize);
        response.setImages(images);
        response.setResultCode(200);
        return response;
    }

    @RequestMapping(value = "images/upload", method = RequestMethod.POST, produces = "application/json")
    public Response uploadImages(){
        OSSClient ossClient = new OSSClient(OssConstants.endPoint, OssConstants.accessKeyId, OssConstants.secretAccessKey);
        try {
            UploadFileResult uploadFileResult = ossClient.uploadFile(new UploadFileRequest("", ""));
            uploadFileResult.getMultipartUploadResult().getLocation();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
