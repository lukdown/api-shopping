package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ProductVo;

@Repository
public class YysDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스트(검색O,페이징 O)
	public List<ProductVo> productList(Map<String, Object> limiMap) {
		System.out.println("YysDao.productList");

		List<ProductVo> productList = sqlSession.selectList("product.selectlist", limiMap);

		System.out.println(productList);

		return productList;
	}

	// 글 전체 갯수 //리스트(검색O,페이징O)
	public int selectTotalCnt(String keyword) {
		System.out.println("YysDao.selectTotalCnt()");

		int totalCount = sqlSession.selectOne("product.selectTotalCnt", keyword);

		return totalCount;
	}

}
