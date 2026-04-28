package com.sena.inventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Representa una categoría de productos.
 */
@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorys extends BaseEntity {

    /**
     * Nombre de la categoría.
     */
    @Column(nullable = false, unique = true)
    private String name;
}