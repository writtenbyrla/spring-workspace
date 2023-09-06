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
import com.kh.api.model.UserInfo;
import com.kh.api.service.PhoneService;

@RestController
public class PhoneController {
	
	@Autowired
	//public PhoneServiceImpl service;
	public PhoneService service; // interface 자체로 주입 가능
	
	@GetMapping("/phone")
	public ResponseEntity select() {
		// Phone 전체 리스트
		try {
		List<Phone> list = service.select();
		return new ResponseEntity(list, HttpStatus.OK); // 데이터와 함께 상태코드도 보낼 수 있음 // 200 OK
		} catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num) {
		try {
			Phone phone = new Phone();
			phone.setNum(num);
			phone = service.select(phone);
			return new ResponseEntity(phone, HttpStatus.OK); // content가 없을때 HttpStatus.NO_CONTENT // 204 No Content
		} catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) { // body에서 처리하므로 @RequestBody 명시
		
		try {
			int result = service.insert(phone);
			return new ResponseEntity(result, HttpStatus.OK); 
		} catch (RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) {
		try {
			service.update(phone);
			return new ResponseEntity( HttpStatus.OK); // 상태코드만 전달 가능
		} catch (RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		try {
			service.delete(num);
			return new ResponseEntity(HttpStatus.OK);
		} catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
//	@GetMapping("phone/")
//	public ResponseEntity select(@PathVariable UserInfo user) {
//		service.select(user);
//		return new ResponseEntity(HttpStatus.OK);
//	}
}
