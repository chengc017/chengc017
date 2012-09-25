<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Insert title here</title>

<script type="text/javascript">
			function onSubmitForm(url){				
				if(url != ''){				
					document.form.action = url;
					var passport=document.getElementById("passport");
					if(passport==null||passport.lenght<4){
						alert("请输入passport!");
					}
					document.form.submit();					
				}
				else{
					alert('无法执行操作');
				}
			}
		</script>

<%@include file="../inc/head.inc"%>
</head>
<body>
	<div class="txt">
		<span class="f14"> 操作提示：处理 <span class="red"> <strong>通行证信息</strong>
		</span> 信息。 </span> <span
			style="float: right; padding-right: 5px; text-align: right; font-size: 12px; *margin-top: -25px;">
			<a href="javascript:window.location.reload()">刷新</a>&nbsp;|&nbsp; <a
			href="javascript:history.go(-1)">后退</a>&nbsp;|&nbsp; <a
			href="javascript:history.go(1)">前进</a>&nbsp; </span>
	</div>
	
	<div class="Area cut1">
		<div class="addtit">
  			<div class="t1">					
				<strong>通行证管理</strong>
			</div>
  			<div class=clear></div>
		</div>
		<font color="red"></font>
			<form  id="form" name="form" method="post" >
			<table cellspacing="1" cellpadding="5" width="100%" align="center" border="0" class="bg">
				
				
				
				<tr class="bg1">
					<td class="textr" width="90">
						passport:				</td>	
					<td class="textl">
						<input type="text" name="passport" id="passport" value="<c:out value='${accountPassport.passport}'/>">				</td>
				</tr>
				
				<tr class="bg1">
					<td class="textr" width="90">
						备注：					</td>	
					<td class="textl"><input type="text" name="memo" value="<c:out value='${accountPassport.memo}'/>">		</td>
		
			
			</table>
	  		 <input type="hidden" name="id" value="<c:out value='${accountPassport.id}'/>"/>
	  		 <input type="hidden" name="c_date" value="<c:out value='${accountPassport.c_date}'/>"/>
			
			<br />
		
			<table cellspacing="0" cellpadding="0" width="100%" align="center" border="0" class="bg">
				<tr class="bg1">
					<td align="center">	
						&nbsp;			
						 <c:if test="${accountPassport==null}">
							<a href="#" onClick="onSubmitForm('passport!savePassport.action?type=1');"> 
							保存</a>
						</c:if><c:if test="${accountPassport!=null}">
						<a href="#" onClick="onSubmitForm('passport!savePassport.action?type=2');"> 
							更新</a>
						</c:if>
							<a href="javascript:history.go(-1)">返回</a>
						
					</td>
				</tr>
				
			</table>
			</form>
			
	
			
		</div>
		
		
</body>
</html>