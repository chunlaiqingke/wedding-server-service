package com.handsome.scheduler;

import com.handsome.common.utils.OssClientUtils;
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

//    @Scheduled(cron = "")
    public void uploadImageScheduler(){
        try {
            System.out.println("uploadImageScheduler start ....");
            File[] files = null;
            File file = new File("D:\\Users\\Administrator\\Downloads\\张支勉精修\\jpg\\cut");
            if(file.isDirectory()){
                files = file.listFiles();
            }
            if (files != null) {
                for (File f : files) {
                    if(f.isDirectory()){
                        continue;
                    }
                    FileInputStream inputStream = new FileInputStream(f);
                    OssClientUtils.uploadFile("cut\\" + f.getName(), inputStream);
                }
            }
            System.out.println("uploadImageScheduler finish!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
