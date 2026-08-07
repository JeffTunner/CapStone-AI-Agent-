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
    private final ProductMapper productMapper;

    public OrderItemMapper(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public OrderItemResponseDto toDto(OrderItem item) {
        return new OrderItemResponseDto(
                item.getId(),
                productMapper.toDto(item.getProduct()),
                item.getQuantity());
    }

    public OrderItem toEntity(OrderItemRequestDto dto) {
        OrderItem item = new OrderItem();
        item.setProduct(productRepository.findById(dto.productId()).orElseThrow());
        item.setQuantity(dto.quantity());
        return item;
    }
}
