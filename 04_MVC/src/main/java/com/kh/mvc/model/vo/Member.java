package com.kh.mvc.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // toString, 꽉 찬 생성자
public class Member {

	private String id;
	private String pwd;
	private String name;
	private String addr;
	
}
