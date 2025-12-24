package com.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Persona{
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private LocalDateTime createDate;

    public boolean tieneDatosCompletos() {
        return nombre != null && !nombre.isBlank() && apellido != null && !apellido.isBlank();
    }

    public Boolean edadValida(){
        return this.edad != null && this.edad >= 18;
    }
}
