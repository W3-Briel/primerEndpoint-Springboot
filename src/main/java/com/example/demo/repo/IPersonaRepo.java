package com.example.demo.repo;

import com.example.demo.model.Persona;

import java.util.List;

public interface IPersonaRepo {
    String savePersona(Persona persona);
    List<Persona> getPersonas();
}
