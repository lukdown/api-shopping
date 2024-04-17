package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.KdsDao;
import com.javaex.vo.ProductVo;

@Service
public class KdsService {

	@Autowired
	private KdsDao kdsDao;

	//등록
	public int exeProductWrite(ProductVo productVo) {
		System.out.println("ProductService.exeProductWrite()");
		
		int count=kdsDao.productInsert(productVo);
		
		return count;
	}
	
	//삭제
	public int exeProductRemove(ProductVo productVo) {
		System.out.println("ProductService.exeProductRemove()");
		
		int count=kdsDao.productDelete(productVo);
		
		return count;
	}

	//리스트
	public List<ProductVo> exeProductAdminList() {
		System.out.println("ProductService.exeProductAdminList()");

		List<ProductVo> pList = kdsDao.productAdminList();

		return pList;
	}
}
