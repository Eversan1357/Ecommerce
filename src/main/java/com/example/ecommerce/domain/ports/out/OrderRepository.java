package com.example.ecommerce.domain.ports.out;


import com.example.ecommerce.domain.model.Order;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Order save(Order order);

    Optional<Order> findById(UUID id);
}
