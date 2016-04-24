package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.model.DataSelect;
import io.khasang.orgmanager.model.Hello;
import io.khasang.orgmanager.model.SecureAccess;
import io.khasang.orgmanager.model.SuperSecureAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * @author Radiofisik
     * @version 1.0
     * makes backup of database to file. the name of the file can be found in properties file
     */
    @RequestMapping("/backup")
    public String backup(Model model) {
        model.addAttribute("result", dataSelect.makeBackup());
        return "backup";
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
