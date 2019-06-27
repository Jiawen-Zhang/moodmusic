package com.dao;

import com.entity.User1;

public interface RegDAO {
	public User1 reg(User1 user);
	public int active(String acode);
}
