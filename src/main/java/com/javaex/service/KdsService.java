package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.KdsDao;
import com.javaex.vo.ProductVo;

@Service
public class KdsService {

	@Autowired
	private KdsDao kdsDao;

	//등록
	public int exeProductWrite(ProductVo productVo) {
		System.out.println("ProductService.exeProductWrite()");
		
		int count=kdsDao.productInsert(productVo);
		
		return count;
	}
	
	//삭제
	public int exeProductRemove(int no) {
		System.out.println("ProductService.exeProductRemove()");
		
		int count2 = kdsDao.productDelete2(no);
		
		int count=kdsDao.productDelete(no);
		
		
		
		return count;
	}

	//리스트
	public Map<String, Object> exeProductAdminList(int crtPage,String keyword) {
		System.out.println("ProductService.exeMyMemberList()");

		// 한페이지당 출력 글갯수
		int listCnt = 10;

		// crtPage
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);
		/*
		 * if(crtPage > 0) { crtPage = crtPage }else { crtPage = 1; }
		 */

		// starRowNo번호
		// 1->1 10, 2->11 20, 3->21,30
		// 1->0 10, 2->11 10, 3->20,10
		// (1-1)10->0
		// (2-1)10->10
		// (crtPage-1) * listCnt ->20

		int startRowNo = (crtPage - 1) * listCnt;

		// starRowNo, listCnt Map으로 묶는다
		Map<String, Object> limiMap = new HashMap<String, Object>();
		limiMap.put("startRowNo", startRowNo);
		limiMap.put("listCnt", listCnt);
		limiMap.put("keyword", keyword);

		// dao에 전달해서 현재페이지의 리스트 10개를 받는다	
		List<ProductVo> pList = kdsDao.productAdminList(limiMap);

		///////////////////////////////////////////////////////////
		// 페이징 계산
		///////////////////////////////////////////////////////////

		// 페이지당 버튼 갯수
		int pageBtncount = 5;

		// 전체 글갯수
		int totalCnt = kdsDao.selectproductTotalCnt(keyword);
		
		// 1~5 -> (1,5)
		// 6~10 -> (6,10)
		// 11~15 -> (11,15)

		// 1 5 => 올림(1/5)*5 --> 0.2(1)*5 => 5
		// 2 5 => 올림(2/5)*5 --> 0.4(1)*5 => 5
		// 3 5 => 올림(3/5)*5 --> 0.6(1)*5 => 5
		// 4 5 => 올림(4/5)*5 --> 0.8(1)*5 => 5
		// 5 5 => 올림(5/5)*5 --> 1.0(1)*5 => 5
		// 6 5 => 올림(6/5)*5 --> 1.2(2)*5 => 10
		// 7 5 => 올림(7/5)*5 --> 1.4(2)*5 => 10
		// 11 5 => 올림(11/5)*5 --> 2.2(3)*5 => 15
		// 마지막 버튼 번호
		int endPageBtnNo = (int) Math.ceil(crtPage / (double) pageBtncount) * pageBtncount;

		
		// 시작 버튼 번호
		int startPageBtnNo = (endPageBtnNo - pageBtncount) + 1;
		
		
		
		// 다음 화살표 유무
		boolean next = false;
		if (listCnt * endPageBtnNo < totalCnt) { // 한페이지당글갯수(10) * 마지막버튼번호(5) <전체글갯수 102개
			next = true;
		} else { // 다음화살표가 false일떄 마지막 버튼 번호 정확히 계산 187 --> 19
			endPageBtnNo = (int) Math.ceil(totalCnt / (double) listCnt);
		}

		// 이전 화살표 유무
		boolean prev = false;
		if (startPageBtnNo != 1) {
			prev = true;
		}

		// 5개 map으로 묶어서 controller한테 보낸다 리턴해준다
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("pList", pList);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("prev", prev);
		pMap.put("next", next);
		

		return pMap;
	}
}
