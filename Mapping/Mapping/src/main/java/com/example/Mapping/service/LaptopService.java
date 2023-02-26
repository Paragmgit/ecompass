package com.example.Mapping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mapping.model.Laptop;
import com.example.Mapping.repository.LaptopRepository;

@Service
public class LaptopService {
	
	@Autowired
	private LaptopRepository laptopRepository;

	public List<Laptop> getAllLaptops() {
		return laptopRepository.findAll();
	}

	public Optional<Laptop> getLaptopById(String id) {
		return laptopRepository.findById(id);
	}

	public Laptop createStudent(Laptop laptop) {
		return laptopRepository.save(laptop);
	}

	public Laptop updatedLaptop(String id, Laptop laptop) {
		Optional<Laptop> exstingLaptop = laptopRepository.findById(id);
		if(exstingLaptop.isPresent()) {
			Laptop updatedLaptop = exstingLaptop.get();
			updatedLaptop.setBrand(laptop.getBrand());
			updatedLaptop.setName(laptop.getName());
			updatedLaptop.setPrice(laptop.getPrice());
			updatedLaptop.setStudent(laptop.getStudent());
			return laptopRepository.save(updatedLaptop);
		}else {
			throw new RuntimeException("student id not found"+id);
		}
	}

	public void deletelaptop(String id) {
		laptopRepository.deleteById(id);
	}

}
