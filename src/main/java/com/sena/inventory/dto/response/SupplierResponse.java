package com.sena.inventory.dto.response;

/**
 * DTO para enviar datos del proveedor al cliente.
 */
public record SupplierResponse(
        Long id,
        String name,
        String email
) {
}