package com.capstone.AiAgent.controller;

import com.capstone.AiAgent.dto.OrderItemRequestDto;
import com.capstone.AiAgent.dto.OrderResponseDto;
import com.capstone.AiAgent.mapper.OrderMapper;
import com.capstone.AiAgent.model.Order;
import com.capstone.AiAgent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

record PlaceOrder(UUID customerId, List<OrderItemRequestDto> items) {}

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> order(@RequestBody PlaceOrder orderRequest) {
        OrderResponseDto order = orderService.placeOrder(orderRequest.customerId(), orderRequest.items());
        return ResponseEntity.ok().body(order);
    }
}
