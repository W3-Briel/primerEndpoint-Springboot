package com.example.demo.service;

import com.example.demo.domain.Persona;
import com.example.demo.exceptions.PersonaError;
import com.example.demo.exceptions.PersonaNotFound;
import com.example.demo.repo.PersonaRepository;
import com.example.demo.repo.entity.PersonaEntity;
import com.example.demo.service.mapper.PersonaMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    public final PersonaRepository repo;
    public final PersonaMapper mapper;

    public PersonaService(PersonaRepository repo, PersonaMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<Persona> getPersonas() {
        return this.repo.findAll()
                .stream()
                .map(entidad -> this.mapper.toDomain(entidad))
                .toList();
    }

    public Persona crearPersona(Persona input){
        PersonaEntity nuevaPersona = this.mapper.toEntity(input);
        nuevaPersona.setCreateDate(LocalDateTime.now());

        return this.mapper.toDomain(this.repo.save(nuevaPersona));
    }

    public Persona getPersonaById(Long id){
        PersonaEntity result = this.repo.findById(id)
                .orElseThrow(() -> new PersonaNotFound("no fue encontrada la persona con el id: "+ String.valueOf(id) ));

        return this.mapper.toDomain(result);
    };
}
