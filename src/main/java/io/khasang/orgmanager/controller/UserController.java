package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.dao.IRoleDao;
import io.khasang.orgmanager.dao.IUserDao;
import io.khasang.orgmanager.model.Entities.Role;
import io.khasang.orgmanager.model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    IUserDao userDao;

    @Autowired
    IRoleDao roleDao;

    @RequestMapping("/admin/users")
    public String adminusers(Model model) {
        model.addAttribute("items", userDao.getAll());
        return "adminusers";
    }

    @RequestMapping(value = "/admin/user/add")
    public String changeUser(Model model) {
        model.addAttribute("users", userDao.getAll());
        model.addAttribute("roles", roleDao.getAll());
        model.addAttribute("title", "Создать пользователя");
        return "changeuser";
    }

    @RequestMapping(value = "/admin/user/change", method = RequestMethod.GET)
    public String changeUser(Model model, @RequestParam(value = "id") Integer id) {
        User user;
        user = userDao.get(id);
        model.addAttribute("title", "Редактировать пользователя");
        model.addAttribute("item", user);
        model.addAttribute("users", userDao.getAll());
        model.addAttribute("roles", roleDao.getAll());
        return "changeuser";
    }

    @RequestMapping(value = "/admin/user/save", method = RequestMethod.POST)
    public String saveUser(Model model, @RequestParam("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("role") String role,
                           @RequestParam("manager") String managerName,
                           @RequestParam("password") String password) {
        User user;
        if (id == null) {
            user = new User();
        } else {
            user = userDao.get(id);
        }

        if (!managerName.equals("")){
            User manager=userDao.getUserByName(managerName);
            user.setManager(manager);
        }
        user.setPassword(password);
        user.setRole(roleDao.getRoleByName(role));
        user.setName(name);
        userDao.save(user);
        model.addAttribute("item", user);
        return adminusers(model);
    }

    @RequestMapping(value = "/admin/user/delete", method = RequestMethod.GET)
    public String deleteUser(Model model, @RequestParam("id") Integer id) {
        User user = userDao.get(id);
        userDao.delete(user);
        model.addAttribute("items", userDao.getAll());
        return "adminusers";
    }

}
