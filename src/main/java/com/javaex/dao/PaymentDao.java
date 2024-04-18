package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CartVo;
import com.javaex.vo.OrdersVo;
import com.javaex.vo.ProductEVo;
import com.javaex.vo.ProductVo;
import com.javaex.vo.UserVo;

@Repository
public class PaymentDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스트(검색O,페이징 O)
	public List<OrdersVo> paymentManageList(Map<String, Object> limitMap) {
		System.out.println("paymentManageList()");
		System.out.println("limitMap: " + limitMap);
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

	// 배송상태 변경
	public int pStatusChange(int o_no) {
		System.out.println("pStatusChange()");
		int count = sqlSession.update("orders.pStatusChange", o_no);
		return count;
	}

	////////////////////////////////////////////////
	// 회원
	// 장바구니 내용 불러오기
	public List<CartVo> cartList(int no) {
		System.out.println("cartList()");
		List<CartVo> cartList = sqlSession.selectList("orders.cartList", no);
		return cartList;
	}

	// 개인정보 불러오기
	public UserVo userInfo(int no) {
		System.out.println("userInfo()");
		UserVo userVo = sqlSession.selectOne("orders.userInfo", no);
		return userVo;
	}

	public int insertOrders(OrdersVo ordersVo) {
		System.out.println("insertOrders()");
		sqlSession.insert("orders.insertOrders", ordersVo);
		System.out.println(ordersVo.getO_no());
		return ordersVo.getO_no();
	}

	public int insertProduct(ProductEVo productEVo) {
		System.out.println("insertProduct()");

		int count = sqlSession.insert("orders.insertProduct", productEVo);

		return count;
	}

	public int deleteCart(int no) {
		System.out.println("deleteCart()");
		return sqlSession.delete("orders.deleteCart", no);
	}
	
	//바로 결제 리스트
	public ProductVo cartListDirect(int p_no) {
		System.out.println("cartListDirect()");
		ProductVo producatVo = sqlSession.selectOne("orders.cartInfoDirect", p_no);
		return producatVo;
	}
	
}
