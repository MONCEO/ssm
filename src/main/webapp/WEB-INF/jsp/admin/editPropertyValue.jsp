<!-- 模仿天猫整站ssm 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>


<title>编辑产品属性值</title>

<script>
    $(function() {
        $("input.pvValue").keyup(function(){
            var value = $(this).val();
            var page = ${pageContext.request.contextPath}+"/admin_propertyValue_update";
            var pvid = $(this).attr("pvid");
            var parentSpan = $(this).parent("span");
            parentSpan.css("border","1px solid yellow");
            $.post(
                page,
                {"value":value,"id":pvid},
                function(result){
                    if("success"==result)
                        parentSpan.css("border","1px solid green");
                    else
                        parentSpan.css("border","1px solid red");
                }
            );
        });
    });
</script>

<div class="workingArea">
	<ol class="breadcrumb">
		<li><a href="${pageContext.request.contextPath}/admin_category_list/1">所有分类</a></li>
		<li><a href="${pageContext.request.contextPath}/admin_product_list/${product.category.id}/1">${product.category.name}</a></li>
		<li class="active">${product.name}</li>
		<li class="active">编辑产品属性</li>
	</ol>

	<div class="editPVDiv">
		<c:forEach items="${pvs}" var="pv">
			<div class="eachPV">
		<c:forEach items="${pv.listProperty}" var="py">
				<span class="pvName" >${py.name}</span>
		</c:forEach>
				<span class="pvValue"><input class="pvValue" pvid="${pv.id}" type="text" value="${pv.value}"></span>
			</div>
		</c:forEach>

		<div style="clear:both"></div>
	</div>

</div>

