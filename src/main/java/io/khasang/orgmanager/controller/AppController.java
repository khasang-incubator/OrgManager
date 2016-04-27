package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    DataClear dataClear;

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

    @RequestMapping("/news")
    public String news(Model model) {
        model.addAttribute("index", hello.getHello());
        return "news";
    }

    @RequestMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("index", hello.getHello());
        return "contacts";
    }

    @RequestMapping("/requisites")
    public String requisites(Model model) {
        model.addAttribute("index", hello.getHello());
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

    @RequestMapping("/createbase")
    public String createBase(Model model) {
        model.addAttribute("createbase", dataSelect.getResult());
        return "createbase";
    }

    @RequestMapping("/innerjoin")
    public String selectWithInnerJoin(Model model){
        model.addAttribute("tableResult", dataSelect.getSelectResult());
        return "innerjoin";
    }

    /**
     * removes the last row of the table
     * @author Serega Bobrus
     * @version 1.0
     */
    @RequestMapping("/deletelastdata")
    public String deleteLastData(Model model) {
        model.addAttribute("status", dataClear.getResultDeleteLastData());
        return "cleardata";
    }

    /**
     * deletes the data in time interval
     * @author Serega Bobrus
     * @version 1.0
     */
    @RequestMapping("/deleteperioddata")
    public String deletePeriodDate(Model model) {
        model.addAttribute("status", dataClear.getResultDeletePeriodDate());
        return "cleardata";
    }
}
