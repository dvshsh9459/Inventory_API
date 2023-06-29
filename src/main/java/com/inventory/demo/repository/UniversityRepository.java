package com.inventory.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.demo.repository.entity.University;

public interface UniversityRepository extends JpaRepository<University, Long> {
    List<University> findByNameContainingIgnoreCase(String keyword);
}

