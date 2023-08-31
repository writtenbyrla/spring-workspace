package com.kh.mvc.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// page와 amount 값을 같이 전달하는 용도
public class Criteria {
	
	private int page; // 페이지 번호
	private int amount; // 한 페이지 당 데이터 개수
	
	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}
	
	public Criteria() {
		this(1, 20); // 기본값 지정해서 처리(첫 페이지부터 20개씩 보여준다)
	}
	
}
