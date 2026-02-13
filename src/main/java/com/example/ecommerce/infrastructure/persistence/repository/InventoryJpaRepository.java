package com.example.ecommerce.infrastructure.persistence.repository;


import com.example.ecommerce.domain.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryJpaRepository extends JpaRepository<Inventory, Long> {
}
