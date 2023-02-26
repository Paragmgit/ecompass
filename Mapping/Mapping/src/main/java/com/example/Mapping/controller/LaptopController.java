package com.example.Mapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mapping.model.Laptop;
import com.example.Mapping.service.LaptopService;

@RestController
@RequestMapping("/laptops")
public class LaptopController {

	@Autowired
	private LaptopService laptopService;
	
	@GetMapping
	public List<Laptop> getAllLaptops(){
		return laptopService.getAllLaptops();
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Laptop> getLaptopById(@PathVariable String Id) {
		Optional<Laptop> laptop = laptopService.getLaptopById(Id);
		if (laptop.isPresent()) {
			return new ResponseEntity<>(laptop.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(laptop.get(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Laptop> createStudent(@RequestBody Laptop laptop) {
		Laptop createdLaptop = laptopService.createStudent(laptop);
		return new ResponseEntity<>(createdLaptop,HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<Laptop> updatedLaptop(@PathVariable String Id, @RequestBody Laptop laptop) {
		Laptop updatedLaptop = laptopService.updatedLaptop(Id, laptop);
		return new ResponseEntity<>(updatedLaptop,HttpStatus.OK);
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<Void> deleteLaptop(@PathVariable String Id) {
		laptopService.deletelaptop(Id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
