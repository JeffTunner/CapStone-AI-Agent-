package com.capstone.AiAgent.controller;

import com.capstone.AiAgent.dto.OrderItemRequestDto;
import com.capstone.AiAgent.dto.OrderRequestDto;
import com.capstone.AiAgent.dto.OrderResponseDto;
import com.capstone.AiAgent.mapper.OrderMapper;
import com.capstone.AiAgent.model.Order;
import com.capstone.AiAgent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> order(@RequestBody OrderRequestDto orderRequest) {
        OrderResponseDto order = orderService.placeOrder(orderRequest);
        return ResponseEntity.ok().body(order);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getAll() {
        List<OrderResponseDto> orders = orderService.getOrders();
        return ResponseEntity.ok().body(orders);
    }
}
