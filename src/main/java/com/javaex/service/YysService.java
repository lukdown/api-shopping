package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.YysDao;
import com.javaex.vo.ProductVo;

@Service
public class YysService {

	@Autowired
	private YysDao yysDao;

	// 리스트
	public List<ProductVo> exeList() {
		System.out.println("YysService.exeList()");

		List<ProductVo> productList = yysDao.productSelect();

		return productList;
	}

}
