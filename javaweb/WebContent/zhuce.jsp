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
    </div>
</nav>
	
	
	<br><br><br><br><br><br>
	
<form  action="ZhuceServlet" class="form-horizontal" method="post" name="managerForm" onsubmit="return insertManager()">
    
     <br />  <br />  <br />
     <br />  <br />  <br />
     
     	       
   <div class="form-group">
    <label  class="col-sm-4 control-label">姓名</label>
   <div class="col-sm-4">
      <input type="text"  class="form-control" name="name" id="name" autocomplete="off" required="true" onblur="ajaxsub(this)" placeholder="请输入用户名"><label id="msg_info"></label>
    </div>
  </div>
  					
  <div class="form-group">
    <label  class="col-sm-4 control-label">密码</label>
    <div class="col-sm-4">
      <input type="password"  class="form-control" name="pwd" id="pwd1" autocomplete="off" required="true" placeholder="请输入密码">密码合法长度为6-18个字符
    </div>
  </div>		
  		
  		
 <div class="form-group">
    <label  class="col-sm-4 control-label">重新输入</label>
    <div class="col-sm-4">
      <input type="password"  class="form-control" name="npwd"  onkeyup="validate()" id="pwd2" autocomplete="off" required="true" placeholder="请输入密码"><span id="tishi"></span></input>
    </div>
  </div>			

  <div class="form-group">
    <label  class="col-sm-4 control-label">邮箱</label>
    <div class="col-sm-4">
      <input type="text"  class="form-control" name="email"  onkeyup="validate()" id="pwd2" autocomplete="off" required="true" placeholder="请输入邮箱"><span id="tishi"></span></input>
    </div>
  </div>
      
	
	 				
	 				
    					
    			
                        
                         
                        
 <div class="form-group">
 <label  class="col-sm-5 control-label"></label>
<div class="col-sm-5">
 <button type="submit" class="btn btn-default">Submit</button>
 </div>
 </div>
 
 
    </form>



	
	
<div class="jumbotron text-center" style="margin-bottom:0">
  <p>底部内容</p>
</div>
</body>

 <script>
          function validate() {
              var pwd1 = document.getElementById("pwd1").value;
              var pwd2 = document.getElementById("pwd2").value;
              if(pwd1 == pwd2) {
                  document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
                  document.getElementById("submit").disabled = false;
              }
              else {
                  document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
                document.getElementById("submit").disabled = true;
              }
          }
      </script> 



<script>
/* function SendForm() 
    {
         if(insertManager()) 
        {
        	 document.managerForm.submit();
        }
        }
 */
function insertManager() {
    var name =document.managerForm.name.value;
         var pwd = document.managerForm.pwd.value;
         var npwd = document.managerForm.npwd.value;
   if(name=="") {
         alert("用户名不能为空");
         managerForm.name.focus();
       return false;
   }
            
 
   else if(name.length<6 || name.length>18 ){
       alert("用户名合法长度为6-18个字符");
       managerForm.name.focus();
       return false;
   } 
   else if(! /^\w+$/.test( name ) ){
       alert("用户名只能包含_,英文字母，数字");
       managerForm.name.focus();
       return false;
   }
  
   else if(name.indexOf(' ') != -1){
       alert("用户名中不能有空格");
       managerForm.name.focus();
       return false;
   }
    else if(pwd==""){
         alert("请输入密码");
         managerForm.pwd.focus();
         return false;
   }      
   else if(pwd.length<6 || pwd.length>18){
          alert("密码合法长度为6-18个字符");
          managerForm.pwd.focus();
          return false;
   }      
    
   else if(npwd==""){
       window.alert("请输入确认密码");
       managerForm.npwd.focus();
       return false;
       }
   else if(pwd!=npwd){
      window.alert("您输入的新密码与确认密码确认不一致");
      managerForm.npwd.focus();
      return false;  
   }
return true;
    
}
 </script>

<script type="text/javascript">
var xmlhttp;
//创建XMLHttpRequest对象
function createXMLHttpRequest() {
	try {
		//针对IE5、IE5.5、IE6
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			//针对IE5、IE5.5、IE6
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e) {
			try {
				//针对FireFox、Mozillar、Opera、Safari、IE7、IE8
				xmhttp = new XMLHttpRequest();//创建XMLHttpRequest对象
 
				if (xmlhttp.overrideMimeType) {//修正某些浏览器的BUG
					xmlhttp.overrideMimeType("text/xml");
				}
			} catch (e) {
			}
		}
	}
}
 
function ajaxsub(t) {
 
	//创建一个XmlHttpRequest对象(js内置对象)
	createXMLHttpRequest();
 
	if (xmlhttp != null) {
	//判断XMLHttpRequest是否创建成功
		var url = "http://localhost/Ajax";
		//1.是http请求的方式  POST和GET
		//2.是服务器的地址,可以一个servlet
		//3.是采用同步还是异步，true为异步
		xmlhttp.open("POST", url, true);
 
		//post请求要自己设置请求头  注意顺序
		xmlhttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;");
		xmlhttp.onreadystatechange = callfun; 
		//注册回调函数  callfun对应一个js的函数名字,这个函数由我们自己定义
 
		//发送请求         一会在servlet中获取的username值就是这里的
		xmlhttp.send("name="+t.value);
	} else {
		alert("不能创建XMLHttpRequest对象实例")
	}
 
}
 
//回调函数
function callfun() {//获取服务器返回的数据
	//回调函数里面会执行多次,次数取决建立连接的时间和建立连接成功之后服务器处理的时间
 
	//获取与服务器建立连接是否成功
	if (xmlhttp.readyState == 4) {
		if (xmlhttp.status == 200) {//服务器已经成功处理请求，并返回数据
			var serviceData = xmlhttp.responseText;//获取服务器返回的文本数据
			//alert("服务器返回的数据是:" + serviceData);
 
			var vs = "";
			if (serviceData == "1") {
				vs = "用户名已注册";
			} else {
				vs = "用户名未注册";
			}
			document.getElementById("msg_info").innerHTML = vs;
		}
 
	}
 
}
</script>



 

</html>