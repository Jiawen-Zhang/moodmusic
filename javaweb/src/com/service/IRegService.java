package com.service;

import com.entity.User1;

public interface IRegService {
    public User1 reg(User1 user);
    public int active(String acode);
}