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

    @RequestMapping(value="/user/add")
    public String changeUser(Model model){
        return "changeuser";
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
        User user;
        if(id==null){
            user=new User();
            Role role1 =new Role();
            user.setRole(role1);
        }
        else {
            user=userDao.get(id);
        }
        user.getRole().setName(role);
        user.setName(name);
        userDao.save(user);
        model.addAttribute("item",user);
        return "changeuser";
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public String  deleteUser(Model model, @RequestParam("id") Integer id){
        User user=userDao.get(id);
        userDao.delete(user);
        model.addAttribute("items",userDao.getAll());
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
