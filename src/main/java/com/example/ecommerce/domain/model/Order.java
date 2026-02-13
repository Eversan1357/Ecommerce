package com.example.ecommerce.domain.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Version
    private Long version;

    protected Order() {
        // JPA
    }

    public Order(UUID id) {
        this.id = id;
        this.status = OrderStatus.CREATED;
    }

    public void reserveInventory() {
        if (this.status != OrderStatus.CREATED) {
            throw new IllegalStateException("Order cannot reserve inventory from state " + status);
        }
        this.status = OrderStatus.INVENTORY_RESERVED;
    }

    public void confirm() {
        if (this.status != OrderStatus.INVENTORY_RESERVED) {
            throw new IllegalStateException("Order cannot be confirmed from state " + status);
        }
        this.status = OrderStatus.CONFIRMED;
    }

    public void cancel() {
        this.status = OrderStatus.CANCELLED;
    }

    public UUID getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
