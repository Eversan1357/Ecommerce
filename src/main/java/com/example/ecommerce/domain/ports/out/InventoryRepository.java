package com.example.ecommerce.domain.ports.out;


import com.example.ecommerce.domain.model.Inventory;
import java.util.Optional;

public interface InventoryRepository {
    Optional<Inventory> findByProductId(Long productId);

    Inventory save(Inventory inventory);
}
