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
	<style type="text/css">
	#zhanshi{border: double yellow; height: 100px;width:50%;padding: 100px 5px 5px 5px;margin-top: 50px}
	
	</style>
	<script type="text/javascript" src="jquery-1.9.1.js"></script>
	<script type="text/javascript">
	$(function(){
	$("#tijiao").click(function(){
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/user/cha",
			data:{name:$('#ming').val()},
			dataType:"json",
			success:function(result){
			/* alert(result); */
			$("#zhanshi").html(result.name+"<br>"+result.password);
			$("textarea").val(result.password);
			}
		});
	});	
	});
	</script>
  </head>
  
  <body>
 
<input type="text" maxlength="10" id="ming">;<input type="submit" id="tijiao" >
 
 <div align="center"  id="zhanshi"></div>
 <textarea rows="5" cols="15" readonly="readonly"  ></textarea>
  </body>
</html>
