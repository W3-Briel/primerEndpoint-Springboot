package com.example.demo.exceptions;

import lombok.Getter;

@Getter
public class PersonaError extends RuntimeException{

    public PersonaError(String mensaje) {
        super(mensaje);
    }
}
