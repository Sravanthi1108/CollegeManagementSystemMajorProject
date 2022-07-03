package com.example.demo.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Course;
import com.example.demo.model.Payment;
import com.example.demo.model.Student;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.PaymentService;
@Service
public class PaymentServiceImpl  implements PaymentService {
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public  Payment addPayment(long courseId, @Valid Payment payment) {
		// TODO Auto-generated method stub
		Course course=courseService.getCourseById(courseId);
		Student student=course.getStudent();
		payment.setTotalPayment(course.getCourseFee());
		payment.setPaymentDate(new Date());
		payment.setsId(student.getsId());
		payment.setCourse(course);
		
		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(long paymentId) {
		// TODO Auto-generated method stub
		return paymentRepository.findById(paymentId).orElseThrow(()->new ResourceNotFoundException("Payment","PaymentId",paymentId));
	}

}