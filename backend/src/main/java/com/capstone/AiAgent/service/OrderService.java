package com.capstone.AiAgent.service;

import com.capstone.AiAgent.dto.OrderItemRequestDto;
import com.capstone.AiAgent.dto.OrderRequestDto;
import com.capstone.AiAgent.dto.OrderResponseDto;
import com.capstone.AiAgent.mapper.OrderItemMapper;
import com.capstone.AiAgent.mapper.OrderMapper;
import com.capstone.AiAgent.model.Order;
import com.capstone.AiAgent.model.OrderItem;
import com.capstone.AiAgent.model.Product;
import com.capstone.AiAgent.repository.CustomerRepository;
import com.capstone.AiAgent.repository.OrderRepository;
import com.capstone.AiAgent.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {

        if(orderRequestDto.items() == null || orderRequestDto.items().isEmpty()) {
            throw new IllegalArgumentException("Must contain atleast one item in the order");
        }

        var customer = customerRepository.findById(orderRequestDto.customerId())
                .orElseThrow(() -> new NoSuchElementException("Customer not Found" +orderRequestDto.customerId()));

        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus("PLACED");

        BigDecimal total = BigDecimal.ZERO;

        for(OrderItemRequestDto itemDto: orderRequestDto.items()) {
            Product product = productRepository.findById(itemDto.productId())
                    .orElseThrow(() -> new NoSuchElementException("Product not Found" +itemDto.productId()));

            if(product.getStock() < itemDto.quantity()) {
                throw new IllegalStateException("Insufficient Stock for : " +product.getName());
            }

            product.setStock(product.getStock() - itemDto.quantity());
            productRepository.save(product);

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(itemDto.quantity());
            item.setOrder(order);
            order.getItems().add(item);

            total = total.add(product.getPrice().multiply(BigDecimal.valueOf(itemDto.quantity())));
        }

        order.setTotal(total);

        Order saved = orderRepository.save(order);
        return orderMapper.toDto(saved);
    }

    public List<OrderResponseDto> getOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).toList();
    }
}
