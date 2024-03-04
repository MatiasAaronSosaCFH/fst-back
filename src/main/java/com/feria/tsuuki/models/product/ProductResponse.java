package com.feria.tsuuki.models.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public record ProductResponse(Long id,
                              String name,
                              Double price,
                              Date creatAt,
                              Date updateAt,
                              List<String> measureKey,
                              List<Integer> measureValue) {

    public ProductResponse(Product product){


        this(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCreateAt(),
                product.getUpdateAt(),
                product.getMeasure().keySet().stream().toList(),
                product.getMeasure().values().stream().toList());
    }

}
