package com.example.Mapping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mapping.model.Course;
import com.example.Mapping.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		
		return courseRepository.findAll();
	}

	public Optional<Course> getCourseById(String id) {
		return courseRepository.findById(id);
	}

	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	public Course updateCourse(String id, Course course) {
		Optional<Course> exstingCourse = courseRepository.findById(id);
		if(exstingCourse.isPresent()) {
			Course updateCourse = exstingCourse.get();
			updateCourse.setDescription(course.getDescription());
			updateCourse.setDuration(course.getDuration());
			updateCourse.setTitle(course.getTitle());
			updateCourse.setStudents(course.getStudents());
			return courseRepository.save(updateCourse);
		}else {
			throw new RuntimeException("student id not found"+id);
		}
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

}
