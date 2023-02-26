package com.example.Mapping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "books")
public class Book {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String Id;

	private String title;
	private String author;
	private String description;
	private String price;
    
	@ManyToOne
	private Student student;
}
