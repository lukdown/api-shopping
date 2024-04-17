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

	// 장바구니 리스트
	public List<CartVo> ShoppingbasketList(int user_no) {
		System.out.println("PjhDao.ShoppingbasketList()");

		List<CartVo> cartVo = sqlSession.selectList("cart.selectShoppingbasketList", user_no);

		return cartVo;
	}

	// 장바구니 삭제
	public int cartDelete(int no) {
		System.out.println("phonebookdao.personDelete()");

		int count = sqlSession.delete("cart.delete", no);

		return count;
	}

	// 장바구니 수정
	public int cartUpdate(CartVo cartVo) {

		int count = sqlSession.update("cart.update", cartVo);
		System.out.println(count);
		return count;
	}

	// 장바구니 전체삭제
	public int cartDeleteAll(int no) {
		System.out.println("phonebookdao.personDelete()");

		int count = sqlSession.delete("cart.deleteAll", no);

		return count;
	}

	// 상품 상세폼
	public CartVo productSelectOne(int no) {
		System.out.println("phonebookdao.personSelectOne");

		CartVo cartVo = sqlSession.selectOne("cart.selectOne", no);

		return cartVo;
	}
	
	// 상품 장바구니 등록
	public int cartInsert(CartVo cartVo) {

		int count = sqlSession.insert("cart.insertcart", cartVo);
		System.out.println(count);
		return count;
	}
}
