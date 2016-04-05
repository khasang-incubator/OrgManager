import io.khasang.orgmanager.config.AppContext;
import io.khasang.orgmanager.model.Hello;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ContextConfiguration(classes=AppContext.class, loader=AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppControllerTest {
    @Autowired
    Hello hello;

    @Test
    public void indexTest() {
        Assert.assertNotNull(hello);
        Assert.assertEquals("This message not return hello!", "Hello my App!!!", hello.getHello());
    }
}
