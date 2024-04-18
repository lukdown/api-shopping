package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.KdsService;
import com.javaex.util.JsonResult;
import com.javaex.vo.PageVo;

@RestController
public class KdsController {

	@Autowired
	private KdsService kdsService;
	
	//등록
	@PostMapping("api/admin/add")
	public JsonResult productWrite(@RequestParam String p_name,
								   @RequestParam int p_price,
								   @RequestParam String p_category,
								   @RequestParam String p_explanation,
								   @RequestParam MultipartFile file) {
		System.out.println("KdsController.write()");
		
		int count=kdsService.exeProductWrite(p_name,p_price,p_category,p_explanation,file);
		
		
		return JsonResult.success(count);
	}
	
	//삭제
	@DeleteMapping("api/admin/delete/{p_no}")
	public JsonResult productdelete(@PathVariable("p_no") int no) {
		System.out.println("KdsController.delete()");
		
		int count=kdsService.exeProductRemove(no);
		
		return JsonResult.success(count);
	}
	
	//리스트
	@PostMapping("api/admin/productlist")
	public JsonResult productAdminList(@RequestBody PageVo pageVo) {
		System.out.println("KdsController.productAdminList()");
		
		System.out.println(pageVo);
		
		Map<String, Object> pMap = kdsService.exeProductAdminList(pageVo.getCrtPage(),pageVo.getKeyword());
		
		return JsonResult.success(pMap);
	}
	
}
