package com.feria.tsuuki.models.item;

import com.feria.tsuuki.models.product.ProductRequest;
import jakarta.validation.constraints.NotBlank;

public record ItemRequest( Long id,
                          @NotBlank Integer mount,
                          @NotBlank ProductRequest productRequest) {
}
