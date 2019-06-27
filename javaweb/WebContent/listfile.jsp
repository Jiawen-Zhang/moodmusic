<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE HTML>
 <html>
  <head>
    <title>下载文件显示页面</title>
  </head>
   
  <body>
       <!-- 遍历Map集合 -->
     <c:forEach var="me" items="${fileNameMap}">
        <c:url value="/DownLoadServlet" var="downurl">
             <c:param name="filename" value="${me.key}"></c:param>
         </c:url>
       <%--  ${me.value}<a href="${downurl}">下载</a> --%>
       ${me.value} <a href="##" onclick="preview('${downurl}')" >预览</a>
     <a href="##" onclick="delete1('${me.value}')" >删除</a>
       
        <br/>
     </c:forEach>
   </body>
   
   <script type="text/javascript">
 
   function preview(path){
    var ext=path.split('.')[1];
   
        window.open(path);
   

   
   }
   
   function delete1(path1){
	   var m=path1;
	   n = window.encodeURI(m);
	   window.location.href="/DeleteFile?filename="+n;
   }
   </script>
 </html>