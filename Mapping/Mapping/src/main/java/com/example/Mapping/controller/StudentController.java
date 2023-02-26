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

import com.example.Mapping.model.Student;
import com.example.Mapping.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> getAllStudent(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Student> getStudentById(@PathVariable String Id) {
		Optional<Student> student = studentService.getStudentId(Id);
		if (student.isPresent()) {
			return new ResponseEntity<>(student.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(student.get(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student createdStudent = studentService.createStudent(student);
		return new ResponseEntity<>(createdStudent,HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<Student> updateStudent(@PathVariable String Id, @RequestBody Student student) {
		Student updatedStudent = studentService.updateStudent(Id, student);
		return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable String Id) {
		studentService.deleteStudent(Id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
