package com.udemy.curso.springboot.webapp.springboot_web.controllers;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.curso.springboot.webapp.springboot_web.models.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object> details() {

        User user = new User("José", "Ñandú");

        Map<String, Object> body = new HashMap<>();
        body.put("title","¡Hola Mundo!");
        body.put("user",user);
        // body.put("lastName", "Ñandú");
        
        return body;
    }
}
