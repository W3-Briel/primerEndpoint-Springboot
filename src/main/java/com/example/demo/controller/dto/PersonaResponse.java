package com.example.demo.controller.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private LocalDateTime createDate;
    private String mensaje;
}
