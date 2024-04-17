package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CartVo;

@Repository
public class PjhDao {
	@Autowired
	private SqlSession sqlSession;

	public List<CartVo> ShoppingbasketList(int user_no) {
		System.out.println("PjhDao.ShoppingbasketList()");

		List<CartVo> cartVo = sqlSession.selectList("cart.selectShoppingbasketList", user_no);

		return cartVo;
	}

	// 삭제
	public int cartDelete(int no) {
		System.out.println("phonebookdao.personDelete()");

		int count = sqlSession.delete("cart.delete", no);

		return count;
	}

	// 수정
	public int cartUpdate(CartVo cartVo) {

		int count = sqlSession.update("cart.update", cartVo);
		System.out.println(count);
		return count;
	}

	// 전체삭제
	public int cartDeleteAll(int no) {
		System.out.println("phonebookdao.personDelete()");

		int count = sqlSession.delete("cart.deleteAll", no);

		return count;
	}
}
