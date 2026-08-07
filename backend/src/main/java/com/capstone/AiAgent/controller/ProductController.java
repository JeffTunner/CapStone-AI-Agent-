package com.capstone.AiAgent.controller;

import com.capstone.AiAgent.dto.ProductRequestDto;
import com.capstone.AiAgent.dto.ProductResponseDto;
import com.capstone.AiAgent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> find(@RequestParam(required = false) String q,
                                                         @RequestParam(required = false) BigDecimal price) {
        List<ProductResponseDto> products = productService.getProducts(q, price);
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findById(@PathVariable UUID id) {
        ProductResponseDto productResponseDto = productService.findById(id);
        return ResponseEntity.ok().body(productResponseDto);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> add(@RequestBody ProductRequestDto dto) {
        ProductResponseDto product = productService.addProduct(dto);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
