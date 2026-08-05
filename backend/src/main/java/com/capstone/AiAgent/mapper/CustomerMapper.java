package com.capstone.AiAgent.mapper;

import com.capstone.AiAgent.dto.CustomerRequestDto;
import com.capstone.AiAgent.dto.CustomerResponseDto;
import com.capstone.AiAgent.model.Customer;

public class CustomerMapper {

    public static CustomerResponseDto toDto(Customer customer) {
        return new CustomerResponseDto(customer.getId(), customer.getName(), customer.getEmail(), customer.getCity());
    }

    public static Customer toEntity(CustomerRequestDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.name());
        customer.setEmail(dto.email());
        customer.setCity(dto.city());
        return customer;
    }
}
