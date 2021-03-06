package com.luv2code.springrestdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springrestdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		System.out.println("Loading data from post construct");
		theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Alexander","dadarrio"));
		theStudents.add(new Student("Poornima","patel"));
		theStudents.add(new Student("Kayakk","hill"));
		
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return theStudents;
	}
	
	@GetMapping("students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if(studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("student not found:" + studentId);
		}
		return theStudents.get(studentId);
	}
	
	//Add an exception handler
	//this is local to this controller
	/*@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessage(exe.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//Exception handler to catch nay exception
	//this is local to this controller
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exec) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessage(exec.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}*/
	

}
