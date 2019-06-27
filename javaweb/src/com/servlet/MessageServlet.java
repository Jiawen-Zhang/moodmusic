package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String realname = request.getParameter("realname"); //获取jsp页面传过来的参数
		String sex = request.getParameter("sex");
		 String birthday=request.getParameter("birthday");
		String minzu = request.getParameter("minzu"); //获取jsp页面传过来的参数
		String xueli = request.getParameter("xueli");
		 String identity=request.getParameter("identity");
		String phone = request.getParameter("phone"); //获取jsp页面传过来的参数
		String school = request.getParameter("school");
	

		UserDao ud = new UserDaoImpl();
		HttpSession session = request.getSession(); 
		String name = (String)session.getAttribute("username"); 
		 if(ud.update(name,realname,sex,birthday,minzu,xueli,identity,phone,school))
		 {
			 response.sendRedirect("ok.jsp");
		 }
		 else
			 response.sendRedirect("message.jsp");
	}

}
