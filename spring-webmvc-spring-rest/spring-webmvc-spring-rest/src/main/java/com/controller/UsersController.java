package com.controller;

import com.model.User;
import com.model.Users;
import com.service.UsersService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private  final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @RequestMapping("/list")
    public String list(Model model, @RequestParam(required = false) String sortKey) {
        List<Users> users = new ArrayList<>();
//        if (sortKey != null) {
//            int field = Integer.parseInt(sortKey);
//            users = usersService.sort(field);
//        }
//        else {
            users = usersService.getAll();
//        }
        model.addAttribute("users", users);
        return "user-list";
    }


    @RequestMapping("/home")
    public String home() {
        return "home";
    }


    @RequestMapping("/login-form")
    public String loginForm(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        return "login";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("users") Users users) {
        Users user = usersService.getUser(users);

        if(user != null)
            return "redirect:/users/home";
        else
            return "redirect:/users/login-form";
    }


    @RequestMapping("/reg-form")
    public String regForm(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        return "registration";
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute("users") Users users) {
        boolean isAlreadyRegistered = usersService.checkUserName(users);

        if(isAlreadyRegistered)
            return "redirect:/users/reg-form";

        usersService.save(users);

        return "redirect:/users/login-form";
    }
}
