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
		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);
		System.out.println(authUser);
		
		return authUser;
	}
}
