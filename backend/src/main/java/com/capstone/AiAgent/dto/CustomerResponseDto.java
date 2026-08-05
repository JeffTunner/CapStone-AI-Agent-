package com.capstone.AiAgent.dto;

import java.util.UUID;

public record CustomerResponseDto(
        UUID id, String name, String email, String city
) {
}
