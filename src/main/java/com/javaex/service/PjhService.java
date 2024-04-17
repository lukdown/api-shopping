package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PjhDao;
import com.javaex.vo.CartVo;

@Service
public class PjhService {

	@Autowired
	private PjhDao pjhDao;

	// 장바구니 리스트
	public List<CartVo> exeShoppingbasketList(int user_no) {
		System.out.println("PjhService.exeShoppingbasketList()");

		List<CartVo> cartVo = pjhDao.ShoppingbasketList(user_no);

		return cartVo;
	}

	// 장바구니 삭제
	public int exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete()");

		int count = pjhDao.cartDelete(no);

		return count;
	}

	// 장바구니 수정
	public int exeUpdate(CartVo cartVo) {

		int count = pjhDao.cartUpdate(cartVo);

		return count;
	}

	// 장바구니 전체삭제
	public int exeDeleteAll(int no) {
		System.out.println("PhonebookService.exeDelete()");

		int count = pjhDao.cartDeleteAll(no);

		return count;
	}

	// 상품 상세폼
	public CartVo exeinsertform(int no) {
		System.out.println("PhonebookService.exeModifyForm()");

		CartVo cartVo = pjhDao.productSelectOne(no);

		return cartVo;
	}

	// 상품 장바구니 등록
	public int exeInsert(CartVo CartVo) {

		int count = pjhDao.cartInsert(CartVo);

		return count;
	}

}
