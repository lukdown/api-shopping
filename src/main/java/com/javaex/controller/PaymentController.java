package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PaymentService;
import com.javaex.util.JsonResult;
import com.javaex.vo.OrdersVo;
import com.javaex.vo.PageVo;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/api/admin/paymentmanage")
	public JsonResult paymentManageList(@RequestBody PageVo pageVo) {
		System.out.println("PaymentController.opaymentManageList()");
		//List<OrdersVo> paymentManageList = paymentService.exePaymentManageList();
		//System.out.println("paymentController"+paymentManageList);
		
		Map<String, Object> pMap = paymentService.exePaymentManageList(pageVo.getCrtPage(), pageVo.getKeyword(), pageVo.getCategory());
		System.out.println(pMap);
		
		return JsonResult.success(pMap);
	}
	
}
