package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.MemberService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	//로그인
	@PostMapping("/api/customer/login")
	public JsonResult login(@RequestBody UserVo userVo, HttpServletResponse response) {
		System.out.println("MemberController.login()");
		
		UserVo authUser = memberService.exeLogin(userVo);
		System.out.println(authUser);
		
		if (authUser != null) {
			//토큰 발급 헤더에 실어 보낸다
			JwtUtil.createTokenAndSetHeader(response, ""+ authUser.getUser_no());
			return JsonResult.success(authUser);
		}else {
			return JsonResult.fail("실패");
		}
		
	}

}
