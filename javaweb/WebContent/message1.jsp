 <%@ page language="java" pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <!DOCTYPE HTML>
 <html>
  <head>
    <title>消息提示</title>
   </head>
   
  <body>
        ${message}
  </body>
 </html>