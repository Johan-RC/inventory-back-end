package com.sena.inventory.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para recibir datos al crear o actualizar una categoría.
 */
public record CategoryRequest(

        // El nombre no puede estar vacío
        @NotBlank(message = "El nombre de la categoría es obligatorio")
        String name
) {
}