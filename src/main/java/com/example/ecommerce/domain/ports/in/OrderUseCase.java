package com.example.ecommerce.domain.ports.in;

import com.example.ecommerce.domain.model.Order;
import java.util.UUID;

public interface OrderUseCase {
    Order createOrder(Long productId, int quantity);

    Order confirmOrder(UUID orderId);
}
