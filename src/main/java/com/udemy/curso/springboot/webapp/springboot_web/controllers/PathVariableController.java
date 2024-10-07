package com.udemy.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.udemy.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    
    @GetMapping("/baz/{message}")
    // anotación de Spring indica que el parámetro message se va a obtener del valor que se encuentre en la URL en el lugar del placeholder {message}
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
    
    @GetMapping("/mix/{product}/{id}")
    // Estas anotaciones indican que los parámetros product e id se obtendrán de los valores que se encuentren en la URL en los lugares de los placeholders/variables {product} y {id}
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        // Se crea un nuevo Map vacío. La clave será un String ("product" o "id") y el valor puede ser cualquier tipo de objeto (Object)
        Map<String, Object> json = new HashMap<>();
        // La clave es "product" y el valor es el valor que obtuvimos de la URL y almacenamos en la variable product
        json.put("product", product);
        json.put("id", id);
        // se devuelve el Map como respuesta al cliente en formato JSON
        return json;
    }
    
}
