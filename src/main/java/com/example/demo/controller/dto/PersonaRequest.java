package com.example.demo.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaRequest {
    @Min(value = 0)
    private Integer edad;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;
}
