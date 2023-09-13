package com.kh.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	// 검색
	@RequestMapping("search")
	public String search() {
		return "search";
	}
	
	@RequestMapping("find")
	public String find(String keyword, Model model) {
		List<Member> list = service.findMember(keyword);
		
		if(list.size()>0) {
			model.addAttribute("list", list);
			return "find_ok";
		}
		return "find_fail";
	}
	
	// 전체 목록 보기
	@RequestMapping("allMember")
	public String allMember(Model model) {
		List<Member> list = service.showAll();
		model.addAttribute(list);
		return "find_ok";
	}
	
	// 로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			return "redirect:/";
		}
		return null;
	}
	
	// 정보 수정
	@RequestMapping("update")
	public String update() {
		return "update";
	}
	
	@RequestMapping("updateMember")
	public String updateMember(HttpSession session, Member member) {
		service.updateMember(member);
		
		if(session.getAttribute("vo")!=null) { // 기존 정보 확인해서 null값이 아닐때
//			service.updateMember(member);
			session.setAttribute("vo", member); // 바뀐 정보로 바인딩
		}
		return "redirect:/";
	}
	
}
