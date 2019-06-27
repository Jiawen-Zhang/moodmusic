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
    .fakeimg {
        height: 200px;
         background: #aaa;
    }
  </style>
</head>
<body>
<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>报名网站</h1>
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
   
  </div>
</nav>


	<form class="bs-example bs-example-form"  action="ManagerDengluServlet"  method="post" role="form">
	<div style=" width: 650px;position: relative; left:40%;">
		<div class="input-group">
				<div class="input-group input-group-lg">
				<label class="layui-form-label">用户名</label>
			<input type="text" name="name" class="form-control" autocomplete="off" required="true" placeholder="请输入用户名">
		
		
		<br><br><br><br><br>
		        <label class="layui-form-label">密码</label>
			<input  class="form-control" name="pwd" autocomplete="off" type="password" required="true" placeholder="请输入密码">
		
		<br>
		</div>
		</div>
	</div>
	<br><br><br><br><br>
	
	<div style=" width: 650px;position: relative; left:48%;">
	   <input type="submit"  class="btn btn-lg btn-primary" value="提交">
	   
	   </div>
</form>
     <br><br><br><br><br>

<div class="jumbotron text-center" style="margin-bottom:0">
  <p>底部内容</p>
</div>
</body>
</html>