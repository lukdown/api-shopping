package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.OrdersVo;

@Repository
public class PaymentDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<OrdersVo> paymentManageList() {
		System.out.println("paymentManageList()");
		
		List<OrdersVo> paymentManageList = sqlSession.selectList("orders.paymentManageList");
		System.out.println(paymentManageList);
		return paymentManageList;
	}
	
}
