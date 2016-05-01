package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.dao.GenericDao;
import io.khasang.orgmanager.dao.IRoleDao;
import io.khasang.orgmanager.dao.IUserDao;
import io.khasang.orgmanager.model.Entities.News;
import io.khasang.orgmanager.model.Entities.Role;
import io.khasang.orgmanager.model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
public class TestBdController {
    @Autowired
    IRoleDao roleDao;
    @Autowired
    IUserDao userDao;
    @Autowired
    GenericDao<News> newsDao;

    @RequestMapping("/createuser")
    public  String createuser(Model model){
        User user=new User();
        user.setName("user");
        user.setPassword("password");
        Role role=new Role();
        role.setName("USER");
        user.setRole(role);
        userDao.save(user);
        model.addAttribute("result","It seems to be ok");
        return "backup";
    }

    @RequestMapping("/createadmin")
    public  String createadmin(Model model){
        User user=new User();
        user.setName("admin");
        user.setPassword("password");
        Role role=new Role();
        role.setName("ADMIN");
        user.setRole(role);
        userDao.save(user);
        model.addAttribute("result","It seems to be ok");
        return "backup";
    }

    @RequestMapping("/createnews")
    public  String createnews(Model model){
        News news=new News();
        news.setName("Заголовок новости");
        news.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ante dolor, ultrices et eleifend sit amet, aliquet ac turpis. Aliquam accumsan dictum sapien. Nullam viverra tristique arcu, at dignissim turpis. Aenean gravida ligula ut enim vestibulum laoreet. Phasellus dolor arcu, rhoncus sed nisi a, condimentum suscipit augue. Fusce quis euismod augue. Sed cursus orci quis lectus pla");
        news.setFullText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ante dolor, ultrices et eleifend sit amet, aliquet ac turpis. Aliquam accumsan dictum sapien. Nullam viverra tristique arcu, at dignissim turpis. Aenean gravida ligula ut enim vestibulum laoreet. Phasellus dolor arcu, rhoncus sed nisi a, condimentum suscipit augue. Fusce quis euismod augue. Sed cursus orci quis lectus plaLorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ante dolor, ultrices et eleifend sit amet, aliquet ac turpis. Aliquam accumsan dictum sapien. Nullam viverra tristique arcu, at dignissim turpis. Aenean gravida ligula ut enim vestibulum laoreet. Phasellus dolor arcu, rhoncus sed nisi a, condimentum suscipit augue. Fusce quis euismod augue. Sed cursus orci quis lectus pla");
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        news.setCreated(today.getTime());
        newsDao.save(news);
        model.addAttribute("result","It seems to be ok");
        return "backup";
    }
}
