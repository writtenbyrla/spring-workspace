package com.kh.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.api.dao.PhoneDAOImpl;
import com.kh.api.model.Phone;
import com.kh.api.model.UserInfo;

@Service
public class PhoneServiceImpl implements PhoneService{

	@Autowired 
	public PhoneDAOImpl dao;
	
	@Override
	public int insert(Phone phone) {
		return dao.insert(phone);
	}

	@Override
	public Phone select(Phone phone) {
		return dao.select(phone);
	}

	@Override
	public List<Phone> select() {
		return dao.select();
	}

	@Override
	public UserInfo select(UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Phone phone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String num) {
		// TODO Auto-generated method stub
		return 0;
	}

}
