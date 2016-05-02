package io.khasang.orgmanager.controller;

import io.khasang.orgmanager.dao.GenericDao;
import io.khasang.orgmanager.dao.INewsDao;
import io.khasang.orgmanager.model.Entities.ContrAgent;
import io.khasang.orgmanager.model.Entities.Requisite;
import io.khasang.orgmanager.model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    GenericDao<User> userDao;
    @Autowired
    INewsDao newsDao;
    @Autowired
    GenericDao<ContrAgent> contrAgentDao;
    @Autowired
    GenericDao<Requisite> requisitDao;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/news")
    public String news(Model model, @RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 0;
        }
        int pageCount =  newsDao.getNewsPagesCount();
        model.addAttribute("countOFPages", pageCount);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("news", newsDao.getNewsOnPage(pageNumber));
        model.addAttribute("pagination", createPagination(pageNumber, pageCount));
        return "news";
    }

    private List<Integer> createPagination(int pageIndex, int pagesCount){
        List<Integer> pageIndexes = new ArrayList<>();
        int leftIndex = pageIndex - 5 >= 0 ? pageIndex - 5 : 0;
        int rightIndex = pageIndex + 5 <= pagesCount ? pageIndex + 5 : pagesCount;
        if(pageIndex - leftIndex < 5){
            rightIndex += 5 - (pageIndex - leftIndex);
            rightIndex = rightIndex <= pagesCount ? rightIndex : pagesCount;
        }
        if(rightIndex - pageIndex < 5){
            leftIndex -= 5 - (rightIndex - pageIndex);
            leftIndex = leftIndex >= 0 ? leftIndex : 0;
        }
        for (int i = leftIndex; i <= rightIndex ; i++) {
            pageIndexes.add(i);
        }
        return pageIndexes;
    }

    @RequestMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("contacts",requisitDao.getAll());
        return "contacts";
    }

    @RequestMapping("/reference")
    public String requisites(Model model) {
        model.addAttribute("references",contrAgentDao.getAll());
        return "reference";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
        return model;
    }
}
