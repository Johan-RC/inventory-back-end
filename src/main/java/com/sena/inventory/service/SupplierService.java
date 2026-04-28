package com.sena.inventory.service;

import com.sena.inventory.dto.request.SupplierRequest;
import com.sena.inventory.dto.response.SupplierResponse;
import com.sena.inventory.entity.Supplier;
import com.sena.inventory.exception.ResourceNotFoundException;
import com.sena.inventory.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Contiene la lógica de negocio para proveedores.
 */
@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<SupplierResponse> findAll() {
        return supplierRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public SupplierResponse findById(Long id) {
        Supplier supplier = getSupplierById(id);
        return toResponse(supplier);
    }

    public SupplierResponse create(SupplierRequest request) {
        Supplier supplier = new Supplier();
        supplier.setName(request.name());
        supplier.setEmail(request.email());

        return toResponse(supplierRepository.save(supplier));
    }

    public SupplierResponse update(Long id, SupplierRequest request) {
        Supplier supplier = getSupplierById(id);
        supplier.setName(request.name());
        supplier.setEmail(request.email());

        return toResponse(supplierRepository.save(supplier));
    }

    public void delete(Long id) {
        Supplier supplier = getSupplierById(id);
        supplierRepository.delete(supplier);
    }

    private Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con ID: " + id));
    }

    private SupplierResponse toResponse(Supplier supplier) {
        return new SupplierResponse(
                supplier.getId(),
                supplier.getName(),
                supplier.getEmail()
        );
    }
}