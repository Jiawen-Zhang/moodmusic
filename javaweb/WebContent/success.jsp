<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>Bootstrap 实例 - 一个简单的网页</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
 
   
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
        <li class="active"><a href="#">首页 </a></li>
        <li><a href="baoming.jsp">当前考次</a></li>
         <li><a href="IsPass">报名状态</a></li>
      </ul>
     
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=request.getSession().getAttribute("username") %> <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/SearchServlet">修改基本资料</a></li>
            <li><a href="denglu.jsp">退出</a></li>
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
   <tr class="success">
         <td colspan='2' align='middle'>  <B><h2>基本信息</h2> </B> </td>
    </tr>
    <tr class="active">
      <td><h4>考次</h4></td>
      <td><h4>2019年3月全国计算机等级考试</h4></td>
    </tr> 
 
  <tbody>
    <tr class="active">
      <td><h4>主管机构</h4></td>
      <td><h4>福建</h4></td>
    </tr>
    <tr class="active">
      <td><h4>用户角色</h4></td>
      <td><h4>考生</h4></td>
    </tr>
  </tbody>
</table>
</div>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div class="jumbotron text-center" style="margin-bottom:0">
  <p>底部内容</p>
</div>
</body>
</html>