package com.capstone.AiAgent.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public record ProductRequestDto(
        @NotBlank String name,
        @NotBlank String category,
        String brand,
        @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal price,
        @Min(0) @Max(5) double rating,
        @Min(0) int stock,
        String description,
        List<String> tags
        ) {}
