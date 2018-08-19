<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
		<s:iterator value="all" begin="0" end="6" var="p">
			<div class="bg_old" onmouseover="this.className='bg_white';"
				onmouseout="this.className='bg_old';">
				<h3>
					[<a href="${pageContext.request.contextPath}/show/book?pid=${p.id}">${p.name}</a>]
				</h3>
				<ul class="ul_left_list">

						<!--2级分类开始-->
						<s:iterator value="#p.sorts" var="c">
						<li>
							<a href="${pageContext.request.contextPath}/show/book?id=${c.id}&pid=${p.id}">${c.name}</a>
						</li>

						<!--2级分类结束-->
						</s:iterator>
				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			<!--1级分类结束-->
			</s:iterator>
		
	</div>
</div>
