package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.KdsDao;
import com.javaex.vo.ProductVo;

@Service
public class KdsService {

	@Autowired
	private KdsDao kdsDao;

	// 등록
	public int exeProductWrite(String p_name, int p_price, String p_category, String p_explanation,
			MultipartFile file) {
		System.out.println("ProductService.exeProductWrite()");

		// 파일저장 폴더
		String saveDir = "C:\\javaStudy\\upload";

		// (0)파일관련 정보수집
		// 오리지날 파일명
		String orgName = file.getOriginalFilename();
		System.out.println("orgName:" + orgName);

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println("exName:" + exName);

		// 저장 파일명(겹치지 않아야 한다)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName:" + saveName);

		// 파일 사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize:" + fileSize);

		// 파일 전체 경로(저장파일명 포함)
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath:" + filePath);

		// (1)파일정보를 DB에 저장
		// *vo묶어주고

		ProductVo productVo = new ProductVo(p_name, p_price, p_category, p_explanation, orgName, saveName, filePath,
				fileSize);
		System.out.println(productVo);
		// *db에 저장
		System.out.println(".......DB저장롼료");
		int count = kdsDao.productInsert(productVo);
		// (2)파일을 하드디스크에 저장

		// 파일 저장
		try {
			byte[] fileData = file.getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		;

		return count;
	}

	// 삭제
	public int exeProductRemove(int no) {
		System.out.println("ProductService.exeProductRemove()");

		int count2 = kdsDao.productDelete2(no);

		int count = kdsDao.productDelete(no);

		return count;
	}

	// 리스트
	public Map<String, Object> exeProductAdminList(int crtPage, String keyword) {
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
