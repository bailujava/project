<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
      <s:iterator value="ranBook" begin="0" end="1" >
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='#' target='_blank'><img src="${pageContext.request.contextPath}/productImages/<s:property value="img_url"></s:property>" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='#' target='_blank' title='输赢'><s:property value="name"></s:property></a>
				</h3>
				<h4>
					作者：
					<br />
					出版社：<s:property value="publish_company"></s:property>&nbsp;&nbsp;&nbsp;&nbsp;出版时间：<s:property value="publish_time"></s:property>
				</h4>
				<h5>
					简介 <s:property value="recommend"></s:property>
				</h5>
				<h6>
					定价：￥<s:property value="price"></s:property>&nbsp;&nbsp;当当价：￥<s:property value="dd_price"></s:property>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
 		</s:iterator>
<%-- 		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='#' target='_blank'><img src="/productImages/<s:property value="ranBook[1].img_url"></s:property>" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='#' target='_blank' title='输赢'><s:property value="ranBook[1].name"></s:property></a>
				</h3>
				<h4>
					作者：
					<br />
					出版社：<s:property value="ranBook[1].publish_company"></s:property>&nbsp;&nbsp;&nbsp;&nbsp;出版时间：<s:property value="ranBook[1].publish_time"></s:property>
				</h4>
				<h5>
					简介 <s:property value="ranBook[1].recommend"></s:property>
				</h5>
				<h6>
					定价：￥<s:property value="ranBook[1].price"></s:property>&nbsp;&nbsp;当当价：￥<s:property value="ranBook[1].dd_price"></s:property>
				</h6>
			</div>
		</div> --%>
		
	</div>
</div>
