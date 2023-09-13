package com.ncs.test.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.test.model.dao.MemberDAO;
import com.ncs.test.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	@Override
	public Member login(Member member) {
		return dao.login(member);
	}
}
