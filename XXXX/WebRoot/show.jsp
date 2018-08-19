<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>展示界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--(
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/jquery-1.9.1.js"></script>
	<script type="text/javascript">
	</script>
  </head>
  
  <body>
  <form action="${pageContext.request.contextPath}/user/delete.do" method="post">
	 <table id="t1">
		<c:forEach var="n" items="${qa}" >
 	   <tr><td><input type="hidden" value="${n.id}" /></td>
	   <td><input type="checkbox" name="list" value="${n.id}"/> </td>
	   <td>${n.account}</td>
        <td>${n.number}</td> 
        <td><input type="button" value="删除"/></td> </tr>

		</c:forEach>
	</table>
	<input type="submit" value="删除选中" id="delete">
	</form>
  </body>
</html>
