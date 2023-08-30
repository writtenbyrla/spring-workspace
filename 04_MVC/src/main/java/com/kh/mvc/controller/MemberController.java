package com.kh.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	
	@RequestMapping("search")
	public String search() {
		return "search";
	}
	
	@RequestMapping("find")
	public String find(String keyword, Model model) {
		//System.out.println(keyword); // getParameter 값 바로 가져와짐(Member(id=user1, pwd=user1, name=유저, addr=서울))
		// --> list값! 데이터 바인딩 -> Model!!
		// model.addAttribute("list", list);
	
		List<Member> list = service.findMember(keyword);
		
		
		if(list.size()>0) {
			model.addAttribute("list", list);
			return "find_ok";
		}
		// 실패시 "find_fail"
		return "find_fail";

	}
	
	// register
	@RequestMapping("register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("signUp")
	public String signUp(Member member) {
		//System.out.println(member); // (Member(id=user1, pwd=user1, name=유저, addr=서울))
		// 비즈니스 로직
		
		service.registerMember(member);
		
		// 데이터바인딩 없이 index.jsp로 이동
		return "redirect:/"; 
	}
	
	// login - 페이지 이동
	// signIn - 비즈니스 로직 포함: 파라미터 값 -> HttpServletRequest request
	// 		-> return "login_result"
	
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("signIn")
	public String signIn(HttpSession session, Member member) {
//		Member m = new Member();
//		m.setId(member.getId());
//		m.setPwd(member.getPwd());
		Member vo = service.login(member);
		
		
		if(vo!=null) {
			session.setAttribute("vo", vo);
		}
		
		return "login_result";
	}
	
	
	
	// allMember - 비즈니스 로직 포함, 데이터바인딩 - Model
	// -> return "find_ok";
	
	@RequestMapping("allMember")
	public String allMember(Model model) {
		List<Member> list = service.allMember();
	
		model.addAttribute("list", list);		
		
		return "find_ok";
	}
	
	// logout - 로그아웃 기능
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			return "redirect:/";
		}
		return null;
	}
	
	// update - 페이지 이동
	// updateMember - 비즈니스 로직 포함 -> 파라미터 request 필요
	@RequestMapping("update")
	public String update() {
		return "update";
	}

	@RequestMapping("updateMember")
	public String updateMember(HttpSession session, Member member) {
	
		service.updateMember(member);
		
		if(session.getAttribute("vo")!=null) {
			session.setAttribute("vo", member);	
		}
		
		return "redirect:/";
		
		
	}
	
	

	
}
