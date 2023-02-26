package com.example.Mapping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mapping.model.Student;
import com.example.Mapping.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudentId(String Id){
		return studentRepository.findById(Id);
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(String Id, Student student) {
		Optional<Student> existingStudent= studentRepository.findById(Id);
		if(existingStudent.isPresent()) {
			Student updatedStudent = existingStudent.get();
			updatedStudent.setName(student.getName());
			updatedStudent.setAge(student.getAge());
			updatedStudent.setPhoneNumber(student.getPhoneNumber());
			updatedStudent.setBranch(student.getBranch());
			updatedStudent.setDepartment(student.getDepartment());
			updatedStudent.setAddress(student.getAddress());
			return studentRepository.save(updatedStudent);
		}else {
			throw new RuntimeException("student id not found"+Id);
		  }
     	} 
	
	    public void deleteStudent(String Id) {
	    	studentRepository.deleteById(Id);
	}
}
