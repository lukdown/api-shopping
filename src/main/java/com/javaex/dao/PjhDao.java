package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CartVo;

@Repository
public class PjhDao {

	private SqlSession sqlSession;
	
	public List<CartVo> ShoppingbasketList(int user_no){
		System.out.println("PjhDao.ShoppingbasketList()");
		
		List<CartVo> cartVo = sqlSession.selectList("cart.selectShoppingbasketList",user_no);
		
		return cartVo;
	}
}
