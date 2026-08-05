package com.capstone.AiAgent.dto;

import com.capstone.AiAgent.model.Order;
import com.capstone.AiAgent.model.Product;

import java.util.UUID;

public record OrderItemResponseDto(
        UUID id, ProductResponseDto product, int quantity
) {
}
