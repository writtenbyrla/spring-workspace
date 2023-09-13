package com.ncs.test.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncs.test.member.model.service.MemberServiceImpl;
import com.ncs.test.model.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberServiceImpl service;
	
	@RequestMapping("login")
	public String memberLogin(HttpSession session, Member member) {
		Member vo = service.login(member);
		
		if(vo!=null) {
			session.setAttribute("vo", vo);
			return "redirect:/";
		}
		return "errorPage";
	}
}
