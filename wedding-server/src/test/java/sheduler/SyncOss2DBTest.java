package sheduler;

import com.handsome.common.utils.OssClientUtils;
import com.handsome.scheduler.SyncOss2DB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@ContextConfiguration(locations={"classpath:spring-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SyncOss2DBTest {

    @Autowired
    SyncOss2DB syncOss2DB;

    @Test
    public void SyncOss2DBTest(){
        syncOss2DB.syncOssFilename2Db();
    }

    @Test
    public void uploadImageTest(){
        File file = new File("D:\\Users\\Administrator\\Downloads\\张支勉精修\\jpg\\cut\\cut_811A8652.jpg");
        try {
            OssClientUtils.uploadFile("test/" + file.getName(), new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
