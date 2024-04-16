package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.javaex.service.PaymentService;
import com.javaex.util.JsonResult;
import com.javaex.vo.OrdersVo;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/api/admin/paymentmanage")
	public JsonResult paymentManageList() {
		System.out.println("PaymentController.paymentManageList()");

		List<OrdersVo> paymentManageList = paymentService.exePaymentManageList();

		System.out.println(paymentManageList);

		return JsonResult.success(paymentManageList);
	}
	
}
