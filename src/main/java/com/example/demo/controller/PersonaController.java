package com.example.demo.controller;

import com.example.demo.controller.dto.PersonaRequest;
import com.example.demo.controller.dto.PersonaResponse;
import com.example.demo.controller.mappers.PersonaWebMapper;
import com.example.demo.domain.Persona;
import com.example.demo.service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/personas")
public class PersonaController {
    public final PersonaService service;
    public final PersonaWebMapper mapper;

    public PersonaController (PersonaService service, PersonaWebMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<PersonaResponse>> personas (){
        List<PersonaResponse> res = this.service
                .getPersonas()
                .stream()
                .map(this.mapper::toResponseSimple)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping
    public ResponseEntity<PersonaResponse> crear(@Valid @RequestBody PersonaRequest req){
        Persona personaInput = this.mapper.toDomain(req);

        Persona personaCreada = this.service.crearPersona(personaInput);
        PersonaResponse res = this.mapper.toResponseWithMessage(personaCreada,"La persona se guardo correctamente en al bbdd");

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
