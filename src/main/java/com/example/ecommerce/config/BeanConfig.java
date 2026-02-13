package com.example.ecommerce.config;

import com.example.ecommerce.domain.ports.out.EventPublisher;
import com.example.ecommerce.domain.ports.out.InventoryRepository;
import com.example.ecommerce.domain.ports.out.OrderRepository;
import com.example.ecommerce.application.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public OrderService orderService(OrderRepository orderRepository,
                                     InventoryRepository inventoryRepository,
                                     EventPublisher eventPublisher) {

        return new OrderService(
                orderRepository,
                inventoryRepository,
                eventPublisher
        );
    }

}
