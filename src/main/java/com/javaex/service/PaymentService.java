package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PaymentDao;
import com.javaex.vo.OrdersVo;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	public List<OrdersVo> exePaymentManageList() {
		System.out.println("exePaymentManagerList()");
		
		List<OrdersVo> paymentManageList = paymentDao.paymentManageList();
		
		return paymentManageList;
	}
	
}
