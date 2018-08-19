<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
request.setAttribute("path",request.getContextPath());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<link  type="text/css" rel="stylesheet" href="${path }/themes/default/easyui.css">
	<link  type="text/css" rel="stylesheet" href="${path }/themes/icon.css">
	<script type="text/javascript" src="${path }/jquery.min.js"></script>
	<script type="text/javascript" src="${path }/jquery.easyui.min.js"></script>


	<script type="text/javascript">
	$(function(){
		$('#p').progressbar({ 
			value: 60 
			});
		$('#btn1').linkbutton({
			width: '100%',
			height: 32,
			value: 60 	 
			});
		$('btn2').click(function(){
			
			$('#btn2').linkbutton('disable');
			$('#btn').linkbutton('enable');



		})
	});
	</script>

  </head>
  
  <body>
 <div id="p" class="easyui-progressbar" data-options="value:60" style="width:400px;"></div>
<a id="btn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">easyui</a> 
<a id="btn2" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">easyui</a> 
<a href="javascript:void(0)" id="mb" class="easyui-menubutton"     
        data-options="menu:'#mm',iconCls:'icon-edit'">Edit</a>   
<div id="mm" style="width:150px;">   
    <div data-options="iconCls:'icon-undo'">Undo</div>   
    <div data-options="iconCls:'icon-redo'">Redo</div>   
    <div class="menu-sep"></div>   
    <div>Cut</div>   
    <div>Copy</div>   
    <div>Paste</div>   
    <div class="menu-sep"></div>   
    <div data-options="iconCls:'icon-remove'">Delete</div>   
    <div>Select All</div>   
</div>  
  </body>
</html>
