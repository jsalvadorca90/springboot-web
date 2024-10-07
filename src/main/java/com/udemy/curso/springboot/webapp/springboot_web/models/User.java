package com.udemy.curso.springboot.webapp.springboot_web.models;

// import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // genera los métodos: getter y setter; equals y hashCode; toString
// @AllArgsConstructor // constructor con parámetros: OBLIGATORIO todos los campos de la clase
@NoArgsConstructor // constructor sin parámetros
public class User {
    private String name;
    private String lastName;
    private String email;

    // Otra forma de colocar constructor con NO OBLIGATORIO todos los campos de la clase, dependiendo del constructor para campos: name y lastName
    public User(String name, String lastName, String email) {
        this(name,lastName);
        this.email = email;
    }

    // Constructor sin todos los campos de la clase
    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
