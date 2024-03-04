package com.feria.tsuuki.models.category;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest( Long id,
                              @NotBlank String name,
                              Boolean isPresent) {
}
