package com.example.ecommerce.infrastructure.events;

import com.example.ecommerce.domain.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {
    @Async
    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        System.out.println("📢 Order created event received: " + event.getOrderId());
    }
}
