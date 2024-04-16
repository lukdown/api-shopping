package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PjhService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.CartVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PjhController {

	@Autowired
	private PjhService pjhService;
	
	@GetMapping("api/customer/shoppingbasket")
	public JsonResult shoppingbasketListForm(HttpServletRequest request) {
		System.out.println("PjhController.shoppingbasketList()");
		
		int user_no = JwtUtil.getNoFromHeader(request);
		System.out.println(user_no);
		
		List<CartVo> cartVo = pjhService.exeShoppingbasketList(user_no);
		
		return JsonResult.success(cartVo);
	}
}
