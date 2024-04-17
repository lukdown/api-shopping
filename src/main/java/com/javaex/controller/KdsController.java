package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.KdsService;
import com.javaex.util.JsonResult;
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
	@PostMapping("api/admin/delete/{p_no}")
	public JsonResult productdelete(@PathVariable("p_no") int p_no) {
		System.out.println("ProductController.delete()");
		
		ProductVo pVo=new ProductVo();
		pVo.setP_no(p_no);
		
		int count=kdsService.exeProductRemove(pVo);
		
		return JsonResult.success(count);
	}
	
	//리스트
	@GetMapping("api/admin/productlist")
	public JsonResult productAdminList() {
		System.out.println("ProductController.productAdminList()");
		
		List<ProductVo> pList = kdsService.exeProductAdminList();
		
		return JsonResult.success(pList);
	}
	
}
