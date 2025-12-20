package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    public final PersonaService service;

    public PersonaController (PersonaService service){
        this.service = service;
    }

    @GetMapping("api/personas")
    public List<Persona> personas (){
        return service.getPersonas();
    }
}
