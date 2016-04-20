package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    Hello hello;
    @Autowired
    SecureAccess secureAccess;
    @Autowired
    SuperSecureAccess superSecureAccess;
    @Autowired
    DataSelect dataSelect;
    @Autowired
    UserList userList;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("index", hello.getHello());
        return "index";
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

    @RequestMapping("/create")
    public String creteTable(Model model) {
        model.addAttribute("createbase", dataSelect.getResult());
        return "createbase";
    }

    @RequestMapping("/userlist")
    public String getUserList(Model model) {
        model.addAttribute("list", userList.getResult());
        return "list";
    }
}
