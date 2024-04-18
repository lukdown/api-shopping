package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PaymentService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.OrdersVo;
import com.javaex.vo.PageVo;
import com.javaex.vo.ProductEVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	// 리스트
	@PostMapping("/api/admin/paymentmanage")
	public JsonResult paymentManageList(@RequestBody PageVo pageVo) {
		System.out.println("PaymentController.opaymentManageList())");
		// List<OrdersVo> paymentManageList = paymentService.exePaymentManageList();
		// System.out.println("paymentController"+paymentManageList);

		Map<String, Object> pMap = paymentService.exePaymentManageList(pageVo.getCrtPage(), pageVo.getKeyword(),
				pageVo.getCategory());
		System.out.println(pMap);

		return JsonResult.success(pMap);
	}

	// 버튼 클릭 --> 배송상태 변경
	@PutMapping("/api/admin/paymentmanage/{o_no}")
	public JsonResult pStatusChange(@PathVariable("o_no") int o_no) {
		System.out.println("PaymentController.pStatusChange()");
		System.out.println(o_no);
		int count = paymentService.exePStatusChange(o_no);
		return JsonResult.success(count);
	}

	///////////////////////////////////////////////////////////
	//// 회원////
	@GetMapping("/api/customer/payment")
	public Map<String, Object> customerView(HttpServletRequest request) {
		System.out.println("customerView");

		int no = JwtUtil.getNoFromHeader(request);
		Map<String, Object> paymentMap = paymentService.exeCustomerView(no);
		System.out.println(paymentMap);
		return paymentMap;
	}

	// orders insert
	@PostMapping("/api/customer/payment")
	public JsonResult InsertOrders(@RequestBody OrdersVo ordersVo, HttpServletRequest request) {
		System.out.println("PaymentController.InsertOrders()");

		// 토큰에서 로그인한 회원번호
		// JWT 토큰에서 no 값을 추출
		int no = JwtUtil.getNoFromHeader(request);
		ordersVo.setUser_no(no);
		System.out.println(no);
		if (no != -1) { // 정상
			int count = paymentService.exeInsertOrders(ordersVo);
			System.out.println("count:            " + count);

			return JsonResult.success(count);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// product insert
	@PostMapping("/api/customer/payment/p")
	public JsonResult InsertProductE(@RequestBody List<ProductEVo> paymentList, HttpServletRequest request) {
		System.out.println("PaymentController.PayproductE()");

		// 토큰에서 로그인한 회원번호
		// JWT 토큰에서 no 값을 추출
		int no = JwtUtil.getNoFromHeader(request);
		System.out.println(paymentList);
		if (no != -1) { // 정상
			int result = paymentService.exeInsertProductE(paymentList);
			System.out.println("result:            " + result);

			return JsonResult.success(result);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 장바구니 비워주기
	@DeleteMapping("/api/customer/payment")
	public JsonResult deleteCart(HttpServletRequest request) {
		System.out.println("PaymentController.deleteCart()");

		// 토큰에서 로그인한 회원번호
		// JWT 토큰에서 no 값을 추출
		int no = JwtUtil.getNoFromHeader(request);
		
		if (no != -1) { // 정상
			int delete = paymentService.exeDeleteCart(no);
			System.out.println("delete:            " + delete);

			return JsonResult.success(delete);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}
	
	
	
}
