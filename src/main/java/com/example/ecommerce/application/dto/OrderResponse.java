package com.example.ecommerce.application.dto;

import com.example.ecommerce.domain.model.OrderStatus;
import java.util.UUID;

public class OrderResponse {

    private UUID orderId;
    private OrderStatus status;

    public OrderResponse(UUID orderId, OrderStatus status) {
        this.orderId = orderId;
        this.status = status;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
