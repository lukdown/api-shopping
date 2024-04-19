package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.MemberDao;
import com.javaex.vo.UserVo;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	//로그인
	public UserVo exeLogin(UserVo userVo) {
		System.out.println("MemberService.exeLogin()");
		UserVo authUser = memberDao.memberselectByIdPw(userVo);
		System.out.println(authUser);
		
		return authUser;
	}
	
	//회원가입
	public int exeJoin(UserVo userVo) {
		System.out.println("MemberService.exeJoin()");
		int count = memberDao.join(userVo);
		System.out.println(count);
		
		return count;
	}
	
	//중복체크
	public int exeIdCheck(String id) {
		System.out.println("MemberService.exeIdCheck");
		
		int count = memberDao.idCheck(id);
		
		return count;
	}
	
}
