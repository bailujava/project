<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
		<link   rel="stylesheet" href="${pageContext.request.contextPath }/themes/icon.css">
		<link   rel="stylesheet" href="${pageContext.request.contextPath }/themes/default/easyui.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jquery.easyui.min.js"></script>		
		<script type="text/javascript">
		$(function(){
			//页面加载完自动发送ajax异步请求
			$.ajax({
				url:'${pageContext.request.contextPath }/employee/showAll.do',
				type:'POST',
				success:function(data){
					for(var i=0;i<data.length;i++){
						var td1 = $('<td>'+data[i].id+'</td>');
						var td2 = $('<td>'+data[i].name+'</td>');
						var td3 = $('<td>'+data[i].salary+'</td>');
						var td4 = $('<td>'+data[i].age+'</td>');
						var td5 = $('<td>'+data[i].department_name+'</td>');
						var td6 = $('<td><a  href="${pageContext.request.contextPath }/employee/deleteEmp.do?id=+data[i].id+">删除</a><a  href="${pageContext.request.contextPath }/updateEmp.jsp?pid=+data[i].id+">修改</a></td>');
						var tr  = $('<td></td>');
						tr.append(td1).append(td2).append(td3).append(td4).append(td5).append(td6);
						$('#tb').append(tr);  
					}
				}
			});
		})
		</script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<a href="${pageContext.request.contextPath }/login.jsp">离开</a>
						</p>
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
					<thead>
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td>
								deptName
							</td>
							<td>
								Operation
							</td>
						</tr>
						</thead>
					 <tbody id="tb">
					</tbody>	
						
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='${pageContext.request.contextPath}/addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
