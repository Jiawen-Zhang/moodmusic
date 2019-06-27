 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Bootstrap 实例 - 一个简单的网页</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
 #body1{
 margin:100px;
 }
   
  </style>

</head>
<body>


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">报名系统</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li ><a href="managersuccess.jsp">首页 </a></li>
       <li><a href="SearchAllServlet">查询信息</a></li>
      </ul>
     
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=request.getSession().getAttribute("username") %> <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="manager.jsp">退出</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
	
	
	<br><br><br><br><br><br>
	
	 
 <div class="container">
	<table class="table table-striped">
 

<colgroup>
    <col width="500">
    <col width="500">
  </colgroup>
  <c:forEach var="U" items="${userall}" >
   <tr class="success">
         <td colspan='2' align='middle'>  <B><h2>基本信息</h2> </B> </td>
    </tr>
    <tr class="active">
      <td><h4>姓名</h4></td>
      <td><h4>${U.realname}</h4></td>
    </tr> 
 
  <tbody>
    <tr class="active">
      <td><h4>性别</h4></td>
      <td><h4>${U.sex}</h4></td>
    </tr>
    <tr class="active">
      <td><h4>出生日期</h4></td>
      <td><h4>${U.birthday}</h4></td>
    </tr>
    <tr class="active">
      <td><h4>民族</h4></td>
      <td><h4>${U.minzu}</h4></td>
    </tr>
    <tr class="active">
      <td><h4>文化程度</h4></td>
      <td><h4>${U.xueli}</h4></td>
    </tr>
    <tr class="active">
      <td><h4>身份证</h4></td>
      <td><h4>${U.identity}</h4></td>
    </tr>
    <tr class="active">
      <td><h4>手机</h4></td>
      <td><h4>${U.phone}</h4></td>
    </tr>
    <tr class="active">
      <td><h4>学校名称</h4></td>
      <td><h4>${U.school}</h4></td>
    </tr>
   
  </tbody>
  </c:forEach>
</table>


<div class=" text-center">
      <a class="btn btn-primary " href="/ListFileServlet" >文件预览</a>
	
	
	
	<form class="form-horizontal" action="PassServlet" method="post">
	<div class="form-group">
    <label  class="col-sm-4 control-label"></label>
    <div class="col-sm-4">
<div class="radio">
  <label>
    <input type="radio" name="pass"  value="1" checked>
   通过
  </label>
  <label>
    <input type="radio" name="pass"  value="2">
  不通过
  </label>
</div>
 </div>
  </div>
  
  
<div class="form-group">
 <label  class="col-sm-5 control-label"></label>
<div class="col-sm-5">
 <button type="submit" class="btn btn-default">Submit</button>
 </div>
 </div>
</form>
  
</div>

</div>



	
	
<div class="jumbotron text-center" style="margin-bottom:0">
  <p>底部内容</p>
</div>
</body>


</html>