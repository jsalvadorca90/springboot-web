package com.udemy.curso.springboot.webapp.springboot_web.controllers;

import java.util.Map;
// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.curso.springboot.webapp.springboot_web.models.User;
import com.udemy.curso.springboot.webapp.springboot_web.models.dto.UserDto;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details() {
        User user = new User("José", "Ñandú");

        UserDto userDto = new UserDto();
        userDto.setUser(user);
        // userDto.setUser(user.getName());
        // userDto.setLastName(user.getLastName());
        userDto.setTitle("¡Hola Mundo!");
        
        return userDto;
    }
    
    @GetMapping("/list")   
    public List<User> list() {
        User user = new User("José", "Ñandú");
        User user2 = new User("Luis", "Dueñas");
        User user3 = new User("Juan", "Guillaume");
        
        List<User> users = Arrays.asList(user,user2,user3);
        // List<User> users = new ArrayList<User>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;
    }

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {
        User user = new User("José", "Ñandú");

        Map<String, Object> body = new HashMap<>();
        body.put("title","¡Hola Mundo!");
        body.put("user",user);
        // body.put("lastName", "Ñandú");
        
        return body;
    }
}
