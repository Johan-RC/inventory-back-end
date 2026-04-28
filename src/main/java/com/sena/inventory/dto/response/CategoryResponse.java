package com.sena.inventory.dto.response;

/**
 * DTO para enviar datos de categoría al cliente.
 */
public record CategoryResponse(
        Long id,
        String name
) {
}