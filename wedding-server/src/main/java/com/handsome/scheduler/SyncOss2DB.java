package com.handsome.scheduler;

import com.handsome.common.model.oss.OssObjectKeys;
import com.handsome.common.utils.OssClientUtils;
import com.handsome.images.bean.Image;
import com.handsome.images.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SyncOss2DB {

    @Autowired
    private ImageService imageService;

    //把oss中的图片文件名保存到数据库
//    @Scheduled(cron = "")
    public void syncOssFilename2Db(){
        List<OssObjectKeys> keyList = OssClientUtils.getObjectKeyList("wedding-photos");
        if(keyList != null && keyList.size() > 0) {
            int sum = 0;
            for (OssObjectKeys key : keyList) {
                if(key.getKey() == null){
                    continue;
                }
                boolean insert = imageService.insert(new Image(1, key.getPrefix(), key.getKey(), null));
                sum = sum + (insert ? 1 : 0);
            }
            System.out.println(sum);
        }
    }
}
