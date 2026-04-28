package com.sena.inventory.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO para recibir datos del proveedor.
 */
public record SupplierRequest(

        @NotBlank(message = "El nombre del proveedor es obligatorio")
        String name,

        @NotBlank(message = "El email es obligatorio")
        @Email(message = "El email debe tener un formato válido")
        String email
) {
}