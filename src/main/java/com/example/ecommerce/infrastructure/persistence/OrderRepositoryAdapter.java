package com.example.ecommerce.infrastructure.persistence;

import com.example.ecommerce.domain.model.Order;
import com.example.ecommerce.domain.ports.out.OrderRepository;
import com.example.ecommerce.infrastructure.persistence.repository.OrderJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository jpaRepository;

    public OrderRepositoryAdapter(OrderJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Order save(Order order) {
        return jpaRepository.save(order);
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return jpaRepository.findById(id);
    }
}
