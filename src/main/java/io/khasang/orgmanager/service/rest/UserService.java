package io.khasang.orgmanager.service.rest;


import io.khasang.orgmanager.dao.IUserDao;
import io.khasang.orgmanager.model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class UserService {
    @Autowired
    IUserDao userDao;

    @RequestMapping( value = "/rest/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Integer id){
       return userDao.get(id);
    }

    @RequestMapping( value = "/rest/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userDao.getAll();
    }

    @RequestMapping(value = "/rest/users", method = RequestMethod.POST)
    public ResponseEntity<String> createEmployee(@RequestBody User user)
    {
        System.out.println(user);
        userDao.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rest/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateEmployee(@PathVariable("id") int id, @RequestBody User user)
    {
        System.out.println(id);
        System.out.println(user);
        userDao.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> updateEmployee(@PathVariable("id") int id)
    {
        System.out.println(id);
        userDao.delete(userDao.get(id));
        return new ResponseEntity(HttpStatus.OK);
    }
}
