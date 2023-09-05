package com.kh.api.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.api.model.Phone;
import com.kh.api.model.UserInfo;

@Repository
public class PhoneDAOImpl implements PhoneDAO {

	@Autowired
	public SqlSessionTemplate session;
	
	@Override
	public int insert(Phone phone) {
		return session.insert("phone.insert", phone);
	}

	@Override
	public Phone select(Phone phone) {	
		return session.selectOne("phone.select", phone.getNum());
	}

	@Override
	public List<Phone> select() {
		return session.selectList("phone.select");
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
