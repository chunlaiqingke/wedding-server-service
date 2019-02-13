package sheduler;

import com.handsome.common.utils.ImageUtils;
import com.handsome.common.utils.OssClientUtils;
import com.handsome.scheduler.UploadImageScheduler;
import net.coobird.thumbnailator.Thumbnails;
import org.aspectj.lang.annotation.Around;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author junzhao
 * @date 2019/1/10 20:26
 */
@ContextConfiguration(locations={"classpath:spring-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ImageUtilTest {

    @Autowired
    private UploadImageScheduler scheduler;

    @Test
    public void test(){
		ImageUtils.cutImage("D:\\Users\\Administrator\\Downloads\\张支勉精修\\jpg\\811A8652.jpg",
				"D:\\Users\\Administrator\\Downloads\\张支勉精修\\jpg\\thumbnail", 1f);
//        ImageUtils.scaleImage("D:\\Users\\Administrator\\Downloads\\张支勉精修\\jpg\\811A8652.jpg", "D:\\Users\\Administrator\\Downloads\\张支勉精修\\jpg\\thumbnail", 0.1f, 0.5f);
    }

    @Test
    public void test1(){
        try {
			BufferedImage bufferedImage = Thumbnails
					.of("D:\\Users\\Administrator\\Downloads\\张支勉精修\\jpg\\thumbnail\\cut_811A8652.jpg")
					.scale(1f)
                    .asBufferedImage();
            int height = bufferedImage.getHeight();
            int width = bufferedImage.getWidth();
            System.out.println(height + " : " + width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        File srcfile = new File("D:\\Users\\Administrator\\Downloads\\张支勉底片1");
        File tofile = new File("D:\\Users\\Administrator\\Downloads\\张支勉精修\\jpg\\cut1");
        ImageUtils.convertImages(srcfile, tofile);
    }

    @Test
    public void test3(){
        scheduler.uploadImageScheduler();
    }

}
