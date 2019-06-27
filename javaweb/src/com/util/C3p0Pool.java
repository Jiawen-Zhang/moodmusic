package com.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//���ǵ������װ��ֻ��Ϊ�˰�c3p0��������ÿ���߳�(�ͻ���)��õ���ͬһ�����ӣ�������b/s����µ�����
public class C3p0Pool {

	private static DataSource pool;
	private static ThreadLocal<Connection> t = new ThreadLocal<Connection>();
	static {
		pool = new ComboPooledDataSource();
	}

	public static DataSource getDataSource() {
		return pool;
	}

	public static Connection getConnection() throws SQLException {
		Connection con  = t.get();
		if(con==null){
			con = pool.getConnection();
			t.set(con);
		}
		return con;
	}

}