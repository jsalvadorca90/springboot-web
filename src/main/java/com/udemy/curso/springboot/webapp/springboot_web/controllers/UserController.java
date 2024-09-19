package com.udemy.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.udemy.curso.springboot.webapp.springboot_web.models.User;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.expression.Arrays;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("José", "Ñandú");
        user.setEmail("hola_mundo@correo.com");
        model.addAttribute("title", "¡Hola Mundo!");
        model.addAttribute("user", user);
        // model.addAttribute("lastName", "Ñandú");
        
        return "details"; //details.html
    }

    @GetMapping("/list")
    public String list(ModelMap model) {        
        List<User> users = new ArrayList<>();
        model.addAttribute("users", users);
        model.addAttribute("title", "¡Listado de usuarios!");

        return "list"; //list.html
    }
    
}
