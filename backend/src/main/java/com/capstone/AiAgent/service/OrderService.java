package com.capstone.AiAgent.service;

import com.capstone.AiAgent.dto.OrderItemRequestDto;
import com.capstone.AiAgent.dto.OrderRequestDto;
import com.capstone.AiAgent.dto.OrderResponseDto;
import com.capstone.AiAgent.mapper.OrderItemMapper;
import com.capstone.AiAgent.mapper.OrderMapper;
import com.capstone.AiAgent.model.Order;
import com.capstone.AiAgent.repository.CustomerRepository;
import com.capstone.AiAgent.repository.OrderRepository;
import com.capstone.AiAgent.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    CustomerRepository customerRepository;

    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
        if(orderRequestDto.items() == null || orderRequestDto.items().isEmpty()) {
            throw new IllegalArgumentException("Must contain atleast one item in the order");
        }

        if(!customerRepository.existsById(orderRequestDto.customerId())) {
            throw new NoSuchElementException("Customer not correct.");
        }

        Order order = orderMapper.toEntity(orderRequestDto);
        Order saved = orderRepository.save(order);

        return orderMapper.toDto(saved);
    }

    public List<OrderResponseDto> getOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).toList();
    }
}
