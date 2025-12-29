package com.example.demo.controller;

import com.example.demo.controller.dto.PersonaRequest;
import com.example.demo.controller.dto.PersonaResponse;
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

    public PersonaController (PersonaService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PersonaResponse>> personas (){
        return null;
    }

    @PostMapping
    public ResponseEntity<PersonaResponse> crear(@Valid @RequestBody PersonaRequest req){
        Persona personaInput = Persona.builder()
                .nombre(req.getNombre())
                .apellido(req.getApellido())
                .edad(req.getEdad())
                .build();

        Persona personaCreada = this.service.crearPersona(personaInput);
        PersonaResponse res = PersonaResponse.builder()
                .id(personaCreada.getId())
                .createDate(personaCreada.getCreateDate())
                .nombre(personaCreada.getNombre())
                .apellido(personaCreada.getApellido())
                .edad(personaCreada.getEdad())
                .mensaje("La persona se guardo correctamente en al bbdd")
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
