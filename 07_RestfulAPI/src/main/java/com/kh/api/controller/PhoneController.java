package com.kh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Phone;
import com.kh.api.service.PhoneServiceImpl;

@RestController
public class PhoneController {
	
	@Autowired
	public PhoneServiceImpl service;
	
	@GetMapping("/phone")
	public ResponseEntity select() {
		// Phone 전체 리스트
		List<Phone> list = service.select();
		return new ResponseEntity(list, HttpStatus.OK); // 데이터와 함께 상태코드도 보낼 수 있음 // 200 OK
	}
	
	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num) {
		Phone phone = new Phone();
		phone.setNum(num);
		phone = service.select(phone);
		return new ResponseEntity(phone, HttpStatus.OK); // content가 없을때 HttpStatus.NO_CONTENT // 204 No Content
	}
	
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) { // body에서 처리하므로 @RequestBody 명시
		service.insert(phone);
		return new ResponseEntity(HttpStatus.OK); // 상태코드만 전달 가능
	}
	
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) {
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		return new ResponseEntity(HttpStatus.OK);
	}
}
