package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.entity.User1;
import com.util.C3p0Pool;
import com.util.DBconn;



public class RegDaoJdbc implements RegDAO {
	@Override
	public User1 reg(User1 user) {
		String sql = "insert into users(id,name,pwd,email,active,acode) values(?,?,?,?,?,?)";
		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		String acode = UUID.randomUUID().toString().replaceAll("-", "");
		try {
			run.update(sql, id, user.getName(), user.getPwd(), user.getEmail(),
					"0", acode);
			user.setId(id);
			user.setAcode(acode);
			user.setActive("0");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	


	@Override
	public int active(String acode) {

		QueryRunner run = new QueryRunner(C3p0Pool.getDataSource());

		String sql = "select count(1) from users where acode=? and active='0'";
		
		try {
			int count =Integer.parseInt(""+run.query(sql, new ScalarHandler(), acode));
			if (count == 0) {
				sql = "select count(1) from users where acode=? and active='1'";
				count = Integer.parseInt(""+run.query(sql, new ScalarHandler(), acode));
				if(count==1){
					return 1;//�Ѿ�ע�����
				}else{
					return 0;//û�ж�Ӧ��acode
				}
			} else {
				sql = "update users set active ='1' where acode=?";
				run.update(sql, acode);
				return 2;//�ɹ�ע��
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;//���쳣
		}
	}
}