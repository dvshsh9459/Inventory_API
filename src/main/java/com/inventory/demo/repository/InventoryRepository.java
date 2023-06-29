package com.inventory.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.demo.repository.entity.Inventory;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
