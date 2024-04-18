package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ProductVo;

@Repository
public class KdsDao {

	@Autowired
	private SqlSession sqlSession;

	// 등록
	public int productInsert(ProductVo productVo) {
		System.out.println("ProductDao.productInsert()");

		int count = sqlSession.insert("product.insert", productVo);

		return count;
	}

	//삭제
	public int productDelete(int no) {
		System.out.println("ProductDao.productDelete()");

		int count = sqlSession.delete("product.delete", no);

		return count;
	}
	
	public int productDelete2(int no) {
		System.out.println("ProductDao.productDelete()");

		int count = sqlSession.delete("product.delete2", no);

		return count;
	}

	// 리스트(검색O,페이징 O)
	public List<ProductVo> productAdminList(Map<String, Object> limiMap) {
		System.out.println("ProductDao.productAdminList()");

		List<ProductVo> pList = sqlSession.selectList("product.selectAll", limiMap);

		System.out.println(pList);

		return pList;
	}

	// 글 전체 갯수 //리스트(검색O,페이징O)
	public int selectproductTotalCnt(String keyword) {
		System.out.println("PtDao.selectmemberTotalCnt()");

		int totalCount = sqlSession.selectOne("product.selectproductTotalCnt", keyword);

		return totalCount;
	}

}
