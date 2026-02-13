package com.example.ecommerce.infrastructure.controller;

import com.example.ecommerce.application.dto.CreateOrderRequest;
import com.example.ecommerce.application.dto.OrderResponse;
import com.example.ecommerce.application.mapper.OrderMapper;
import com.example.ecommerce.domain.ports.in.OrderUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderUseCase orderUseCase;

    public OrderController(OrderUseCase orderUseCase) {
        this.orderUseCase = orderUseCase;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @RequestBody CreateOrderRequest request) {

        var order = orderUseCase.createOrder(
                request.getProductId(),
                request.getQuantity()
        );

        return ResponseEntity.ok(OrderMapper.toResponse(order));
    }

    @PostMapping("/{orderId}/confirm")
    public ResponseEntity<OrderResponse> confirmOrder(
            @PathVariable UUID orderId) {

        var order = orderUseCase.confirmOrder(orderId);
        return ResponseEntity.ok(OrderMapper.toResponse(order));
    }
}

