package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.example.demo.model.Professor;
import com.example.demo.model.Student;
import com.example.demo.service.ProfessorService;
import com.example.demo.service.StudentService;

@RestController

@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/register")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
		System.out.println("student Registration Succesfull "+student);
		return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Student> loginStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.loginStudent(student),HttpStatus.OK);
	}
	//get all student details
	@GetMapping
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	//get professor by id
	@GetMapping("{sId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("sId") long sId){
		
		return new ResponseEntity<Student>(studentService.getStudentById(sId),HttpStatus.OK);
	}
	
	//updating professor details
	@PutMapping("{sId}")
	public ResponseEntity<Student> updateStudent(@PathVariable("sId") long sId, @RequestBody Student student) {
	
		return new ResponseEntity<Student>(studentService.updateStudent(student,sId),HttpStatus.OK);
	}
	//delete by id
	@DeleteMapping("{sId}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("sId") long sId){
		studentService.deleteStudent(sId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
		
	}
	
	

}





