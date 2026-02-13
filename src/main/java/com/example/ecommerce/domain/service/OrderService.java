package com.example.ecommerce.domain.service;

import com.example.ecommerce.domain.model.Inventory;
import com.example.ecommerce.domain.model.Order;
import com.example.ecommerce.domain.ports.in.OrderUseCase;
import com.example.ecommerce.domain.ports.out.InventoryRepository;
import com.example.ecommerce.domain.ports.out.OrderRepository;
import org.springframework.transaction.annotation.Transactional;
import com.example.ecommerce.domain.exception.ProductNotFoundException;


import java.util.UUID;

public class OrderService implements OrderUseCase {

    private final OrderRepository orderRepository;
    private final InventoryRepository inventoryRepository;

    public OrderService(OrderRepository orderRepository,
                        InventoryRepository inventoryRepository) {
        this.orderRepository = orderRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    @Transactional
    public Order createOrder(Long productId, int quantity) {

        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        inventory.reserve(quantity);
        inventoryRepository.save(inventory);

        Order order = new Order(UUID.randomUUID());
        order.reserveInventory();

        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order confirmOrder(UUID orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order not found"));

        order.confirm();
        return orderRepository.save(order);
    }
}
