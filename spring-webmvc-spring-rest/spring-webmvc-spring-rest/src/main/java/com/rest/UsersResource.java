package com.rest;

import com.model.User;
import com.model.Users;
import com.service.UsersService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersResource {

    private  final UsersService usersService;

    public UsersResource(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/users")
    public List<Users> getAll() {
        return usersService.getAll();
    }
}
