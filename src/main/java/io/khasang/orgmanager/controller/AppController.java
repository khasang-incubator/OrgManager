package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.dao.GenericDao;
import io.khasang.orgmanager.model.Backup;
import io.khasang.orgmanager.model.Entities.ContrAgent;
import io.khasang.orgmanager.model.Entities.News;
import io.khasang.orgmanager.model.Entities.User;
import io.khasang.orgmanager.model.SecureAccess;
import io.khasang.orgmanager.model.SuperSecureAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

@Controller
public class AppController {

    @Autowired
    SecureAccess secureAccess;
    @Autowired
    SuperSecureAccess superSecureAccess;
    @Autowired
    Backup backup;
    @Autowired
    GenericDao<User> userDao;
    @Autowired
    GenericDao<ContrAgent> contrAgentDao;
    @Autowired
    GenericDao<News> newsDao;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/createuser")
    public  String createuser(Model model){
        User user=new User();
        user.setName("admin");
        user.setPassword("somehash");
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

    /**
     * @author Radiofisik
     * @version 1.0
     * makes backup of database to file. the name of the file can be found in properties file
     */
    @RequestMapping("/backup")
    public String backup(Model model) {
        model.addAttribute("result", backup.makeBackup());
        return "backup";
    }

    @RequestMapping("/news")
    public String news(Model model) {
        model.addAttribute("news",newsDao.getAll());
        return "news";
    }

    @RequestMapping("/contacts")
    public String contacts(Model model) {
        return "contacts";
    }

    @RequestMapping("/requisites")
    public String requisites(Model model) {
        return "requisites";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginForm(@RequestParam(required=false) String authFailed, String logout) {
        String message="";
        if(authFailed != null) {
            message = "Invalid username or password, try again !";
        } else if (logout != null) {
            message = "Logged Out successfully, login again to continue!";
        }
        return new ModelAndView("login", "message", message);
    }

    @RequestMapping("/secure")
    public String secure(Model model) {
        model.addAttribute("secure", secureAccess.info());
        return "secure";
    }

    @RequestMapping("/supersecure")
    public String superSecure(Model model) {
        model.addAttribute("supersecure", superSecureAccess.info());
        return "supersecure";
    }

}
