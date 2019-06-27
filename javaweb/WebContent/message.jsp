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
	<link href="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/css/bootstrap-select.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script> 
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>  
	<script src="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/bootstrap-select.min.js"></script>
	<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script> 
<link rel="stylesheet" type="text/css" href="uploadify.css">
	<script src="jquery.uploadify.min.js" type="text/javascript"></script>
	
	


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
        <li class="active"><a href="baoming.jsp">当前考次</a></li>
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
	
	<form class="form-horizontal" action="MessageServlet" method="post">
  <div class="form-group">
    <label  class="col-sm-4 control-label">姓名</label>
    <div class="col-sm-4">
      <input type="text"  class="form-control" name="realname"  required="true" placeholder="请输入真实姓名">
    </div>
  </div>
  <br>
  
  <div class="form-group">
    <label  class="col-sm-4 control-label">性别</label>
    <div class="col-sm-4">
<div class="radio">
  <label>
    <input type="radio" name="sex"  value="男" checked>
   男
  </label>
  <label>
    <input type="radio" name="sex"  value="女">
   女
  </label>
</div>
 </div>
  </div>
  <br>
  
   <div class="form-group">
    <label  class="col-sm-4 control-label">出生日期</label>
    <div class="col-sm-4">
          <div class="input-group date" id='date1'> 
                <input type="text" class="form-control" name="birthday"/>  
                <span class="input-group-addon">  
                    <i class="glyphicon glyphicon-calendar"></i>  
                </span>  
            </div>  
</div>
  </div>
  <br>

 <div class="form-group">
    <label  class="col-sm-4 control-label">民族</label>
    <div class="col-sm-4">
<select class="selectpicker" name="minzu">
    <option value="汉族">汉族</option>
          <option value="壮族">壮族</option>
          <option value="满族">满族</option>
          <option value="回族">回族</option>
          <option value="苗族">苗族</option>
          <option value="维吾尔族">维吾尔族</option>
          <option value="土家族">土家族</option>
          <option value="彝族">彝族</option>
          <option value="蒙古族">蒙古族</option>
          <option value="藏族">藏族</option>
          <option value="布依族">布依族</option>
          <option value="侗族">侗族</option>
          <option value="瑶族">瑶族</option>
          <option value="朝鲜族">朝鲜族</option>
          <option value="白族">白族</option>
          <option value="哈尼族">哈尼族</option>
          <option value="哈萨克族">哈萨克族</option>
          <option value="黎族">黎族</option>
          <option value="傣族">傣族</option>
          <option value="畲族">畲族</option>
          <option value="傈僳族">傈僳族</option>
          <option value="仡佬族">仡佬族</option>
          <option value="东乡族">东乡族</option>
          <option value="高山族">高山族</option>
          <option value="拉祜族">拉祜族</option>
          <option value="水族">水族</option>
          <option value="佤族">佤族</option>
          <option value="纳西族">纳西族</option>
          <option value="羌族">羌族</option>
          <option value="土族">土族</option>
          <option value="仫佬族">仫佬族</option>
          <option value="锡伯族">锡伯族</option>
          <option value="柯尔克孜族">柯尔克孜族</option>
          <option value="达斡尔族">达斡尔族</option>
          <option value="景颇族">景颇族</option>
          <option value="毛南族">毛南族</option>
          <option value="撒拉族">撒拉族</option>
          <option value="布朗族">布朗族</option>
          <option value="塔吉克族">塔吉克族</option>
          <option value="阿昌族">阿昌族</option>
          <option value="普米族">普米族</option>
          <option value="鄂温克族">鄂温克族</option>
          <option value="怒族">怒族</option>
          <option value="京族">京族</option>
          <option value="基诺族">基诺族</option>
          <option value="德昂族">德昂族</option>
          <option value="保安族">保安族</option>
          <option value="俄罗斯族">俄罗斯族</option>
          <option value="裕固族">裕固族</option>
          <option value="乌孜别克族">乌孜别克族</option>
          <option value="门巴族">门巴族</option>
          <option value="鄂伦春族">鄂伦春族</option>
          <option value="独龙族">独龙族</option>
          <option value="塔塔尔族">塔塔尔族</option>
          <option value="赫哲族">赫哲族</option>
          <option value="珞巴族">珞巴族</option>                            
</select>
</div>
  </div>
  <br>
  
  
   <div class="form-group">
    <label  class="col-sm-4 control-label">学历</label>
    <div class="col-sm-4">
<select class="selectpicker" name="xueli">
          <option value="博士">博士</option>
          <option value="硕士">硕士</option>
          <option value="本科">本科</option>
          <option value="大专（专科)">大专（专科）</option>
          <option value="高中（职高)">高中（职高）</option>
          <option value="中专（中技）">中专（中技）</option>
          <option value="初中">初中</option>
          <option value="初中以下">初中以下</option>
                                  
</select>
</div>
  </div>
  <br>
  
  	
  <div class="form-group">
    <label  class="col-sm-4 control-label">身份证</label>
    <div class="col-sm-4">
      <input type="text"  class="form-control" name="identity"  required="true" placeholder="请输入身份证号码">
    </div>
  </div>
  <br>
 
  <div class="form-group">
    <label  class="col-sm-4 control-label">手机</label>
    <div class="col-sm-4">
      <input type="text"  class="form-control" name="phone"  required="true" placeholder="请输入手机号码">
    </div>
  </div>
  <br>
  	
  <div class="form-group">
    <label  class="col-sm-4 control-label">学校</label>
    <div class="col-sm-4">
      <input type="text"  class="form-control" name="school"  required="true" placeholder="请输入学校名称">
    </div>
  </div>
  <br>
  
  
  <div class="form-group">
    <label  class="col-sm-4 control-label">文件上传</label>
    <div class="col-sm-4">
 <input type="file" id="uploadify" name="uploadify">    
      
   <a class="btn btn-primary btn-xs" href="javascript:$('#uploadify').uploadify('upload','*')">开始上传</a>    
   <a class="btn btn-primary btn-xs" href="javascript:$('#uploadify').uploadify('cancel')">取消所有上传</a>  
   <a class="btn btn-primary btn-xs" href="/ListFileServlet">预览</a> 
   <div id="fileQueue"></div>   
</div>
</div>
<br><br><br>


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

<script type="text/javascript">
	 $(function(){  
        $("#uploadify").uploadify({      
            'debug'     : false, //开启调试  
            'auto'           : false, //是否自动上传     
            'swf'            : 'uploadify_flash/uploadify.swf',  //引入uploadify.swf    
            'uploader'       : 'upload',//请求路径    
            'queueID'        : 'fileQueue',//队列id,用来展示上传进度的    
            'width'     : '75',  //按钮宽度    
            'height'    : '24',  //按钮高度  
            'queueSizeLimit' : 5,  //同时上传文件的个数    
            'fileTypeDesc'   : '文件',    //可选择文件类型说明  
            'fileTypeExts'   : '*.jpg;*.gif;*.doc;*.xlsx', //控制可上传文件的扩展名    
            'multi'          : true,  //允许多文件上传    
            'buttonText'     : '选择',//按钮上的文字    
            'fileSizeLimit' : '2MB', //设置单个文件大小限制     
            'fileObjName' : 'uploadify',  //<input type="file"/>的name    
            'method' : 'post',    
            'removeCompleted' : true,//上传完成后自动删除队列    
            'onFallback':function(){      
                alert("无法上传！");      
            },   
            'onUploadSuccess' : function(file, data, response){//单个文件上传成功触发    
                                   //data就是action中返回来的数据    
            },'onQueueComplete' : function(){//所有文件上传完成    
                alert("文件上传成功!");  
                }    
            });  
    });  
    </script>  
<script>

$('#date1').datetimepicker({  

    format: 'YYYY-MM-DD ',  
    locale: moment.locale('zh-cn')  
});
 </script>   

</html>