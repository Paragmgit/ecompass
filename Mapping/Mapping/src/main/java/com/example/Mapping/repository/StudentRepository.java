package com.example.Mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Mapping.model.Student;

public interface StudentRepository extends JpaRepository<Student,String>{

}
