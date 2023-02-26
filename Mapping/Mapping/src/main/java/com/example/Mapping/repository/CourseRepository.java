package com.example.Mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Mapping.model.Course;

public interface CourseRepository extends JpaRepository<Course,String>{

}
