package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.dao.IUserDao;
import io.khasang.orgmanager.model.Backup;
import io.khasang.orgmanager.model.Entities.Role;
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

    @RequestMapping("/admin/tasks")
    public String admintasks() {
        return "admintasks";
    }


    /**
     * @author Radiofisik
     * @version 1.0
     * makes backup of database to file. the name of the file can be found in properties file
     */
    @RequestMapping("/admin/backup")
    public String backup(Model model) {
        model.addAttribute("result", backup.makeBackup());
        return "backup";
    }
}
