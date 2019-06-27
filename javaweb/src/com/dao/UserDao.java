package com.dao;


import java.util.List;
 
import com.entity.User;
 
public interface UserDao {
	public boolean login(String name,String pwd);//登录
	public boolean register(User user);//注册
	public boolean check(String name);
	public List<User> getUserAll();//返回用户信息集合
	public boolean delete(int id) ;//根据id删除用户
	public boolean update(String name,String realname, String sex,String birthday, String minzu ,String xueli,String identity ,String phone,String school);//更新用户信息
	 public List<User> getUser(String name);//得到个人信息
	 public boolean getPass(String name);//判断是否报名
	 public void setPass(String name);//修改报名状态
	public boolean update1(String name);
	public boolean update2(String name);

}
