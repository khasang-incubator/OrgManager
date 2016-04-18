import io.khasang.orgmanager.config.AppContext;
import io.khasang.orgmanager.controller.AppController;
import io.khasang.orgmanager.model.Hello;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ContextConfiguration(classes = AppContext.class, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppControllerTest {
    @Autowired
    Hello hello;

    @Test
    public void indexTest() {
        Assert.assertNotNull(hello);
        Assert.assertEquals("This message not return hello!", "Hello my App!!!", hello.getHello());
    }

    @Test
    public void indexTest2() throws Exception {
        AppController controller = new AppController();
        InternalResourceView view = new InternalResourceView("/webapp/WEB-INF/views/view2.jsp");
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(view)
                .build();
        mockMvc.perform(get("/test?id=5"))
                .andExpect(model().attributeExists("testattr"))
                .andExpect(model().attribute("testattr", "hi"))
                .andExpect(model().attribute("id",5))
                .andExpect(view().name("view2"));
    }

    public void indexTest22() throws Exception {
        AppController controller = new AppController();
        InternalResourceView view = new InternalResourceView("/webapp/WEB-INF/views/view2.jsp");
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(view)
                .build();
        mockMvc.perform(get("/test/5"))
                .andExpect(model().attributeExists("testattr"))
                .andExpect(model().attribute("testattr", "hi"))
                .andExpect(model().attribute("id",5))
                .andExpect(view().name("view2"));
    }

    @Test
    public void indexTestPost() throws Exception {
        AppController controller = new AppController();
        InternalResourceView view = new InternalResourceView("/webapp/WEB-INF/views/view2.jsp");
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(view)
                .build();
        mockMvc.perform(post("/test")
        .param("login","admin")
        .param("password","admin"))
                .andExpect(model().attribute("login","admin"));
    }




}
