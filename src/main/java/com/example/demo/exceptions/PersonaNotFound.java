package com.example.demo.exceptions;

import lombok.Getter;

@Getter
public class PersonaNotFound extends RuntimeException {
    public PersonaNotFound(String message) {
        super(message);
    }
}
