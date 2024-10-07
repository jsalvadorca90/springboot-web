package com.udemy.curso.springboot.webapp.springboot_web.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.udemy.curso.springboot.webapp.springboot_web.models.User;
// import org.springframework.web.bind.annotation.RequestParam;


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
        // List<User> users = new ArrayList<>();
        // List<User> users = Arrays.asList( //en reemplazo de ArrayList<>
        //         new User("Pepa", "Gonzalez"),
        //         new User("Lalo", "Perez", "lalo@correo.com"),
        //         new User("Juanita", "Roe", "juana@correo.com"),
        //         new User("Andrés", "Doe"));
        // model.addAttribute("users", users); //pasa datos desde el controlador [users] a la vista 'list.html' ["users"]
        model.addAttribute("title", "¡Listado de usuarios!");
        return "list"; //list.html
    }
    
    @ModelAttribute("users") // pasa datos desde el controlador [users] a la vista 'list.html' ["users"]
    public List<User> populateUserList() {
        return Arrays.asList(
                new User("Pepa", "Gonzalez"),
                new User("Lalo", "Perez", "lalo@correo.com"),
                new User("Juanita", "Roe", "juana@correo.com"),
                new User("Andrés", "Doe"));
    }
}
