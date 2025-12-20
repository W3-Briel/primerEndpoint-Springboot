package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repo.PersonaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    public final PersonaRepo repo;

    public PersonaService(PersonaRepo repo) {
        this.repo = repo;
    }

    public List<Persona> getPersonas() {
        if (!this.repo.hasUsuarios()){
            //cargando usuarios demo
            this.repo.savePersona(new Persona("NombreDemo1","ApellidoDemo1"));
            this.repo.savePersona(new Persona("NombreDemo2","ApellidoDemo2"));
            this.repo.savePersona(new Persona("NombreDemo3","ApellidoDemo3"));
        }

        return repo.getPersonas();
    }
}
