package com.inventory.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.demo.repository.UniversityRepository;
import com.inventory.demo.repository.entity.University;

@RestController
@RequestMapping("/universities")
public class UniversityController {

	@Autowired
	private UniversityRepository universityRepository;

	@GetMapping("/search")
	public List<University> searchUniversities(@RequestParam("keyword") String keyword) {
		return universityRepository.findByNameContainingIgnoreCase(keyword);
	}

}
