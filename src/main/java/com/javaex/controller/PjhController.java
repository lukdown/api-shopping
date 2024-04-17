package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

		System.out.println(cartVo);

		return JsonResult.success(cartVo);
	}

	// 삭제
	@DeleteMapping(value = "/api/customer/shoppingbasket/{c_no}")
	public JsonResult remove(@PathVariable(value = "c_no") int no) {
		System.out.println("PhonebookController.remove()");

		System.out.println(no);

		int count = pjhService.exeDelete(no);

		return JsonResult.success(count);
	}

	// 수정
	@PutMapping(value = "/api/customer/shoppingbasket")
	public JsonResult modify(@RequestBody CartVo cartVo) {
		System.out.println("PhonebookController.modifyform()");

		int count = pjhService.exeUpdate(cartVo);

		return JsonResult.success(count);
	}

	// 전체삭제
	@DeleteMapping(value = "/api/customer/shoppingbasket")
	public JsonResult removeAll(HttpServletRequest request) {
		System.out.println("PhonebookController.remove()");

		int user_no = JwtUtil.getNoFromHeader(request);

		System.out.println(user_no);

		int count = pjhService.exeDeleteAll(user_no);

		return JsonResult.success(count);
	}
}
