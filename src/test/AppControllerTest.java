import io.khasang.ormanager.controller.AppController;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"file:webapp/WEB-INF/spring-dispatcher-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppControllerTest {
    @Test
    public void indexTest() {
        AppController appController = new AppController();
        Assert.assertEquals("This message not return hello", appController.index());
    }
}
