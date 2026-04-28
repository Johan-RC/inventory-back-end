package com.sena.inventory.exception;

/**
 * Excepción personalizada para cuando un recurso no existe en la base de datos.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}