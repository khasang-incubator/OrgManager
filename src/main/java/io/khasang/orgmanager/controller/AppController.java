package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.model.Hello;
import io.khasang.orgmanager.model.SecureAccess;
import io.khasang.orgmanager.model.SelectTopThree;
import io.khasang.orgmanager.model.SuperSecureAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class AppController {
    @Autowired
    Hello hello;
    @Autowired
    SecureAccess secureAccess;
    @Autowired
    SuperSecureAccess superSecureAccess;
    @Autowired
    SelectTopThree selectTopThree;

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

    @RequestMapping("/selecttopthree")
    public String selectTopThree(Model model) {
        model.addAttribute("name", selectTopThree.statment());
        return "selecttopthree";
    }
}
