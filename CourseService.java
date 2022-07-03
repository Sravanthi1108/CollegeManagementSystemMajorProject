package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Course;
//import com.example.demo.service.courseNotValidException;

public interface CourseService {
	Course addCourse(long sId,Course course) ;

	List <Course> getAllCourses();

	Course getCourseById(long courseId);


}
