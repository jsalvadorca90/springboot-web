package com.udemy.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.curso.springboot.webapp.springboot_web.models.User;
import com.udemy.curso.springboot.webapp.springboot_web.models.dto.ParamDto;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    
    // La anotación @Value se usa para inyectar propiedades desde un archivo de propiedades (application.properties) directamente en un campo [atributos]
    @Value("${config.code}")
    private Integer code;
    
    @Value("${config.username}")
    private String username;
    
    // @Value("${config.message}")
    // private String message;
    
    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    
    // Busca el valor de la propiedad 'config.listOfValues' en un archivo de propiedades [.porperties], toma el valor obtenido, lo convierte a mayúsculas, y lo divide en una lista de strings, utilizando la coma como separador
    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    // Asigna la lista resultante a la variable 'valueList'
    private List<String> valueList;
    
    // Busca el valor de la propiedad 'config.listOfValues' en un archivo de propiedades [.porperties], toma el valor obtenido y lo convierte a mayúsculas
    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    // Asigna la lista resultante a la variable 'valueList'
    private String valueString;

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

    @PostMapping("/create")
    // El cliente envia los datos del nuevo usuario en formato JSON en el cuerpo de la solicitud, y Spring automáticamente convierte esos datos en un objeto 'User'
    public User create(@RequestBody User user) {
        // Toma el nombre del usuario que se recibió en la solicitud, lo convierte a mayúsculas y lo asigna nuevamente al atributo 'name' del objeto 'user'
        user.setName(user.getName().toUpperCase());
        // Toma el apellido del usuario que se recibió en la solicitud, lo convierte a minúsculas y lo asigna nuevamente al atributo 'lastName' del objeto 'user'
        user.setLastName(user.getLastName().toLowerCase());
        // devuelve el objeto 'user' modificado como respuesta al cliente
        return user;
    }

    @GetMapping("/values")
    // La anotación @Values se usa para inyectar propiedades desde un archivo de propiedades (application.properties) directamente en un parámetro de un bean [argumentos]
    public Map<String, Object> values(@Value("${config.message}") String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("code", code);
        json.put("username", username);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        return json;
    }
    
}
