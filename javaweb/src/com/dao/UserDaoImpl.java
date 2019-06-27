package com.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import com.entity.User;
import com.util.DBconn;
 
public class UserDaoImpl implements UserDao{
	
	public boolean register(User user) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("insert into users(name,pwd,sex,home,info,email) " +
				"values('"+user.getName()+"','"+user.getPwd()+"','"+user.getSex()+"','"+user.getemail()+"')");
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	
	public boolean check(String name) {
		boolean flag = false;
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from users where name='"+name+"'");
				while(rs.next()){
					if(rs.getString("name").equals(name) ){
						flag = true;
					}
				}
				DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
    public boolean login(String name, String pwd) {
		boolean flag = false;
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from users where name='"+name+"' and pwd='"+pwd+"'");
				while(rs.next()){
					if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){
						flag = true;
					}
				}
				DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
    
    
    public void setPass(String name) {
    
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from users where name='"+name+"'");
				while(rs.next()){
					if(rs.getString("name").equals(name) ){
						
						String sql ="update user set pass ='已报名' where name = '"+name+"'";
						int i=DBconn.addUpdDel(sql);
						if(i!=0)
							System.out.println("报名成功");
					}
				}
				DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
    public boolean getPass(String name) {
    	boolean flag = false;
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from users where name='"+name+"'");
				while(rs.next()){
					if(rs.getString("name").equals(name) && rs.getString("pass").equals("已报名")){
						flag = true;
					}
				}
				DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
    }
    
    public List<User> getUser(String name) {
    	List<User> list = new ArrayList<User>();
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from users where name='"+name+"'");
				while(rs.next()){
					if(rs.getString("name").equals(name) ){
						User user = new User();
						user.setSex(rs.getString("sex"));
						user.setRealname(rs.getString("realname"));
						user.setBirthday(rs.getString("birthday"));
						user.setMinzu(rs.getString("minzu"));
						user.setXueli(rs.getString("xueli"));
						user.setIdentity(rs.getString("identity"));
						user.setPhone(rs.getString("phone"));
						user.setSchool(rs.getString("school"));
						user.setpass(rs.getString("pass"));
						list.add(user);					}
				}
				DBconn.closeConn();
				return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<User> getUserAll() {
		List<User> list = new ArrayList<User>();
    	try {
		    DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from users where pass='0'");
			if(rs.next()){
				User user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setRealname(rs.getString("realname"));
				user.setBirthday(rs.getString("birthday"));
				user.setMinzu(rs.getString("minzu"));
				user.setXueli(rs.getString("xueli"));
				user.setIdentity(rs.getString("identity"));
				user.setPhone(rs.getString("phone"));
				user.setSchool(rs.getString("school"));
				list.add(user);	
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean update(String name,String realname, String sex,String birthday, String minzu ,String xueli,String identity ,String phone,String school) {
		boolean flag = false;
		DBconn.init();
		String sql ="update users set realname ='"+realname
				+"' , birthday ='"+birthday
				+"' , sex ='"+sex
				+"' , minzu ='"+minzu
				+"' , identity ='"+identity
				+"' , phone ='"+phone
				+"' , school ='"+school
				+"' , xueli ='"+xueli+"' where name = '"+name+"'";
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	public boolean update1(String name) {
		boolean flag = false;
		DBconn.init();
		String sql ="update users set pass ='1'  where name = '"+name+"'";
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	
	public boolean update2(String name) {
		boolean flag = false;
		DBconn.init();
		String sql ="update users set pass ='2'  where name = '"+name+"'";
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	
	public boolean delete(int id) {
		boolean flag = false;
		DBconn.init();
		String sql = "delete  from users where id="+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
    
}