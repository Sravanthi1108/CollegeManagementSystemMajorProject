package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
//import com.example.demo.service.courseNotValidException;
@CrossOrigin(origins="http://localhost:4200")
@RestController
//http://localhost:8088/api/course
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("register/{sId}")
	public ResponseEntity<Course> addCourse(@PathVariable("sId") long sId,@Valid @RequestBody Course course) {
		System.out.println("course added Succesfull "+course);
		return new ResponseEntity<Course>(courseService.addCourse(sId,course),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Course> getAllCourses(){
		
		return courseService.getAllCourses();
	}
	
	@GetMapping("{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable("courseId") long courseId){
		
		return new ResponseEntity<Course>(courseService.getCourseById(courseId),HttpStatus.OK);
	}
	

}