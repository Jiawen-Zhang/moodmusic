package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Ajax")
public class Ajax extends HttpServlet {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	/**
		 * Constructor of the object.
		 */
	public Ajax() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
         response.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		PrintWriter out=response.getWriter();
		//获取数据库的数据
		String sql="select * from users where name ='"+name+"' ";
		System.out.println(sql);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT","root","291049");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery(sql);
			if(rs.next()){
				out.print(1);
			}else{
				out.print(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}
 
}

