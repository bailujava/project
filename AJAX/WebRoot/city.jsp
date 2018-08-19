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
	$.ajax({
	type:"POST",
	url:"${pageContext.request.contextPath}/city",
	data:{city:"beijing"},
	dataType:"json",
	success:function(result){
	for(var i=0;i<result.length;i++){
	$("#area").append("<option>"+result[i]+"</option>")
	}}
	});
/* 	onload(){} */
	$("#select").change(function(){
	$("#area").empty();
	$.ajax({
	type:"POST",
	url:"${pageContext.request.contextPath}/cites",
	data:{city:$("#select option:selected").val()},
	dataType:"json",
	success:function(result){
	for(var i=0;i<result.length;i++){
	$("#area").append("<option>"+result[i]+"</option>")
	}}
	});
	})
	
	})
	
	</script>
  </head>
  
  <body>
  <h2 style="color: blue ">欢迎光临!</h2>
	<select id="select"><option value="beijing">北京</option> <option value="tianjin">天津</option>
	<option value="shanghai">上海</option></select>
	<select id="area"><option>请选择</option> </select>
	</body>
</html>
