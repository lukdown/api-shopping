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

	public List<CartVo> exeShoppingbasketList(int user_no) {
		System.out.println("PjhService.exeShoppingbasketList()");

		List<CartVo> cartVo = pjhDao.ShoppingbasketList(user_no);

		return cartVo;
	}

	// 삭제
	public int exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete()");

		int count = pjhDao.cartDelete(no);

		return count;
	}

	// 수정
	public int exeUpdate(CartVo cartVo) {

		int count = pjhDao.cartUpdate(cartVo);

		return count;
	}

	// 전체삭제
	public int exeDeleteAll(int no) {
		System.out.println("PhonebookService.exeDelete()");

		int count = pjhDao.cartDeleteAll(no);

		return count;
	}

}
