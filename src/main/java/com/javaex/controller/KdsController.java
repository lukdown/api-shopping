package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.KdsService;
import com.javaex.util.JsonResult;
import com.javaex.vo.PageVo;
import com.javaex.vo.ProductVo;

@RestController
public class KdsController {

	@Autowired
	private KdsService kdsService;
	
	//등록
	@PostMapping("api/admin/add")
	public JsonResult productWrite(@RequestBody ProductVo productVo) {
		System.out.println("ProductController.write()");
		
		int count=kdsService.exeProductWrite(productVo);
		
		return JsonResult.success(count);
	}
	
	//삭제
	@DeleteMapping("api/admin/delete/{p_no}")
	public JsonResult productdelete(@PathVariable("p_no") int no) {
		System.out.println("ProductController.delete()");
		
		int count=kdsService.exeProductRemove(no);
		
		return JsonResult.success(count);
	}
	
	//리스트
	@PostMapping("api/admin/productlist")
	public JsonResult productAdminList(@RequestBody PageVo pageVo) {
		System.out.println("ProductController.productAdminList()");
		
		System.out.println(pageVo);
		
		Map<String, Object> pMap = kdsService.exeProductAdminList(pageVo.getCrtPage(),pageVo.getKeyword());
		
		return JsonResult.success(pMap);
	}
	
}
