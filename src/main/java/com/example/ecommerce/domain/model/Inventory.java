package com.example.ecommerce.domain.model;

import com.example.ecommerce.domain.exception.OutOfStockException;
import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    private Long productId;

    private int available;

    @Version
    private Long version;

    protected Inventory() {
        // JPA
    }

    public Inventory(Long productId, int available) {
        this.productId = productId;
        this.available = available;
    }

    public void reserve(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        if (this.available < quantity) {
            throw new OutOfStockException();
        }
        this.available -= quantity;
    }

    public void release(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        this.available += quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public int getAvailable() {
        return available;
    }

}
