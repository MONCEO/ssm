<!-- 模仿天猫整站ssm 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>


<!-- <script>
$(function(){
	$("ul.pagination li.disabled a").click(function(){
		return false;
	});
});

</script> -->
<script>
	$(function() {
		$("ul.pager li.disabled a").click(function() {
			return false;
		});
	});
</script>
<div>


	<nav>
		<ul class="pager">
			<li>总记录数：${page.total}&nbsp</li>
			<li>总页数：${page.pageCount}&nbsp</li>
			<li>当前页：${page.sp}&nbsp</li>
			<li><a
				href="${pageContext.request.contextPath}/${page.url}/1">首页</a></li>
			<li><a
				href="${pageContext.request.contextPath}/${page.url}/${page.sp-1}">上一页</a></li>			
			<li><a
				href="${pageContext.request.contextPath}/${page.url}/${page.sp+1}">下一页</a></li>
			<li><a
				href="${pageContext.request.contextPath}/${page.url}/${page.pageCount}">末页</a></li>
		</ul>
</div>

</nav>


