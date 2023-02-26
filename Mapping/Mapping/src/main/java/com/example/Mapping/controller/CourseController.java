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

import com.example.Mapping.model.Course;
import com.example.Mapping.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Course> getCourseById(@PathVariable String Id) {
		Optional<Course> course = courseService.getCourseById(Id);
		if (course.isPresent()) {
			return new ResponseEntity<>(course.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(course.get(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		Course createdCourse =courseService.createCourse(course);
		return new ResponseEntity<>(createdCourse,HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<Course> updateCourse(@PathVariable String Id, @RequestBody Course course) {
		Course updatedCourse = courseService.updateCourse(Id, course);
		return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable String Id) {
		courseService.deleteCourse(Id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
