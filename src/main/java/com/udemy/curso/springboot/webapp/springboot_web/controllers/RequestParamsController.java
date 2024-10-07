package com.udemy.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.udemy.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.udemy.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @GetMapping("/foo")
    // El parámetro 'message' se obtendrá de la URL de la solicitud. Si no se proporciona, se utilizará el valor por defecto "Hola qué tal"
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola qué tal") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        // El método devuelve un objeto de tipo ParamDto, que contendrá la información procesada  valor del parámetro 'message'
        return param;
    }

    @GetMapping("/bar")
    // El parámetro 'text|code' se obtendrá de la URL de la solicitud
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        // El método devuelve un objeto de tipo ParamMixDto, que contendrá la información procesada del parámetro 'text|code'
        return params;
    }

    @GetMapping("/request")
    // solicitudes HTTP en Spring MVC. Contiene toda la información sobre la petición, como los encabezados, los parámetros, el cuerpo, la URL, etc
    public ParamMixDto request(HttpServletRequest request) {
        // manejo de error 
        Integer code = 10;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
            // TODO: handle exception
        }
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        // El método devuelve un objeto de tipo ParamMixDto, que contendrá la información procesada del parámetro 'text|code'
        return params;
    }
    
}
