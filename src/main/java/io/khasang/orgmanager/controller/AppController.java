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
    GenericDao<User> userDao;
    @Autowired
    GenericDao<News> newsDao;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }




    @RequestMapping("/tile")
    public String testTiles(){
        return "testtile";
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
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
        return model;
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
