package com.capstone.AiAgent.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record ProductResponseDto(
        UUID id, String name, String category, String brand,
        BigDecimal price, double rating, int stock,
        String description, List<String> tags
) {
}
