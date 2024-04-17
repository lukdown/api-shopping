package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PaymentDao;
import com.javaex.vo.CartVo;
import com.javaex.vo.OrdersVo;
import com.javaex.vo.UserVo;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;
	
	//리스트
	public Map<String, Object> exePaymentManageList(int crtPage, String keyword, String category) {
		System.out.println("PtService.exeMyMemberList()");

		// 한페이지당 출력 글갯수
		int listCnt = 9;

		// crtPage
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);

		int startRowNo = (crtPage - 1) * listCnt;

		// starRowNo, listCnt Map으로 묶는다
		Map<String, Object> limitMap = new HashMap<String, Object>();
		limitMap.put("startRowNo", startRowNo);
		limitMap.put("listCnt", listCnt);
		limitMap.put("keyword", keyword);
		limitMap.put("category", category);

		// dao에 전달해서 현재페이지의 리스트 10개를 받는다
		List<OrdersVo> pList = paymentDao.paymentManageList(limitMap);
		System.out.println(pList);

		// 페이징 계산

		// 페이지당 버튼 갯수
		int pageBtncount = 5;

		// 전체 글갯수
		int totalCnt = paymentDao.selectmemberTotalCnt(limitMap);

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
	
	
	//배송상태 변경 
	public int exePStatusChange(int o_no) {
		System.out.println("exePStatusChange()");
		int count = paymentDao.pStatusChange(o_no);
		return count;
	}
	
	/////////////////////////////////////////////////////////////////////////
	//회원
	
	//회원 리스트 
	public Map<String, Object> exeCustomerView(int no){
		System.out.println("exeCustomerView()");
		
		List<CartVo> cartList = paymentDao.cartList(no);
		UserVo userVo = paymentDao.userInfo(no);
		
		Map<String, Object> customerMap = new HashMap<String, Object>();
		customerMap.put("cartList", cartList);
		customerMap.put("userVo", userVo);
		
		return customerMap;
	}
	
	
	
	
	
	
	
}
