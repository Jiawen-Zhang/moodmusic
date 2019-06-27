package com.service;

import com.dao.RegDAO;
import com.dao.RegDaoJdbc;
import com.entity.User1;

public class RegServiceImpl implements IRegService{
	//“¿¿µ◊¢»Î
	private RegDAO dao = new RegDaoJdbc();
	@Override
	public User1 reg(User1 user) {
		return dao.reg(user);
	}
	@Override
	public int active(String acode) {
		return dao.active(acode);
	}
}