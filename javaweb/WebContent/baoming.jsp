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
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.2/css/bootstrap3/bootstrap-switch.min.css" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.2/js/bootstrap-switch.min.js"></script>

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
        <li ><a href="success.jsp">首页 </a></li>
        <li class="active"><a href="#">当前考次</a></li>
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
	<div class="panel panel-primary">
  <div class="panel-heading">
    <h1 class="panel-title"><font size="6" face="arial" >报名协议</font></h1>
  </div>
  <div class="panel-body" >
  <br><br>
   <font size="4" face="arial">
<p>1. 本报名网站的所有权归教育部考试中心，考生必须完全同意所有服务条款，方可进行网上报名。 </p><br>
<p>2. 考生本人已阅读并同意遵守全国计算机等级考试的报名流程及考生须知。 </p><br>
<p>3. 考生本人保证报名时提交的个人信息资料真实、正确，并将对个人信息不真实或不正确而导致无法参加考试以及其他直接或间接的后果负责。</p> <br>
<p>4. 考生本人注册成功后，将使用自设定的密码和系统指定的用户名作为登录本网站的依据。考生本人将妥善保管自设定的密码和系统指定的用户名，并保证不向他人透露。否则，考生本人将对由此产生的所有后果负责。</p><br> 
<p>5. 考生本人理解并同意，在报名过程中出现不可抗力所引起的无法正常报名的情况，本网站不承担任何直接或间接的责任。 </p><br>
<p>6. 考生本人理解并同意，网上支付系统由支付平台所有并运营，在付费过程中由于支付平台系统问题导致的任何异常情况，本网站不承担直接或间接责任。</p> <br>
<p>7. 考生本人理解并同意，在报名成功后，因本网站系统出现问题影响考生本人参加考试，本网站可能提供的补偿仅限于帮助安排重新报名或全额退还报名费，不承担任何其他连带责任。 </p><br>
<p>8. 考生本人理解并同意，在同次考试中，考生只能报考同一科目一次，报考多次者将取消本次考试所有科目的成绩。</p> <br>
<p>9. 考生本人理解并同意，在缴费完成后，考生不能修改个人信息及报考信息或退考。 </p><br>
<p>10. 考生本人理解并同意，在报名成功后，由于考生个人原因而无法参加考试，由考生个人承担相关责任，教育部考试中心不进行退费。 </p><br>
<p>11. 报名程序如有临时性变化，以本网站公告为准。</p> <br>
<p>12. 本报名网站所收集的考生个人信息数据仅用于全国计算机等级考试报名，考生同意教育部考试中心按考务流程获知、处理、存储本人信息数据。</p> <br>
<p>13. 考生本人已阅读并且理解全国计算机等级考试的有关规定和纪律要求，愿意在考试中自觉遵守这些规定，保证按规定的程序和要求参加考试，如有违反，自愿按《国家教育考试违规处理办法》有关条款接受处理。</p> <br>
<p>14. 因本协议而引发的任何争议，由教育部考试中心住所地有管辖权的法院管辖。 </p><br>
<p><font color="red">重要提示：请使用本人真实有效的邮箱注册ETEST账号并进行报名和支付，否则将无法正常完成报名和支付。</font>
</p>
</font>
<br><br><br><br><br><br>

<input type="checkbox" unchecked class="checkbox" value="${chlProductList.id}"/>



      <a href='javascript:return false;' style='opacity: 0.2' id=home>
    <button id="buttonSelect" class="layui-btn layui-btn-lg " >报名</button>
    </a>
   
    
      
      
     
</div>
</div>
</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div class="jumbotron text-center" style="margin-bottom:0">
  <p>底部内容</p>
</div>
</body>
<script type="text/javascript">

/* bootstrap开关控件，初始化 */
$(function(){  
        /* 初始化控件 */  
        $(".checkbox").bootstrapSwitch({  
            onText : "同意",      // 设置ON文本  
            offText : "不同意",    // 设置OFF文本  
            onColor : "success",// 设置ON文本颜色     (info/success/warning/danger/primary)  
            offColor : "danger",  // 设置OFF文本颜色        (info/success/warning/danger/primary)  
            size : "normal",    // 设置控件大小,从小到大  (mini/small/normal/large)  
            handleWidth:"50",//设置控件宽度
            // 当开关状态改变时触发  
            onSwitchChange : function(event, state) {  
            var ProductId = event.target.defaultValue;
                if (state == true) {
                //上线
            /*     updateProductStatus(ProductId,'AOB'); */
       $('#home').attr('href','/message.jsp');
       $('#home').attr('style','');
                    /* alert("ON"); */
                } else {
                //下线
               /*  updateProductStatus(ProductId,'AOC'); */
                    /* alert("OFF"); */
          $('#home').attr('href','javascript:return false;');
          $('#home').attr('style','opacity: 0.2');
                }  
            }  
        });  
    });

</script>

</html>


