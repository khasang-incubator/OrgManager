package io.khasang.orgmanager.service.rest;


import io.khasang.orgmanager.dao.IRoleDao;
import io.khasang.orgmanager.model.Entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RoleService {
    @Autowired
    IRoleDao roleDao;

    @RequestMapping( value = "/rest/roles", method = RequestMethod.GET)
    public List<Role> getUsers() {
        return roleDao.getAll();
    }
}
