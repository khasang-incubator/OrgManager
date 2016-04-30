package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.dao.GenericDao;
import io.khasang.orgmanager.dao.IUserDao;
import io.khasang.orgmanager.model.Backup;
import io.khasang.orgmanager.model.Entities.News;
import io.khasang.orgmanager.model.Entities.Role;
import io.khasang.orgmanager.model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
public class AdminController {
    @Autowired
    Backup backup;

    @RequestMapping("/admintasks")
    public String admintasks(){
        return "admintasks";
    }

    @RequestMapping("/adminusers")
    public String adminusers(){
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
