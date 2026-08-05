package com.capstone.AiAgent.mapper;

import com.capstone.AiAgent.dto.OrderRequestDto;
import com.capstone.AiAgent.dto.OrderResponseDto;
import com.capstone.AiAgent.model.Order;
import com.capstone.AiAgent.model.OrderItem;
import com.capstone.AiAgent.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    private final CustomerRepository customerRepository;
    private final OrderItemMapper orderItemMapper;

    public OrderMapper(CustomerRepository customerRepository, OrderItemMapper orderItemMapper) {
        this.customerRepository = customerRepository;
        this.orderItemMapper = orderItemMapper;
    }

    public OrderResponseDto toDto(Order order) {
        return new OrderResponseDto(order.getId(),
                CustomerMapper.toDto(order.getCustomer()),
                order.getItems().stream().map(orderItemMapper::toDto).toList(),
                order.getTotal(),
                order.getStatus());
    }

    public Order toEntity(OrderRequestDto dto) {
        Order order = new Order();
        order.setCustomer(customerRepository.findById(dto.customerId()).orElseThrow());
        order.setItems(dto.items().stream().map(orderItemMapper::toEntity).toList());
        order.setTotal(dto.total());
        order.setStatus(dto.status());
        List<OrderItem> items = dto.items().stream()
                .map(orderItemMapper::toEntity)
                .toList();
        items.forEach(item -> item.setOrder(order));
        order.setItems(items);
        return order;
    }
}
