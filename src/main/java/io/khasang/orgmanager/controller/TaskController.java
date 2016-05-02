package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.dao.GenericDao;
import io.khasang.orgmanager.dao.ITaskDao;
import io.khasang.orgmanager.dao.IUserDao;
import io.khasang.orgmanager.dao.impl.TaskDao;
import io.khasang.orgmanager.model.Entities.Role;
import io.khasang.orgmanager.model.Entities.Task;
import io.khasang.orgmanager.model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@Controller
public class TaskController {

    @Autowired
    ITaskDao taskDao;

    @Autowired
    IUserDao userDao;

    @RequestMapping("/tasks")
    public String allTasks(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentuser = auth.getName(); //get logged in username
        model.addAttribute("items", taskDao.getRelatedToUser(userDao.getUserByName(currentuser)));
        return "tasks";
    }

    @RequestMapping(value = "/tasks/add", method = RequestMethod.GET)
    public String addTask(Model model, @RequestParam(value = "parentid", required = false) Integer parentId) {
        model.addAttribute("title", "Создать задачу");
        model.addAttribute("parentid", parentId);
        model.addAttribute("users", userDao.getAll());
        return "addtask";
    }

    @RequestMapping(value = "/tasks/change", method = RequestMethod.GET)
    public String changeTask(Model model, @RequestParam(value = "id") Integer id) {
        Task task;
        task = taskDao.get(id);
        model.addAttribute("title", "Редактировать задачу");
        model.addAttribute("item", task);
        model.addAttribute("users", userDao.getAll());
        return "changetask";
    }

    @RequestMapping(value = "/tasks/save", method = RequestMethod.POST)
    public String saveTask(Model model, @RequestParam("id") Integer id,
                           @RequestParam("parentid") Integer parentID,
                           @RequestParam("name") String name,
                           @RequestParam("description") String desription,
                           @RequestParam("priority") Integer priority,
                           @RequestParam("startdate") String startdate,
                           @RequestParam("deadline") String deadline,
                           @RequestParam("executor") String executor
    ) {
        Task task;
        if (id == null) {
            task = new Task();
        } else {
            task = taskDao.get(id);
        }
        if (parentID != null) {
            task.setParentTask(taskDao.get(parentID));
        }
        task.setName(name);
        task.setDescription(desription);
        task.setPriority(priority);
        task.setExecutor(userDao.getUserByName(executor));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentuser = auth.getName(); //get logged in username
        task.setCreator(userDao.getUserByName(currentuser));

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.ENGLISH);
        try {
            task.setCreateDate(df.parse(startdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            task.setDeadLine(df.parse(deadline));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        taskDao.save(task);
        return allTasks(model);
    }

    @RequestMapping(value = "/tasks/delete", method = RequestMethod.GET)
    public String deleteTask(Model model, @RequestParam("id") Integer id) {
        Task task = taskDao.get(id);
        taskDao.delete(task);
        return allTasks(model);
    }
}
