package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.model.DataSelect;
import io.khasang.orgmanager.model.Hello;
import io.khasang.orgmanager.model.SecureAccess;
import io.khasang.orgmanager.model.SuperSecureAccess;
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

    @RequestMapping("/createbase")
    public String createBase(Model model){
        model.addAttribute("createbase", dataSelect.getResult());
        return "createbase";
    }

    @RequestMapping("/innerjoin")
    public String selectWithInnerJoin(Model model){
        model.addAttribute("tableResult", dataSelect.getSelectResult());
        return "innerjoin";
    }
}
