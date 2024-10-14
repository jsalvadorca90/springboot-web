package com.udemy.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller // No es API Rest
public class HomeController {

    @GetMapping({"", "/", "/home"})
    public String home() {
        // es una forma concisa de decirle al navegador del usuario que debe ir a otra página. Es comúnmente utilizada en controladores de Spring MVC
        return "redirect:/list";
        // A diferencia de una redirección, en un reenvío, el servidor NO envía una NUEVA respuesta HTTP al cliente. En su lugar, simplemente cambia la URL internamente y continúa procesando la solicitud en el nuevo destino
        // return "forward:/details";
    }
    
}
