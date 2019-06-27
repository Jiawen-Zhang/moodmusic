package com.entity;

public class User {
    private String id;
    private String name;
    private String pwd;
    private String sex;
    private String pass;
    private String email;
    private String ispass;
    private String realname;
    private String birthday;
    private String minzu;
    private String xueli;
    private String identity;
    private String phone;
    private String school;

public void setId(String id) {
		
		this.id=id;
	}
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMinzu() {
		return minzu;
	}
	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}
	public String getXueli() {
		return xueli;
	}
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setIspass(int ispass)
	{if(ispass==0)
		this.ispass="未通过";
	else
		this.ispass="已通过";
		
	}
	public String getIspass()
	{
		return ispass;
	}
    
	public void setpass(String pass)
	{
		this.pass=pass;
		
	}
	public String getpass()
	{
		return pass;
	}
	
    
}
