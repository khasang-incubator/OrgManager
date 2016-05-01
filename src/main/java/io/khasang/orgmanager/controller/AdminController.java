package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.dao.IUserDao;
import io.khasang.orgmanager.model.Backup;
import io.khasang.orgmanager.model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    Backup backup;

    @Autowired
    IUserDao userDao;

    @RequestMapping("/admintasks")
    public String admintasks(){
        return "admintasks";
    }

    @RequestMapping("/adminusers")
    public String adminusers(Model model){
        model.addAttribute("items",userDao.getAll());
        return "adminusers";
    }

    @RequestMapping(value="/user/change", method = RequestMethod.GET)
    public String changeUser(Model model, @RequestParam(value = "id", required = false) Integer id) {
        User user;
        if (id != null) {
            user = userDao.get(id);
        } else{
            user = new User();
        }
        model.addAttribute("item", user);
        return "changeuser";
    }

    @RequestMapping(value="/user/save", method = RequestMethod.POST)
    public String saveUser(Model model, @RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("role") String role){
        User user=userDao.get(id);
        user.getRole().setName(role);
        user.setName(name);
        userDao.save(user);
        model.addAttribute("item",user);
        return "changeuser";
    }

    @RequestMapping("/user/delete")
    public String  deleteUser(Model model){
        return "adminusers";
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
}
