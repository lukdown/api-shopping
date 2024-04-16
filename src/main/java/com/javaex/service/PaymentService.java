package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PaymentDao;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	
}
