package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ProductVo;

@Repository
public class YysDao {

	@Autowired
	private SqlSession sqlSession;

	// 전체가져오기
	public List<ProductVo> productSelect() {
		System.out.println("YysDao.productSelect()");

		List<ProductVo> productList = sqlSession.selectList("product.selectList");

		// System.out.println(personList);

		return productList;
	}

}
