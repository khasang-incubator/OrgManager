package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    @Autowired
    Hello hello;
    @RequestMapping("/")
    public String index2(Model model) {
        model.addAttribute("index", hello.getHello());
        return "index";
    }

    @RequestMapping("/hi")
    public String index(Model model,@RequestParam("i") String param) {
        model.addAttribute("index", "this is my hi app"+param);
        return "view2";
    }
}
