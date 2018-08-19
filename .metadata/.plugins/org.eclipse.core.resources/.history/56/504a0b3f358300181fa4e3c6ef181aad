<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.min.js"></script>
		<script type="text/javascript" src="../js/verify.js"></script>
		<script type="text/javascript" src="../js/loginFormValidate.js"></script>
	</head>
	<body>


		<%@include file="../common/head1.jsp"%>

		<div class="enter_part">

			<%@include file="../common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red"
						id="divErrorMssage">
						<br />
						<s:property value="error"/>
					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>

						<s:form method="post" action="login" id="ctl00" theme="simple" namespace="/authorize">
						<s:token></s:token>
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<s:textfield name="user.email" id="txtUsername" cssClass="textbox" ></s:textfield>
								</li>
								<li>
									<span class="blank">密码：</span>
									<s:password name="user.password" id="txtPassowrd" cssClass="textbox" ></s:password>
								</li>
								<li>
									<s:submit id="btnSignCheck" cssClass="button_enter"  value="登 录"></s:submit>

								</li>
							</ul>
							<!-- 
							<input type="hidden" name="uri" value="${uri}" />
							 -->
						</s:form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="toRegist.action">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
</html>

