package com.inventory.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventory.demo.repository.InventoryRepository;
import com.inventory.demo.repository.entity.Inventory;

@Service
public class InventoryService {
	

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllItems() {
        return inventoryRepository.findAll();
    }

    public Inventory createItem(Inventory item) {
        return inventoryRepository.save(item);
    }

    public ResponseEntity<Inventory> getItemById( Long itemId) {
        Optional<Inventory> item = inventoryRepository.findById(itemId);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Inventory> updateItem(Long itemId,
                                                    Inventory itemDetails) {
        Optional<Inventory> optionalItem = inventoryRepository.findById(itemId);
        if (optionalItem.isPresent()) {
            Inventory item = optionalItem.get();
            item.setName(itemDetails.getName());
            item.setQuantity(itemDetails.getQuantity());
            return ResponseEntity.ok(inventoryRepository.save(item));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteItem(Long itemId) {
        Optional<Inventory> optionalItem = inventoryRepository.findById(itemId);
        if (optionalItem.isPresent()) {
            inventoryRepository.delete(optionalItem.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
