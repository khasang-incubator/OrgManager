package io.khasang.orgmanager.service.rest;


import io.khasang.orgmanager.dao.ITaskDao;
import io.khasang.orgmanager.dao.IUserDao;
import io.khasang.orgmanager.model.Entities.Task;
import io.khasang.orgmanager.model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class TaskService {
    @Autowired
    ITaskDao taskDao;

    @RequestMapping( value = "/rest/task/{id}", method = RequestMethod.GET)
    public Task getTask(@PathVariable("id") Integer id){
       return taskDao.get(id);
    }

    @RequestMapping( value = "/rest/tasks", method = RequestMethod.GET)
    public List<Task> getUsers() {
        return taskDao.getAll();
    }

    @RequestMapping(value = "/rest/tasks", method = RequestMethod.POST)
    public ResponseEntity<String> createEmployee(@RequestBody Task task)
    {
        System.out.println(task);
        taskDao.save(task);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rest/task/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateEmployee(@PathVariable("id") int id, @RequestBody Task task)
    {
        System.out.println(id);
        System.out.println(task);
        taskDao.save(task);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/task/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> updateEmployee(@PathVariable("id") int id)
    {
        System.out.println(id);
        taskDao.delete(taskDao.get(id));
        return new ResponseEntity(HttpStatus.OK);
    }
}
