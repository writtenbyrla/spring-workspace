package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.MemberDAO;
import com.kh.mvc.model.vo.Member;



@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	public int register(Member vo) {
		return dao.register(vo);
	}
	
	public List<Member> showAll(){
		return dao.showAll();
	}
	
	public List<Member> findMember(String keyword){
		return dao.findMember(keyword);
	}
	
	public Member login(Member vo) {
		return dao.login(vo);
	}
	
	public int updateMember(Member vo) {
		return dao.updateMember(vo);
	}
}
