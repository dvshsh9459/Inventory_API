package com.inventory.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.demo.repository.entity.Inventory;
import com.inventory.demo.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    
    @GetMapping("/")
    public List<Inventory> getAllItems() {
        return inventoryService.getAllItems();
    }

    @PostMapping("/")
    public Inventory createItem(@RequestBody Inventory item) {
        return inventoryService.createItem(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getItemById(@PathVariable(value = "id") Long itemId) {
        return inventoryService.getItemById(itemId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateItem(@PathVariable(value = "id") Long itemId,
                                                    @RequestBody Inventory itemDetails) {
        return inventoryService.updateItem(itemId, itemDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable(value = "id") Long itemId) {
        return inventoryService.deleteItem(itemId);
    }
}
