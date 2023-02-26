package com.example.Mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Mapping.model.Book;

public interface BookRepository extends JpaRepository<Book,String>{

}
