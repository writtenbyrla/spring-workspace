package com.kh.mvc.model.vo;

import lombok.Getter;

@Getter
public class Paging {

	private int startPage; // 버튼의 첫번지
	private int endPage; // 버튼의 마지막
	private boolean prev; // 이전페이지 버튼
	private boolean next; // 다음페이지 버튼
	private int num = 10; // 한 페이지에 보여질 버튼 개수
	
	private int total; // 전체글 개수
	private Criteria cri; // 현재 페이지
	
	public Paging(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		// cri.getPage() : 현재페이지 / this.num(한 페이지에 보여질 페이지 버튼 개수) => 반올림
		this.endPage = (int) Math.ceil((double) cri.getPage() / this.num) * this.num;
		this.startPage = this.endPage - this.num + 1;
		int lastPage = (int) Math.ceil((double)total / cri.getAmount());
		
		if(lastPage < this.endPage) {
			this.endPage = lastPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < lastPage;
		
		/*
			현재 페이지 15
			한 페이지에 보여질 버튼 개수 10
			=> endPage: 0.2*10 = 20
			=> startPage = 20 - 10 + 1 = 11
			===============================================
			lastPage = 전체글 수(550) / 페이지당 게시글 수(20)
				= 27.5 => 28
			================================================
			startPage 11 ~ endPage 20 // lastPage 28
			
			prev: 시작페이지가 1이 아닐 경우만 이전페이지 버튼 생성
			next: 마지막 페이지가 last페이지보다 전일 경우에만 다음페이지 버튼 생성
		*/
		
		
	}
	
	
}
