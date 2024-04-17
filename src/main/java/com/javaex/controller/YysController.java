package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.YysService;
import com.javaex.vo.ProductVo;

@RestController
public class YysController {

	@Autowired
	private YysService yysService;

	// 리스트 가져오기
	@GetMapping(value = "/api/customer/list")
	public List<ProductVo> list() {
		System.out.println("YysController.list()");

		List<ProductVo> productList = yysService.exeList();

		System.out.println(productList);
		return productList;
	}

}
