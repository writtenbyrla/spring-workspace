package com.kh.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
	private String num;
	private String model;
	private int price;
	private String vcode;
	
	// vcode foreign key로 연결되어 있으므로 company로 연결
	private Company company; 
}
