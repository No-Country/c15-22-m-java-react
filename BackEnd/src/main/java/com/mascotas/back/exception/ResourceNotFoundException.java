package com.mascotas.back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    // Autogenerar constructores con los parámetros necesarios (ALT + INSERT)
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) { // Error en una uri que devuelve un objeto por id
        super(String.format("%s no fue encontrado con: %s = '%s'", resourceName, fieldName, fieldValue)); // Este es el exception.getMessage()
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName) { // Error en una uri que devuelve una lista de objetos
        super(String.format("No hay registros de %s en el sistema", resourceName));
        this.resourceName = resourceName;
    }

}