package com.feria.tsuuki.service.abstraction;

import com.feria.tsuuki.models.category.CategoryRequest;
import com.feria.tsuuki.models.category.CategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryResponse> findAllAvailable();
    CategoryResponse findCategoryById(Long id);
    CategoryResponse findCategoryByName(String name);
    CategoryResponse createNewCategory(CategoryRequest categoryRequest);

    CategoryResponse updateCategory(CategoryRequest categoryRequest);
    Optional<?> makeUnAvailable(Long id);
    Optional<?> makeAvailable(Long id);
    List<CategoryResponse> findAll();

}
