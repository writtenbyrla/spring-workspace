package com.kh.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Greeting;

@RestController
public class GreetingController {

	// http://localhost:8080/api/greet -> selectList
	@GetMapping("/greet")
	public Greeting sayGreet() {
		return new Greeting(314L, "Restful API");
	}
	
	// http://localhost:8080/board/view?no=23 (list => view 갈 때)(이렇게 안 씀)
	// --> http://localhost:8080/board/23 --> selectOne (parameter 대신 url 경로에 포함시키는 방식)
	@GetMapping("/greet/{id}") // id 부분을 받아서 넘김
	public String showSample(@PathVariable int id) { // PathVariable : URL 경로의 일부를 파라미터로 사용할 때
		return "Hello REST API case number.." + id;
	}
	
	// http://localhost:8080/search?keyword=키워드
	@GetMapping("/greet2")
	public Greeting sayGreet2(String content) {
		return new Greeting(500L, content);
	}
}
