package com.capstone.AiAgent.dto;

import com.capstone.AiAgent.model.Customer;
import com.capstone.AiAgent.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderResponseDto(
        UUID id, CustomerResponseDto customer,
        List<OrderItemResponseDto> items, BigDecimal total, String status
) {
}
