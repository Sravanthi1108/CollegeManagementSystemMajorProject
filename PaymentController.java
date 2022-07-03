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

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
//http://localhost:8088/api/course
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/register/{courseId}")
public ResponseEntity<Payment> addPayment(@PathVariable("courseId") long courseId,@Valid @RequestBody Payment payment) {
		
		return new ResponseEntity<Payment>(paymentService.addPayment(courseId,payment),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Payment> getAllPayments(){
		
		return paymentService.getAllPayments();
	}
	
	@GetMapping("{paymentId}")
	public ResponseEntity<Payment> getCourseById(@PathVariable("paymentId") long paymentId){
		
		return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId),HttpStatus.OK);
	}
	


}