package com.feria.tsuuki.models.item;

import com.feria.tsuuki.models.product.ProductResponse;

public record ItemResponse(Long id,
                           ProductResponse productResponse) {
}
