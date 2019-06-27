package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegDAO;
import com.dao.RegDaoJdbc;
import com.entity.User1;

 


 
public class ZhuceServlet extends HttpServlet {
	

	
	
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String path = request.getContextPath()+"/denglu.jsp";
		
		String name = request.getParameter("name"); //获取jsp页面传过来的参数
		String pwd = request.getParameter("pwd");
		 String email=request.getParameter("email");
		
	

		
	
/*		User user = new User(); //实例化一个对象，组装属性
		user.setName(name);
		user.setPwd(pwd);
		user.setemail(email);
		UserDao ud = new UserDaoImpl();*/
		
		
			User1 user = new User1(); //实例化一个对象，组装属性
			user.setName(name);
			user.setPwd(pwd);
			user.setEmail(email);
			RegDAO ud = new RegDaoJdbc();
	       ud.reg(user);
	
	

			
			
			if(user!=null){
				//发送激活邮件
				//这里有一个小知识点，必须新开一个线程来发邮件，不能把发邮件的动作写在这里
				//如果写在这里，用户的前台显示会等待过长时间，不好！
				new MySendMailThread(user).start();
				out.println("您已经注册成功，请去邮箱激活账号后再进行登录，如果没有收到邮件，请稍等!<br/>");
				out.println("<a href='/javaweb/denglu.jsp'>返回登录页</a><br/>");
				
			}else{
				out.println("很抱歉，服务器繁忙，注册失败，需要重新注册！");
			}
			System.out.close();
			
			/*request.getRequestDispatcher("/denglu.jsp").forward(request, response);  //转发到登录页面
*/		}/*else{
			
			response.sendRedirect("zhuce.jsp");//重定向到首页
		}
	}*/
}
