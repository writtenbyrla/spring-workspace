package com.kh.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.api.dao.PhoneDAO;
import com.kh.api.model.Phone;
import com.kh.api.model.UserInfo;

@Service
public class PhoneServiceImpl implements PhoneService{

	@Autowired 
//	public PhoneDAOImpl dao;
	public PhoneDAO dao;
	
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
		return dao.select(user);
	}

	@Override
	public int update(Phone phone) {
		return dao.update(phone);
	}

	@Override
	public int delete(String num) {
		return dao.delete(num);
	}

}
