package com.example.ecommerce.domain.ports.out;

public interface EventPublisher {
    void publish(Object event);
}
