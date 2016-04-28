package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.dao.GenericDao;
import io.khasang.orgmanager.model.Backup;
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
