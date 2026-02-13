package com.example.ecommerce.application.mapper;

import com.example.ecommerce.application.dto.OrderResponse;
import com.example.ecommerce.domain.model.Order;

public class OrderMapper {
    public static OrderResponse toResponse(Order order) {
        return new OrderResponse(order.getId(), order.getStatus());
    }
}
