package com.udemy.curso.springboot.webapp.springboot_web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // genera los métodos: getter y setter; equals y hashCode; toString
// @AllArgsConstructor // constructor con parámetros: todos los campos de la clase
@NoArgsConstructor // constructor sin parámetros
public class User {
    private String name;
    private String lastName;
    private String email;

    // Constructor
    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
