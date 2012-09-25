<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>系统 登录</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	font-size: 12px;
	background-color: #eeeeee;
}

.input {
	BORDER: #cccccc 1px solid;
	height: 16px;
	width: 150px;
}

.version {
	color: #000000;
	font-weight: bold;
	font-size: 25px;
}
</style>
<script type="text/javascript">
function checkspace(checkstr) {
  var str = '';
  for(i = 0; i < checkstr.length; i++) {
    str = str + ' ';
  }
  return (str == checkstr);
}

function check()
{
	if(checkspace(document.loginform.userName.value))  {		
		alert("对不起，用户名不能为空，请重新输入！");
		document.loginform.userName.focus();
		return false;
	}
	
	if(checkspace(document.loginform.password.value))  {		
		alert("对不起，密码不能为空，请重新输入！");
		document.loginform.password.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
	<table border="0" align="center" cellpadding="0" cellspacing="0"
		style="margin-top: 10%;">
		<tr>
			<td><img src="images/login/login_r1_c1.jpg" />
			</td>
			<td width="343" style="background: url('images/login/sys_name_bg.jpg');" /><table width="100%"
					border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="35" style="font: 42px  '隶书'">管理系统</td>
					</tr>
				</table>
			</td>
			<td><img src="images/login/login_r1_c3.jpg" />
			</td>
		</tr>
		<tr>
			<td><img src="images/login/login_r2_c1.jpg" />
			</td>
			<td valign="top" style="background: url('images/login/login_r2_c2.jpg');">
				<form id="loginform" name="loginform"
					action="user!login.action" method="post"
					onsubmit="return check();">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						style="margin-top: 5px;">
						<tr>
							<td width="30%" height="30" align="right" class="f12-white">用户名:</td>
							<td width="70%"><input class="input" name="userName"
								id="userName" onfocus="this.select();" />
							</td>
						</tr>
						<tr>
							<td height="30" align="right" class="f12-white">密 码：</td>
							<td><input class="input" type="password" maxlength="16"
								size="15" name="password" onfocus="this.select();" />
							</td>
						</tr>
						<tr>
							<td height="35" colspan="2">&nbsp;<font color="red">${info}</font></font></td>
						</tr>
						<tr>
							<td height="30" colspan="2" align="center"><input
								type="image" src="images/login/login.gif" /> &nbsp; <a
								href="javascript:loginform.reset();"> <img
									src="images/login/reset.gif" border="0" />
							</a>
							</td>
						</tr>
					</table>
				</form></td>
			<td><img src="images/login/login_r2_c3.jpg" />
			</td>
		</tr>
	</table>
</body>
</html>