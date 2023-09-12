package com.kh.mvc.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public int register(Member vo) {
		return session.insert("memberMapper.register", vo);
	}
	
	public List<Member> showAll(){
		return session.selectList("memberMapper.showAll");
	}
	
	public Member login(Member vo) {
		return session.selectOne("memberMapper.login", vo);
	}
	
	public List<Member> findMember(String keyword) {
		return session.selectOne("memberMapper.findMember", keyword);
	}
	
	public int updateMember(Member vo) {
		return session.update("memberMapper.updateMember", vo);
	}
	

}
