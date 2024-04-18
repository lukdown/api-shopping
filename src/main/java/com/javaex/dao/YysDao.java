package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ProductEVo;
import com.javaex.vo.ProductVo;
import com.javaex.vo.SalesVo;

@Repository
public class YysDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<SalesVo> chartSelect(String keyword) {
		System.out.println("FoodStoreDao.foodSelect()");
		List<SalesVo> chartList = sqlSession.selectList("sales.chartselect", keyword);
		System.out.println(chartList);

		return chartList;
	}

	
	
	
	
	
	
	
	
	
	
//	// 데이터 1개 가져오기 no 1개 데이터 가져오기
//	public List<ProductVo> productSelectOne(int p_no) {
//		System.out.println("YysDao..productSelectOne()");
//
//		// System.out.println(m_no);
//
//		List<ProductVo> pList = sqlSession.selectList("sales.selectProductOneList", p_no);
//
//		return pList;
//	}
//
//	// 데이터 1개 가져오기 no 1개 데이터 가져오기
//	public List<ProductEVo> producteSelectOne(int e_no) {
//		System.out.println("YysDao..producteSelectOne()");
//
//		// System.out.println(m_no);
//
//		List<ProductEVo> peList = sqlSession.selectList("sales.selectProducteOneList", e_no);
//
//		return peList;
//	}
	
	

	// 관리자 상품 리스트(검색O,페이징 O)
	public List<SalesVo> adminproductList(Map<String, Object> limiMap) {
		System.out.println("YysDao.adminproductList");

		List<SalesVo> adminproductList = sqlSession.selectList("sales.selectlist", limiMap);

		System.out.println(adminproductList);

		return adminproductList;
	}

	// 글 전체 갯수 //리스트(검색O,페이징O)
	public int selectAdminTotalCnt(String keyword) {
		System.out.println("YysDao.selectAdminTotalCnt()");

		int admintotalCount = sqlSession.selectOne("sales.selectTotalCnt", keyword);

		return admintotalCount;
	}
	
	
	
	
	
	
	
	
	
	
	

	// 고객 상품 리스트(검색O,페이징 O)
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
