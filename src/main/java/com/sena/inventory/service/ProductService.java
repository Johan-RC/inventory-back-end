package com.sena.inventory.service;

import com.sena.inventory.dto.request.ProductRequest;
import com.sena.inventory.dto.response.CategoryResponse;
import com.sena.inventory.dto.response.ProductResponse;
import com.sena.inventory.dto.response.SupplierResponse;
import com.sena.inventory.entity.Categorys;
import com.sena.inventory.entity.Product;
import com.sena.inventory.entity.Supplier;
import com.sena.inventory.exception.ResourceNotFoundException;
import com.sena.inventory.repository.CategoryRepository;
import com.sena.inventory.repository.ProductRepository;
import com.sena.inventory.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Contiene la lógica de negocio para productos.
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public ProductResponse findById(Long id) {
        Product product = getProductById(id);
        return toResponse(product);
    }

    public ProductResponse create(ProductRequest request) {
        Categorys category = getCategorysById(request.categoryId());
        Supplier supplier = getSupplierById(request.supplierId());

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategorys(category);
        product.setSupplier(supplier);

        return toResponse(productRepository.save(product));
    }

    public ProductResponse update(Long id, ProductRequest request) {
        Product product = getProductById(id);
        Categorys category = getCategorysById(request.categoryId());
        Supplier supplier = getSupplierById(request.supplierId());

        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategorys(category);
        product.setSupplier(supplier);

        return toResponse(productRepository.save(product));
    }

    public void delete(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    private Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
    }

    private Categorys getCategorysById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + id));
    }

    private Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con ID: " + id));
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                new CategoryResponse(
                        product.getCategorys().getId(),
                        product.getCategorys().getName()
                ),
                new SupplierResponse(
                        product.getSupplier().getId(),
                        product.getSupplier().getName(),
                        product.getSupplier().getEmail()
                )
        );
    }
}