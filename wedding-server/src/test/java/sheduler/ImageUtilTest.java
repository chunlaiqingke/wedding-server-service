package sheduler;

import com.handsome.common.utils.ImageUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author junzhao
 * @date 2019/1/10 20:26
 */
@ContextConfiguration(locations={"classpath:spring-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ImageUtilTest {

    @Test
    public void test(){
        ImageUtils.scaleImage("D:\\Users\\Administrator\\Downloads\\张支勉精修\\jpg\\811A8652.jpg", "D:\\Users\\Administrator\\Downloads\\张支勉精修\\jpg\\thumbnail", 0.1f, 0.5f);
    }
}
