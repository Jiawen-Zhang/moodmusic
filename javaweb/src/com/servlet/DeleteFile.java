package com.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteFile
 */
@WebServlet("/DeleteFile")
public class DeleteFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFile() {
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 request.setCharacterEncoding("UTF-8");
    	 response.setCharacterEncoding("UTF-8");
         String fileName = request.getParameter("filename");  
        /* fileName = new String(fileName.getBytes("utf-8"),"UTF-8");*/
         System.out.println(fileName);
      
    
         HttpSession session = request.getSession(); 
 		String name = (String)session.getAttribute("username"); 
         String fileSaveRootPath=this.getServletContext().getRealPath("/uploads"+"/"+name);
       
         String path = findFileSavePathByFileName(fileSaveRootPath);
         
         System.out.println(path);
         System.out.println(fileName);
         File file = new File(path + "/" + fileName);
      
         if(file.exists()){
           file.delete();
             request.getRequestDispatcher("/ListFileServlet").forward(request, response);
            
         }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	  public String findFileSavePathByFileName(String saveRootPath){
	        
	         String dir = saveRootPath ;  //upload\2\3  upload\3\5
	         File file = new File(dir);
	         if(!file.exists()){
	            
	             file.mkdirs();
	         }
	         return dir;
	     }
	    

}
