package com.feria.tsuuki.models.category;

import com.feria.tsuuki.models.product.ProductResponse;
import com.feria.tsuuki.models.subcategory.SubCategoryResponse;

import java.util.ArrayList;
import java.util.List;

public record CategoryResponse(Long id,
                               String name,
                               List<ProductResponse> products,
                               List<SubCategoryResponse> subCategories) {

    public CategoryResponse(Category category){
        this(category.getId(),
                category.getName(),
                category.getProducts().stream().map(ProductResponse::new).toList(),
                category.getSubcategories().stream().map(SubCategoryResponse::new).toList());
    }

    public CategoryResponse(){
        this(null,null, null, null);
    }

}
