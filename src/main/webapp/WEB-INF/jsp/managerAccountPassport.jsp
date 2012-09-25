<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@include file="../inc/head.inc"%>
</head>
<body>
<div class="Area cut1">
	<form method="get" action="passport!search.action">
		<table cellspacing="1" cellpadding="5" width="100%" align="center"
			border="0" class="bg">
			<tr class="bg1">
				<td class="textl">&nbsp; <b> 搜狐通行证：</b> 
				<input type="text"
					name="passport" maxlength="220" size="10" /> &nbsp; </td>
					<b> </b>
					<td class="textl">&nbsp; <b>
					<input type="submit" value="确定"></b></td>
			</tr>
		</table>
		
	</form>


	<div class="txt">
		<span class="f14"> 操作提示：查看                                                                                                                     <a href="passport!editPassport.action?type=1" >添加</a>
		</span>

	</div>

	<br>

	<table class="bg" width="100%" cellspacing="1" cellpadding="5"
		border="0" align="center">
		<tr  class="bg1">
			<th>ID</th>
			<th>通行证</th>
			<th>备注</th>
			<th>创建时间</th>
			<th>修改</th>
			
			

		</tr>

		<tr class="bg2">
			<td style="width: 100px; word-wrap: break-word; word-break: break-all;" align="center">
			<c:out value="${accountPassport.id}">
				</c:out>
			</td>
			<td
				style="width: 100px; word-wrap: break-word; word-break: break-all;" align="center">
				<c:out value="${accountPassport.passport} " />
			</td>
			<td
				style="width: 100px; word-wrap: break-word; word-break: break-all;" align="center">
				<c:out value="${accountPassport.memo }" />
			</td>

			<td
				style="width: 100px; word-wrap: break-word; word-break: break-all;" align="center">
				<c:out value="${accountPassport.c_date }" />
			</td>
			<td style="width: 100px; word-wrap: break-word; word-break: break-all;" align="center"><a
				href="passport!editPassport.action?type=2&passport=<c:out value='${accountPassport.passport}'/>">[处理]</a>
			
		
			<a
				href="passport!delPassport.action?id=<c:out value='${accountPassport.id}'/>">[删除]</a>
			</td>

		</tr>




	</table>
	</div>
</body>
</html>