package com.udemy.curso.springboot.webapp.springboot_web.controllers;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @GetMapping("/details2")
    public Map<String, Object> details() {

        Map<String, Object> body = new HashMap<>();
        body.put("title","¡Hola Mundo!");
        body.put("name","José");
        body.put("lastName", "Ñandú");
        
        return body;
    }
}
