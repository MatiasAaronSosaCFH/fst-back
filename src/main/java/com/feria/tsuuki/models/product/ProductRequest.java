package com.feria.tsuuki.models.product;

import jakarta.validation.constraints.NotBlank;

public record ProductRequest( Long id,
                             @NotBlank String name,
                             @NotBlank Double price) {
}
