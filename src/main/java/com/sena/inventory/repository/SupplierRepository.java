package com.sena.inventory.repository;

import com.sena.inventory.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository para acceder a la tabla suppliers.
 */
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}