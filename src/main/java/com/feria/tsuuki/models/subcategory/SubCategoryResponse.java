package com.feria.tsuuki.models.subcategory;

public record SubCategoryResponse(Long id,
                                  String name) {

    public SubCategoryResponse(SubCategory subCategory){
        this(subCategory.getId(),
                subCategory.getName());
    }
}
