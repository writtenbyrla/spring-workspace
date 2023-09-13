package com.ncs.test.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.test.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public Member login(Member member) {
		return session.selectOne("memberMapper.loginMember", member);
	}
}
