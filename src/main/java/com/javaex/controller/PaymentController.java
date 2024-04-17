package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PaymentService;
import com.javaex.util.JsonResult;
import com.javaex.vo.PageVo;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	//리스트
	@PostMapping("/api/admin/paymentmanage")
	public JsonResult paymentManageList(@RequestBody PageVo pageVo) {
		System.out.println("PaymentController.opaymentManageList())");
		//List<OrdersVo> paymentManageList = paymentService.exePaymentManageList();
		//System.out.println("paymentController"+paymentManageList);
		
		Map<String, Object> pMap = paymentService.exePaymentManageList(pageVo.getCrtPage(), pageVo.getKeyword(), pageVo.getCategory());
		System.out.println(pMap);
		
		return JsonResult.success(pMap);
	}
	
	//버튼 클릭 --> 배송상태 변경 
	@PutMapping("/api/admin/paymentmanage/{o_no}")
	public JsonResult pStatusChange(@PathVariable("o_no") int o_no) {
		System.out.println("PaymentController.pStatusChange()");
		System.out.println(o_no);
		int count = paymentService.exePStatusChange(o_no);
		return JsonResult.success(count);
	}
	
	
}
