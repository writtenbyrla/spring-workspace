package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;

@Controller
@RequestMapping("/board/*") // board 폴더 아래 경로로 이동
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// ModelAndView를 쪼개서 Model은 addAttribute로 바인딩 / view는 string 형태로 return함
//	@RequestMapping("board/list")
//	public String list(Model model) {
//		List<Board> list = service.selectAllBoard();
//		model.addAttribute("list", list);
//		// new ModelAndView(경로, 바인딩할 변수, 넘길 값)
//		return "board/list";
//	}
	
	// void로 사용 가능
	// @RequestMapping(value="/list", method=RequestMethod.GET)
	@GetMapping("/list")
	public void list(Model model) {
		List<Board> list = service.selectAllBoard();
		model.addAttribute("list", list);
	}
	
	// 매핑 종류가 여러가지가 있음(CRUD 다 가능) - 같은 list라도 방식을 다르게 해서 사용 가능
	// @PostMapping("/list") 
	// @PutMapping
	// @DeleteMapping
	
	
	// 클래스 위쪽에 requestmapping 해줬기 때문에 하위경로만 기재
	@RequestMapping("/insert")
	public void insert() {
		
	}
	
}
