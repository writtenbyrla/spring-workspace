package com.kh.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	// 회원가입
	// register(회원가입 누르면 회원가입 input form으로 이동)
	@RequestMapping("register")
	public String register() {
		return "register";
	}
	
	// signUp 처리
	@RequestMapping("signUp")
	public String signUp(Member vo) {
		service.register(vo);
		return "redirect:/";
	}
	
	// 로그인(경로이동)
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	// 로그인 처리(결과)
	@RequestMapping("signIn")
	public String signIn(HttpSession session, Member member) {
		Member vo = service.login(member);
		
		if(vo!=null) {
			session.setAttribute("vo", vo);
		}
		return "login_result";
	}
	
}
