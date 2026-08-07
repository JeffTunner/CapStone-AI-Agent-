package com.capstone.AiAgent.service;

import com.capstone.AiAgent.dto.ProductRequestDto;
import com.capstone.AiAgent.dto.ProductResponseDto;
import com.capstone.AiAgent.mapper.ProductMapper;
import com.capstone.AiAgent.model.Product;
import com.capstone.AiAgent.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public List<ProductResponseDto> getProducts(String q, BigDecimal price) {
        if(q == null && price == null) {
            List<Product> products = productRepository.findAll();
            return products.stream().map(productMapper::toDto).toList();
        }

        List<Product> productList = productRepository.search(q, price);
        return productList.stream().map(productMapper::toDto).toList();
    }

    public ProductResponseDto findById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow();
        return productMapper.toDto(product);
    }

    public ProductResponseDto addProduct(ProductRequestDto dto) {
        Product product = productMapper.toEntity(dto);
        Product saved = productRepository.save(product);
        return productMapper.toDto(saved);
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
