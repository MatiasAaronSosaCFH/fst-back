package com.feria.tsuuki.models.product;

import com.feria.tsuuki.models.category.CategoryRequest;
import com.feria.tsuuki.models.subcategory.SubCategoryRequest;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ProductRequest(Long id,
                             @NotBlank String name,
                             @NotBlank Double price,
                             @NotBlank CategoryRequest categoryRequest,
                             @NotBlank SubCategoryRequest subCategoryRequest,

                             List<String> measureKey,
                             List<Integer> measureValue) {
}
