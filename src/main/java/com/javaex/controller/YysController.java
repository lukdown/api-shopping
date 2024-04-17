package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.YysService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.PageVo;
import com.javaex.vo.ProductVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class YysController {

	@Autowired
	private YysService yysService;

	// 리스트 가져오기
	@PostMapping(value = "/api/customer/list")
	public JsonResult productlist(HttpServletRequest request, @RequestBody PageVo pageVo) {
		System.out.println("YysController.productlist()");

		System.out.println(pageVo);

		//int trainer_no = JwtUtil.getNoFromHeader(request);

		Map<String, Object> pMap = yysService.exeList(pageVo.getCrtPage(), pageVo.getKeyword());

		//return null;
		return JsonResult.success(pMap);
	}

}
