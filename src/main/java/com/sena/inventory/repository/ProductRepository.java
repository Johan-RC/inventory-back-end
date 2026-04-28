package com.sena.inventory.repository;

import com.sena.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository para acceder a la tabla products.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}