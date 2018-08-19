
<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>生成订单 - 当当网</title>
<link href="../css/login.css" rel="stylesheet" type="text/css" />
<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
<script type="text/javaScript"
	src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javaScript">
		
			$(function(){

				$("#address").change(function(){
				//本次的jquery对象才能调用.val()方法
				var  addrid = $("#address").val();
				location.href = "${pageContext.request.contextPath}/order/address2?id="+addrid
				});
				
				$("receiveName").blur(function(){
				if($(this).val().length<=5){$(this).next().first().html("格式正确");}else{$(".name").html("格式错误");}
				$("fullAddress").blur(function(){
				for ( var int = 0; int < $(this).val().length; int++) {
				if($(this).val().charCodeAt(int)<19967){
				$(".address").html("不能输入非汉子"); 
				}
				}

				});	
				
				});

			})

		</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		生成订单骤: 1.确认订单 > <span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
	</div>
	<div class="fill_message">
		<p>
			选择地址： <select id="address">
				<option>请输入地址信息</option>
				<s:iterator value="address">
					<option value="${id}">
						<s:property value="receive_name" />
					</option>
				</s:iterator>
			</select>
		</p>
		<form name="ctl00" method="get" action="order_ok.jsp" id="f">
			<input type="hidden" name="id" id="addressId" />

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1">收件人姓名：</td>
					<td><input type="text" class="text_input" name="receiveName "
						id="receiveName" value="${DA.receive_name}" maxlength="12" />
						<div class="text_left" id="nameValidMsg">
							<p class="name">请填写有效的收件人姓名</p>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">收件人详细地址：</td>
					<td><input type="text" name="fullAddress" class="text_input"
						id="fullAddress" value="${DA.full_address}" />
						<div class="text_left" id="addressValidMsg">
							<p class="address">请填写有效的收件人的详细地址</p>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">邮政编码</td>
					<td><input type="text" class="text_input" name="postalCode"
						id="postalCode" value="${DA.post_code}" />
						<div class="text_left" id="codeValidMsg">
							<p class="postal">请填写有效的收件人的邮政编码</p>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">电话</td>
					<td><input type="text" class="text_input" name="phone"
						id="phone" value="${DA.mobile}" />
						<div class="text_left" id="phoneValidMsg">
							<p class="number">请填写有效的收件人的电话</p>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">手机</td>
					<td><input type="text" class="text_input" name="mobile"
						id="mobile" value="${DA.phone}" />
						<div class="text_left" id="mobileValidMsg">
							<p class="phone">请填写有效的收件人的手机</p>
						</div></td>
				</tr>
			</table>

			<div class="login_in">

				<a href="order_info.jsp"><input id="btnClientRegister"
					class="button_1" name="submit" type="submit" value="取消" />
				</a> <input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" onclick="" />
			</div>
		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

