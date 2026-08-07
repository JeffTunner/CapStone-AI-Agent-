package com.capstone.AiAgent.mapper;

import com.capstone.AiAgent.dto.ProductRequestDto;
import com.capstone.AiAgent.dto.ProductResponseDto;
import com.capstone.AiAgent.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDto toDto(Product product) {
        return new ProductResponseDto(product.getId(), product.getName(), product.getCategory(),
                product.getBrand(), product.getPrice(), product.getRating(), product.getStock(),
                product.getDescription(), product.getTags());
    }

    public Product toEntity(ProductRequestDto dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setCategory(dto.category());
        product.setBrand(dto.brand());
        product.setPrice(dto.price());
        product.setRating(dto.rating());
        product.setStock(dto.stock());
        product.setDescription(dto.description());
        product.setTags(dto.tags());
        return product;
    }
}
