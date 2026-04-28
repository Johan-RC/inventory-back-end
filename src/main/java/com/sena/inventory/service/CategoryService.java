package com.sena.inventory.service;

import com.sena.inventory.dto.request.CategoryRequest;
import com.sena.inventory.dto.response.CategoryResponse;
import com.sena.inventory.entity.Categorys;
import com.sena.inventory.exception.ResourceNotFoundException;
import com.sena.inventory.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Contiene la lógica de negocio para categorías.
 */
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * Lista todas las categorías.
     */
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    /**
     * Busca una categoría por ID.
     */
    public CategoryResponse findById(Long id) {
        Categorys categorys = getCategorysById(id);
        return toResponse(categorys);
    }

    /**
     * Crea una nueva categoría.
     */
    public CategoryResponse create(CategoryRequest request) {
        Categorys categorys = new Categorys();
        categorys.setName(request.name());

        return toResponse(categoryRepository.save(categorys));
    }

    /**
     * Actualiza una categoría existente.
     */
    public CategoryResponse update(Long id, CategoryRequest request) {
        Categorys categorys = getCategorysById(id);
        categorys.setName(request.name());

        return toResponse(categoryRepository.save(categorys));
    }

    /**
     * Elimina una categoría por ID.
     */
    public void delete(Long id) {
        Categorys categorys = getCategorysById(id);
        categoryRepository.delete(categorys);
    }

    /**
     * Método reutilizable para buscar categoría o lanzar error.
     */
    private Categorys getCategorysById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + id));
    }

    /**
     * Convierte una entidad Category a DTO CategoryResponse.
     */
    private CategoryResponse toResponse(Categorys categorys) {
        return new CategoryResponse(
                categorys.getId(),
                categorys.getName()
        );
    }
}