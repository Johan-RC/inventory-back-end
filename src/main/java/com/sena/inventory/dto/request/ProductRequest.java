package com.sena.inventory.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * DTO para recibir datos al crear o actualizar un producto.
 */
public record ProductRequest(

        @NotBlank(message = "El nombre del producto es obligatorio")
        String name,

        @NotNull(message = "El precio es obligatorio")
        @Positive(message = "El precio debe ser mayor a cero")
        Double price,

        @NotNull(message = "La categoría es obligatoria")
        Long categoryId,

        @NotNull(message = "El proveedor es obligatorio")
        Long supplierId
) {
}