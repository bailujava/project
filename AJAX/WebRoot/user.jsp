<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquery-1.9.1.js"></script>
	<script type="text/javascript">
	$(function(){
	$("#name").blur(function(){
	
	$.ajax({
	  type:"POST",
	  url:"${pageContext.request.contextPath}/user/cha",
	  dataType:"json",  
	  data:{ name:$("#name").val()},
	  success:function(ss){
	$.getJSON(); 
/* 	var users=$.parseJSON(ss); */
	  $("#name2").html(ss[1].name);
	   $("#password2").html(ss[0].password);
	  }
	  
	  });
	});
	
	});
	</script>
  </head>
  
  <body>
  <h2 style="color: blue ">欢迎光临!</h2>
   <form action="success.jsp" method="post" id="form">
   名字:<input id="name" maxlength="6"><span id="name2"></span><br>
   密码:<input id="password" maxlength="6" type="password"><span id="password2"></span><br><br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登陆"  >
   </form>
  </body>
</html>
