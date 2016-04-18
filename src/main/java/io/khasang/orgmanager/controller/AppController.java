package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.model.DataSelect;
import io.khasang.orgmanager.model.Hello;
import org.jgroups.protocols.S3_PING;
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
    DataSelect dataSelect;

    @RequestMapping("/selectusers")
    public String selectUsers(Model model){
        model.addAttribute("users", dataSelect.getUsers());
        return "selectusers";
    }

    @RequestMapping("/createbase")
    public String createBase(Model model){
        model.addAttribute("createbase", dataSelect.getResult());
        return "createbase";
    }

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

    @RequestMapping("/secure")
    public String index(Model model) {
        return "securepage";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testPage(Model model, @RequestParam("id") int id) {
        model.addAttribute("id",id);
        model.addAttribute("testattr","hi");
        return "view2";
    }

    @RequestMapping(value = "/test2/{id}", method = RequestMethod.GET)
    public String testPage2(Model model, @PathVariable int id) {
        model.addAttribute("id",id);
        model.addAttribute("testattr","hi");
        return "view2";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testPage2(Model model, @RequestParam("login") String login) {
        model.addAttribute("login",login);
        return "view2";
    }
}
