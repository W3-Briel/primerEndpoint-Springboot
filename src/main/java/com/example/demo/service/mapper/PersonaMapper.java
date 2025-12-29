package com.example.demo.service.mapper;

import com.example.demo.domain.Persona;
import com.example.demo.repo.entity.PersonaEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {


    // podriamos dejar de escribir manualmente el builder si empezamos a utilizar
    // una libreria que se llama MapStruct. desacoplamos un poco mas tocar codigo
    // al cambiar algo del dominio

    public Persona toDomain(PersonaEntity entity){
        if (entity == null) return null;

        return  Persona.builder()
                .id(entity.getId())
                .edad(entity.getEdad())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .createDate(entity.getCreateDate())
                .build();
    }

    public PersonaEntity toEntity(Persona domain){
        if (domain == null) return null;

        return PersonaEntity.builder()
                .id(domain.getId())
                .edad(domain.getEdad())
                .nombre(domain.getNombre())
                .apellido(domain.getApellido())
                .createDate(domain.getCreateDate())
                .build();
    }
}
