<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理中心V1.0</title>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath}/resource/admin/css/admin.css"
	type="text/css" rel="stylesheet">
</head>
<body onload=document.form1.name.focus();>
	<table height="100%" cellSpacing=0 cellPadding=0 width="100%"
		bgColor=#002779 border=0>
		<tr>
			<td align="center">
				<table cellSpacing=0 cellPadding=0 width=468 border=0>
					<tr>
						<td><img height=23
							src="${pageContext.request.contextPath}/resource/admin/images/login_1.jpg"
							width=468></td>
					</tr>
					<tr>
						<td><img height=147
							src="${pageContext.request.contextPath}/resource/admin/images/login_2.jpg"
							width=468></td>
					</tr>
				</table>
				<table cellSpacing=0 cellPadding=0 width=468 bgColor=#ffffff
					border=0>
					<tr>
						<td width=16><IMG height=122
							src="${pageContext.request.contextPath}/resource/admin/images/login_3.jpg"
							width=16></td>
						<td align="center">
							<form name="form1" action="${pageContext.request.contextPath}/loginAction!login" method="post">
								<s:token name="s_token"></s:token>
								<table cellSpacing=0 cellPadding=0 width=230 border=0>

									<tr height=5>
										<td width=5></td>
										<td width=56></td>
										<td></td>
									</tr>
									<tr height=36>
										<td></td>
										<td>用户名</td>
										<td><input
											style="BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid"
											maxLength=30 size=24  name="sysUser.loginName" value="${sysUser.loginName }"></td>
									</tr>
									<tr height=36>
										<td>&nbsp;</td>
										<td>口 令</td>
										<td><input
											style="BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid"
											type=password maxLength=30 size=24 name="sysUser.password" value="${sysUser.password }"></TD>
									</TR>
									<tr height=5>
										<td colSpan=3></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<TD><INPUT type=image height=18 width=70
											src="${pageContext.request.contextPath}/resource/admin/images/bt_login.gif">
										</TD>
									</TR>
								</TABLE>
							</form>
						</TD>
						<TD width=16><IMG height=122 src="${pageContext.request.contextPath}/resource/admin/images/login_4.jpg"
							width=16></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=468 border=0>
					<TR>
						<TD><IMG height=16 src="${pageContext.request.contextPath}/resource/admin/images/login_5.jpg" width=468></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=468 border=0>
					<TR>
						<TD align=right><A href="http://www.865171.cn/" target=_blank><IMG
								height=26 src="${pageContext.request.contextPath}/resource/admin/images/login_6.gif" width=165 border=0></A></TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
