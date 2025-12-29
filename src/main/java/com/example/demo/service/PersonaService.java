package com.example.demo.service;

import com.example.demo.domain.Persona;
import com.example.demo.exceptions.PersonaError;
import com.example.demo.repo.PersonaRepository;
import com.example.demo.repo.entity.PersonaEntity;
import com.example.demo.service.mapper.PersonaMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonaService {
    public final PersonaRepository repo;
    public final PersonaMapper mapper;

    public PersonaService(PersonaRepository repo, PersonaMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<Persona> getPersonas() {
        return null;
    }

    public Persona crearPersona(Persona input){

        //if(!input.tieneDatosCompletos()) throw new PersonaError("Faltan campos necesarios para guardar a la persona");
        //if(!input.edadValida()) throw new PersonaError("La edad de la persona deberia ser mayor a 18 años!");

        PersonaEntity nuevaPersona = this.mapper.toEntity(input);
        nuevaPersona.setCreateDate(LocalDateTime.now());

        return this.mapper.toDomain(this.repo.save(nuevaPersona));
    }
}
