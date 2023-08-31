package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

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
	// 클래스 위쪽에 requestmapping 해줬기 때문에 하위경로만 기재
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
	
		List<Board> list = service.selectAllBoard(cri);
		model.addAttribute("list", list);
		model.addAttribute("paging", new Paging(cri, service.getTotal()));
	}
	
	// 매핑 종류가 여러가지가 있음(CRUD 다 가능) - 같은 list라도 방식을 다르게 해서 사용 가능
	// @PostMapping("/list") 
	// @PutMapping
	// @DeleteMapping
	

	@GetMapping("/insert")
	public void insert() {
		
	}
	
	// 등록 버튼 눌렀을때 처리되는 로직
	@PostMapping("/insert")
	public String insert(Board board) {
		service.insertBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/view")
	public void view(int no, Model model) {
		Board board = service.selectBoard(no);
		model.addAttribute("vo", board);
	}
	
	@PostMapping("/update")
	public String update(Board board) {
		service.updateBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete")
	public String delete(int no) {
		service.deleteBoard(no);
		return "redirect:/board/list";
	}
	
}
