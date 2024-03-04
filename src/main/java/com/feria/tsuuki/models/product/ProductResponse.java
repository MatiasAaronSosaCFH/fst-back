package com.feria.tsuuki.models.product;

public record ProductResponse(Long id,
                              String name) {

    public ProductResponse(Product product){

        this(product.getId(),
                product.getName());
    }
}
