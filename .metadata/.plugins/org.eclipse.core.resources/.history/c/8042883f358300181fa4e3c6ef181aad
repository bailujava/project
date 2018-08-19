<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">
<s:iterator value="hotBooks" var="book">
	<!--热销图书A开始-->
	<div class="second_d_wai">
		<div class="img">
			<a href="product.action?id=${book.id }" target='_blank'><img class="dang_img"
					src="../productImages/${book.productPic }" border=0 /></a>
		</div>
		<div class="shuming">
			<a href="#" target="_blank">${book.productName }</a>
		</div>
		<div class="price">
			定价：￥${book.fixedPrice}
		</div>
		<div class="price">
			当当价：￥${book.dangPrice }
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
</s:iterator>
</div>
<div class="clear"></div>