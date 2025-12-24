package com.example.demo.controller.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaRequest {
    private Integer edad;
    private String nombre;
    private String apellido;
}
