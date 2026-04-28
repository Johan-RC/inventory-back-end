package com.sena.inventory.dto.response;

/**
 * DTO para enviar datos del producto al cliente.
 */
public record ProductResponse(
        Long id,
        String name,
        Double price,
        CategoryResponse category,
        SupplierResponse supplier
) {
}