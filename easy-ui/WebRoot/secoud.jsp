<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
pageContext.setAttribute("path", request.getContextPath()); 

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link  type="text/css" rel="stylesheet" href="${path }/themes/default/easyui.css">
	<link  type="text/css" rel="stylesheet" href="${path }/themes/icon.css">
	<script type="text/javascript" src="${path }/jquery.min.js"></script>
	<script type="text/javascript" src="${path }/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	$(function(){
	$('#vv').validatebox('readonly');
	});
	$(function(){ 
    $('#pb').passwordbox(showPassword);
    $('#pb').passwordbox({ 
        prompt: 'Password', 
        showEye: true,
        passwordChar : '%u25CF',
        
    }); 
});
	</script>
  </head>
  
  <body>
   <div id="cc" class="easyui-calendar" style="width:180px;height:180px;"></div> 
   <div id="mm" class="easyui-menu" style="width:120px;">   
    <div>New</div>   
    <div>   
        <span>Open</span>   
        <div style="width:150px;">   
            <div><b>Word</b></div>   
            <div>Excel</div>   
            <div>PowerPoint</div>   
        </div>   
    </div>   
    <div data-options="iconCls:'icon-save'">Save</div>   
    <div class="menu-sep"></div>   
    <div>Exit</div>   
</div>   
<input id="vv" class="easyui-validatebox" data-options="required:true,validType:'email'" />  
<input class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> 

<input id="pb" type="text" style="width:300px"> 
  </body>
</html>
