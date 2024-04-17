package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	// 장바구니 리스트
	@GetMapping("api/customer/shoppingbasket")
	public JsonResult shoppingbasketListForm(HttpServletRequest request) {
		System.out.println("PjhController.shoppingbasketList()");

		int user_no = JwtUtil.getNoFromHeader(request);
		System.out.println(user_no);

		List<CartVo> cartVo = pjhService.exeShoppingbasketList(user_no);

		System.out.println(cartVo);

		return JsonResult.success(cartVo);
	}

	// 장바구니 삭제
	@DeleteMapping(value = "/api/customer/shoppingbasket/{c_no}")
	public JsonResult remove(@PathVariable(value = "c_no") int no) {
		System.out.println("PjhController.remove()");

		System.out.println(no);

		int count = pjhService.exeDelete(no);

		return JsonResult.success(count);
	}

	// 장바구니 수정
	@PutMapping(value = "/api/customer/shoppingbasket")
	public JsonResult modify(@RequestBody CartVo cartVo) {
		System.out.println("PjhController.modify()");

		int count = pjhService.exeUpdate(cartVo);

		return JsonResult.success(count);
	}

	// 장바구니 전체삭제
	@DeleteMapping(value = "/api/customer/shoppingbasket")
	public JsonResult removeAll(HttpServletRequest request) {
		System.out.println("PjhController.remove()");

		int user_no = JwtUtil.getNoFromHeader(request);

		System.out.println(user_no);

		int count = pjhService.exeDeleteAll(user_no);

		return JsonResult.success(count);
	}

	// 상품 상제정보폼
	@GetMapping(value = "/api/customer/productdetails/{p_no}")
	public JsonResult insertform(@PathVariable(value = "p_no") int no) {
		System.out.println("PjhController.insertform()");
		System.out.println(no);

		CartVo cartVo = pjhService.exeinsertform(no);
		System.out.println(cartVo);

		return JsonResult.success(cartVo);
	}

	// 상품 장바구니 등록
	@PostMapping(value = "/api/customer/productdetails/{p_no}")
	public int Insert(@RequestBody CartVo cartVo,HttpServletRequest request,
					  @PathVariable(value = "p_no") int no) {
		System.out.println("PjhController.Insert()");

		int user_no = JwtUtil.getNoFromHeader(request);
		
		System.out.println(cartVo + "gfsdgfs");
		System.out.println(no + "gsfgdfgdfhzxdthxrtujhxrtujh");
		
		
		cartVo.setUser_no(user_no);
		cartVo.setP_no(no);
		
		int count = pjhService.exeInsert(cartVo);

		return count;
	}
}
