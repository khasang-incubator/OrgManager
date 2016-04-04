import io.khasang.orgmanager.model.Hello;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Component
@ContextConfiguration(locations = {"classpath:/WEB-INF/spring-dispatcher-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppControllerTest {
    @Autowired
    Hello hello;

    @Test
    public void indexTest() {
        Assert.assertNotNull(new Hello());
        Assert.assertEquals("This message not return hello!", "Hello Spring App!!!", "Hello Spring App!!!");
    }
}
