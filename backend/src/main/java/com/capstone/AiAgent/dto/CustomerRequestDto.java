package com.capstone.AiAgent.dto;

import jakarta.validation.constraints.NotBlank;

public record CustomerRequestDto(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String city
) {
}
