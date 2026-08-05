package com.capstone.AiAgent.mapper;

import com.capstone.AiAgent.dto.OrderItemRequestDto;
import com.capstone.AiAgent.dto.OrderItemResponseDto;
import com.capstone.AiAgent.model.OrderItem;
import com.capstone.AiAgent.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    private final ProductRepository productRepository;

    public OrderItemMapper(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public OrderItemResponseDto toDto(OrderItem item) {
        return new OrderItemResponseDto(
                item.getId(),
                ProductMapper.toDto(item.getProduct()),
                item.getQuantity());
    }

    public OrderItem toEntity(OrderItemRequestDto dto) {
        OrderItem item = new OrderItem();
        item.setProduct(productRepository.findById(dto.productId()).orElseThrow());
        item.setQuantity(dto.quantity());
        return item;
    }
}
