package com.example.ecommerce.application.dto;

public class CreateOrderRequest {
    private Long productId;
    private int quantity;

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
