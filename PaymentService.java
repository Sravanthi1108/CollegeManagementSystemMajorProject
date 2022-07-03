package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Payment;

public interface PaymentService {
	Payment addPayment(long courseId, @Valid Payment payment);

	List<Payment> getAllPayments();

	Payment getPaymentById(long paymentId);


}
