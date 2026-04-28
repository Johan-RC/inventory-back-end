package com.sena.inventory.repository;

import com.sena.inventory.entity.Categorys;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository para acceder a la tabla categories.
 * JpaRepository ya incluye métodos como save, findAll, findById y delete.
 */
public interface CategoryRepository extends JpaRepository<Categorys, Long> {
}