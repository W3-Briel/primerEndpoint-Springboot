package com.example.demo.repo;

import com.example.demo.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepo implements IPersonaRepo{

    List<Persona> usuarios = new ArrayList<>();

    @Override
    public String savePersona(Persona persona) {
        this.usuarios.add(persona);

        return "persona nueva: " + persona.getID();
    }

    @Override
    public List<Persona> getPersonas() {
        return this.usuarios;
    }

    public boolean hasUsuarios(){
        return !this.usuarios.isEmpty();
    }
}
