package com.kh.mvc.model.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    
	private int num;
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	
	// 파일 첨부 시 servlet-context.xml에서 	MultipartFile 빈 등록 해줘야함
	// update.jsp에서 파일 업로드할 경우 Board 객체에 같이 담아서 넘겨야 함(컨트롤러에서 다루기 위해)
	private MultipartFile uploadFile; 
	
	// 이미지 파일 경로(데이터베이스에 추가하기 위해)
	private String url; 

}
