package com.udemy.curso.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
// anotación principal que indica que se cargarán múltiples archivos de propiedades, un arreglo de anotaciones @PropertySource, cada una especificando un archivo de propiedades diferente
@PropertySources({
    // se utiliza para especificar archivos de propiedades que contienen valores de configuración. classpath: Indica que el archivo 'values.properties' se encuentra en el classpath de la aplicación, en el directorio 'src/main/resources' del proyecto. values.properties: Es el nombre exacto del archivo que contiene las propiedades
    @PropertySource(value = "classpath:values.properties", encoding = "UTF-8")
})
public class ValuesConfig {

}
