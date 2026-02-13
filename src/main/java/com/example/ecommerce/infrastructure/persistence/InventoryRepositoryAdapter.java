package com.example.ecommerce.infrastructure.persistence;

import com.example.ecommerce.domain.model.Inventory;
import com.example.ecommerce.domain.ports.out.InventoryRepository;
import com.example.ecommerce.infrastructure.persistence.repository.InventoryJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InventoryRepositoryAdapter implements InventoryRepository {

    private final InventoryJpaRepository jpaRepository;

    public InventoryRepositoryAdapter(InventoryJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Inventory> findByProductId(Long productId) {
        return jpaRepository.findById(productId);
    }

    @Override
    public Inventory save(Inventory inventory) {
        return jpaRepository.save(inventory);
    }
}
