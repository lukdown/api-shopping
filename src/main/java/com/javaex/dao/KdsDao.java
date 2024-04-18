package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ProductVo;

@Repository
public class KdsDao {

	@Autowired
	private SqlSession sqlSession;

	//등록
	public int productInsert(ProductVo productVo) {
		System.out.println("ProductDao.productInsert()");
		
		int count=sqlSession.insert("product.insert", productVo);
		
		return count;
	}
	
	//1개 데이터 가져오기 - 삭제
	public int productDelete(ProductVo productVo) {
		System.out.println("ProductDao.productDelete()");
		
		int count=sqlSession.delete("product.delete", productVo);
		
		return count;
	}

	//리스트
	public List<ProductVo> productAdminList() {
		System.out.println("ProductDao.productAdminList()");

		List<ProductVo> pList = sqlSession.selectList("product.selectAll");

		return pList;
	}
}
