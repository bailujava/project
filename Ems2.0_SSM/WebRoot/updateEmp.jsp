<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link   rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
		<link   rel="stylesheet" href="${pageContext.request.contextPath }/themes/icon.css">
		<link   rel="stylesheet" href="${pageContext.request.contextPath }/themes/default/easyui.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jquery.easyui.min.js"></script>
		<script type="text/javascript">
		$(function(){
		$('#form').form({
		url:'${pageContext.request.contextPath }/employee/updateEmp.do',
		onSubmit:function(){return true;},
		success:function(data){location.href="${pageContext.request.contextPath }/emplist.jsp"}
		});
		$("#sub").click(function(){
		$('#form').submit();
		});                  
		$('#na').validatebox({    
    	required: true,    
    	missingMessage:'快写!'   
							});  
		
		});
		</script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								2009/11/20
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
					<form  id="form">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="id" value="${param.pid}" readonly/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input id="na" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="easyui-validatebox" data-options="required:true" name="salary" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									age:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="easyui-validatebox"  data-options="required:true" name="age" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									deptName:
								</td>
								<td>
								<select name="department_name" class="easyui-combobox">
						
											<option selected value="UI">ui</option>

											<option value="IT">it</option>
											<option value="前端">前端</option>
							
								</select>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" id="sub" class="button" value="提交" />
						</p>
					</form>
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
