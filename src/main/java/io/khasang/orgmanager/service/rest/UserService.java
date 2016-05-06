package io.khasang.orgmanager.service.rest;


import io.khasang.orgmanager.dao.IUserDao;
import io.khasang.orgmanager.model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/rest/user")
public class UserService {
    @Autowired
    IUserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id") Integer id){
       return userDao.get(id);
    }
}
