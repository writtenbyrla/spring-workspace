package com.kh.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	// 패스워드 암호화(security-context.xml에서 bean 등록 후 autowired)
	@Autowired
	private BCryptPasswordEncoder bcpe;

	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@GetMapping("/logout")
	public void logout() {}
	
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(Member vo) {
		// 암호화 전 패스워드
		System.out.println("before password : " + vo.getPassword());
		
		// BcryptPasswordEncoder를 이용해서 암호화 처리
		String encodePasswordString = bcpe.encode(vo.getPassword());
		System.out.println("after password : " + encodePasswordString);
		
		vo.setPassword(encodePasswordString);
		
		service.registerMember(vo);
		return "redirect:/login";
	}
}	
