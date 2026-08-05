package com.capstone.AiAgent.dto;

import com.capstone.AiAgent.model.Customer;
import com.capstone.AiAgent.model.OrderItem;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderRequestDto(
        @NotNull UUID customerId,
        @NotEmpty List<OrderItemRequestDto> items,
        @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal total,
        @NotBlank String status
        ) {
}
