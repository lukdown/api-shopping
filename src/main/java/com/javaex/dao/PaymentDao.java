package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.OrdersVo;
import com.javaex.vo.PageVo;

@Repository
public class PaymentDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 리스트(검색O,페이징 O)
	public List<OrdersVo> paymentManageList(Map<String, Object> limitMap) {
		System.out.println("paymentManageList()");
		System.out.println("limitMap: "+limitMap);
		List<OrdersVo> paymentManageList = sqlSession.selectList("orders.paymentManageList", limitMap);
		System.out.println(paymentManageList);
		return paymentManageList;
	}
	
	// 글 전체 갯수 //리스트(검색O,페이징O)
	public int selectmemberTotalCnt(Map<String, Object> limitMap) {
		System.out.println("PaymentDao.selectmemberTotalCnt()");

		int totalCount = sqlSession.selectOne("orders.selectOrdersTotalCnt", limitMap);

		return totalCount;
	}
	
}
