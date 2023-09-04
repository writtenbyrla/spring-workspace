package com.kh.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

@Controller
@RequestMapping("/board/*") // board 폴더 아래 경로로 이동
public class BoardController {
	
	String path = "D:\\spring-workspace\\05_MVC_Board\\src\\main\\webapp\\upload\\";

	
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
	public String insert(Board board) throws IOException {
		
		// 파일업로드 메서드
		fileUpload(board);
		
		service.insertBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/view")
	public void view(int no, Model model) {
		model.addAttribute("vo",  service.selectBoard(no));
	}
	
	@GetMapping("/update")
	public void update(int no, Model model) {
		model.addAttribute("vo", service.selectBoard(no));
	}
	
	public void fileUpload(Board board) throws IOException {
		// 파일 업로드 기능 추가
		MultipartFile file = board.getUploadFile();
		System.out.println("file : " + file); // file : org.springframework.web.multipart.commons.CommonsMultipartFile@2b7f5400
		
		if(!file.isEmpty()) { // 업로드한 파일이 있는 경우
			
			// 기존에 파일이 있는 경우 삭제!
			if(board.getUrl()!=null) {
				File delFile = new File(path+board.getUrl().replace("/upload/", ""));
				delFile.delete();
			}
			
			System.out.println("파일 사이즈 : " + file.getSize()); 
			System.out.println("업로드된 파일명 : " + file.getOriginalFilename());
			System.out.println("파일의 파라미터명 : " + file.getName());
			/*파일 사이즈 : 82881
			업로드된 파일명 : test.jpg
			파일의 파라미터명 : uploadFile*/
			
			// path 계속 사용하니까 제일 상단에 전역변수로 올림
			//String path = "D:\\spring-workspace\\05_MVC_Board\\src\\main\\webapp\\upload\\";
			
			// 중복 방지를 위한 UUID 적용
			UUID uuid = UUID.randomUUID();
			String filename= uuid.toString() + "_" + file.getOriginalFilename();

			File copyFile = new File(path + filename);
			file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장
			
			// 데이터베이스에 경로 저장(Servers> Tomcat > server.xml 수정 해야 함)
			board.setUrl("/upload/" + filename);
		}
	}
	
	
	@PostMapping("/update")
	public String update(Board board) throws IOException {
		
		// 파일업로드 메서드
		fileUpload(board);
		
		service.updateBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete")
	public String delete(int no) {
		Board board = service.selectBoard(no);
		
		if(board.getUrl()!=null) {
			File delFile = new File(path+board.getUrl().replace("/upload/", ""));
			delFile.delete();
		}
		
		service.deleteBoard(no);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/download")
	public ModelAndView downloadFile(String filename) {
		
		HashMap map =new HashMap();
		map.put("path", path);
		
		return new ModelAndView("downloadView", map);
	}
	
}
