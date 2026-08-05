package com.capstone.AiAgent.dto;

import com.capstone.AiAgent.model.Order;
import com.capstone.AiAgent.model.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record OrderItemRequestDto(
        @NotNull UUID productId,
        @Min(1) int quantity
        ) {
}
