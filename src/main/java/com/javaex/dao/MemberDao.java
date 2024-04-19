package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//로그인
	public UserVo memberselectByIdPw(UserVo userVo) {
		System.out.println("MemberDao.memberselectByIdPw()");
		System.out.println(userVo);
		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);
		System.out.println(authUser);
		
		return authUser;
	}
	
	//회원가입
	public int join(UserVo userVo) {
		System.out.println("MemberDao.join()");
		int count = sqlSession.insert("user.join", userVo);
		System.out.println(count);
		
		return count;
	}
	
	//중복체크
	public int idCheck(String id) {
		System.out.println("MemberDao.idCheck()");
		int count = sqlSession.selectOne("user.idCheck" , id);
		System.out.println(count);
		
		return count;
	}
}
