package com.example.demo.controller.mappers;

import com.example.demo.controller.dto.PersonaRequest;
import com.example.demo.controller.dto.PersonaResponse;
import com.example.demo.domain.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaWebMapper {

    public Persona toDomain (PersonaRequest request) {
        return Persona.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .edad(request.getEdad())
                .build();
    }

    public PersonaResponse toResponseSimple(Persona domain){
      return PersonaResponse.builder()
              .id(domain.getId())
              .createDate(domain.getCreateDate())
              .nombre(domain.getNombre())
              .apellido(domain.getApellido())
              .edad(domain.getEdad())
              .build();
    };

    public PersonaResponse toResponseWithMessage(Persona domain,String message){
        return PersonaResponse.builder()
                .id(domain.getId())
                .createDate(domain.getCreateDate())
                .nombre(domain.getNombre())
                .apellido(domain.getApellido())
                .mensaje(message)
                .edad(domain.getEdad())
                .build();
    };
}
