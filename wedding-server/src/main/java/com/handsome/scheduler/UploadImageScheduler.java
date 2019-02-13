package com.handsome.scheduler;

import com.handsome.common.utils.OssClientUtils;
import com.handsome.images.bean.Image;
import com.handsome.images.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author junzhao
 * @date 2019/1/12 20:51
 */
@Component
public class UploadImageScheduler {

    @Autowired
    private ImageService service;

//    @Scheduled(cron = "")
    public void uploadImageScheduler(){
        try {
            System.out.println("uploadImageScheduler start ....");
            File[] files = null;
            File file = new File("D:\\Users\\Administrator\\Downloads\\张支勉精修\\jpg\\cut\\truing");
            if(file.isDirectory()){
                files = file.listFiles();
            }
            if (files != null) {
                for (File f : files) {
                    if(f.isDirectory()){
                        continue;
                    }
//                    f.renameTo(new File("D:\\Users\\Administrator\\Downloads\\张支勉精修\\jpg\\cut\\truing\\truing_" + f.getName()));
                    FileInputStream inputStream = new FileInputStream(f);
                    OssClientUtils.uploadFile("cut\\" + f.getName(), inputStream);
                    service.insert(new Image(1, null, null, "thumbnail", f.getName(), 2));
                }
            }
            System.out.println("uploadImageScheduler finish!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
