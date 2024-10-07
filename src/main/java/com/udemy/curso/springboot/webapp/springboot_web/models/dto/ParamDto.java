package com.udemy.curso.springboot.webapp.springboot_web.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // genera los métodos: getter y setter; equals y hashCode; toString
@AllArgsConstructor // constructor con parámetros: todos los campos de la clase
@NoArgsConstructor // constructor sin parámetros
public class ParamDto {
    private String message;
}
