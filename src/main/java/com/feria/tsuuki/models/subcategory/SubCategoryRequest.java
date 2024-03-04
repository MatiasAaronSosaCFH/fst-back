package com.feria.tsuuki.models.subcategory;

import jakarta.validation.constraints.NotBlank;

public record SubCategoryRequest( Long id,
                                 @NotBlank String name) {
}
