package com.example.demo.domain;


import com.example.demo.exceptions.PersonaError;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class Persona{
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private LocalDateTime createDate;

    @Builder
    public Persona (Long id, String nombre, String apellido, Integer edad, LocalDateTime createDate){
        if (nombre == null || nombre.isBlank()) throw new PersonaError("El nombre no puede ser vacio");
        if (apellido == null || apellido.isBlank()) throw new PersonaError("El apellido no puede ser vacio");
        if (edad < 18) throw new PersonaError("La edad minima son 18 años!");

        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.createDate = createDate;
    }
    /*
    public boolean tieneDatosCompletos() {
        return nombre != null && !nombre.isBlank() && apellido != null && !apellido.isBlank();
    }

    public void setEdad(Integer edad){
        if (edad != null && edad >= 18) return;
        throw new PersonaError("La edad de la persona deberia ser mayor a 18 años!");
    }*/
}
