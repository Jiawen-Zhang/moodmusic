package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/DownLoadServlet")

 
public class DownLoadServlet extends HttpServlet {
 
    
     public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
         //閿熺煫纰夋嫹瑕侀敓鏂ゆ嫹閿熸埅纰夋嫹閿熶茎纭锋嫹閿熸枻鎷�
    	 request.setCharacterEncoding("UTF-8");
    	 response.setCharacterEncoding("UTF-8");
         String fileName = request.getParameter("filename");  
        /* fileName = new String(fileName.getBytes("utf-8"),"UTF-8");*/
         
			String formatName = fileName.substring(fileName.lastIndexOf("."));
			System.out.println(formatName);
    
         HttpSession session = request.getSession(); 
 		String name = (String)session.getAttribute("username"); 
         String fileSaveRootPath=this.getServletContext().getRealPath("/uploads"+"/"+name);
       
         String path = findFileSavePathByFileName(fileSaveRootPath);
         
         System.out.println(path);
         System.out.println(fileName);
         File file = new File(path + "/" + fileName);
      
         if(!file.exists()){
             request.setAttribute("message", "閿熸枻鎷疯閿熸枻鎷烽敓鎴鎷烽敓鏂ゆ嫹婧愰敓绐栨唻鎷峰垹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�");
             request.getRequestDispatcher("/message.jsp").forward(request, response);
             return;
         }
        
         
         
         
         
         
         
         
         
         
         if(formatName.equals(".jpg"))
         {
         String File=path+"/"+fileName;
         FileInputStream inputStream = new FileInputStream(File);
 		int i = inputStream.available();
 		//byte閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鑺傝揪鎷烽敓閰佃顒婃嫹绾搁敓鏂ゆ嫹閿熸枻鎷烽敓锟�
 		byte[] buff = new byte[i];
 		inputStream.read(buff);
 		//閿熻寰楀叧鎲嬫嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
 		inputStream.close();
 		//閿熸枻鎷烽敓鐭嚖鎷烽敓閰电鎷烽敓閰典紮鎷烽敓鍓跨鎷烽敓鏂ゆ嫹搴旈敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
 		response.setHeader("Content-type", "image/png");
 		OutputStream out = response.getOutputStream();
 		out.write(buff);
 		//閿熸埅鎲嬫嫹閿熸枻鎷峰簲閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
 		out.close();

         System.out.println(File);
        /* request.getRequestDispatcher(File).forward(request, response);*/
     }
         else
         {    String filename = URLEncoder.encode(fileName, "utf-8");
        	 String File="http://ow365.cn/?i=17846&furl=http://47.100.234.108/uploads"+"/"+name+"/"+filename;
        	 
        	 System.out.println(File);
        	 response.sendRedirect (File);
         }
     }
     
    
     public String findFileSavePathByFileName(String saveRootPath){
        
         String dir = saveRootPath ;  //upload\2\3  upload\3\5
         File file = new File(dir);
         if(!file.exists()){
            
             file.mkdirs();
         }
         return dir;
     }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
         doGet(request, response);
     }
 }
