package com.kh.api.service;

import java.util.List;

import com.kh.api.model.Phone;
import com.kh.api.model.UserInfo;

public interface PhoneService { // impl -> PhoneServiceImpl
	
	int insert(Phone phone);
	int update(Phone phone);
	int delete(String num);
	Phone select(Phone phone);
	List<Phone> select();
	UserInfo select(UserInfo user);
	
}
