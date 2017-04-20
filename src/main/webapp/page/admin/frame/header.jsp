<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<HTML>
<HEAD>
<title>管理中心V1.0</title>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath}/resource/admin/css/admin.css"
	type="text/css" rel="stylesheet">
</HEAD>
<BODY>
	<TABLE cellSpacing=0 cellPadding=0 width="100%"
		background="${pageContext.request.contextPath}/resource/admin/images/header_bg.jpg"
		border=0>
		<TR height=56>
			<TD width=260><IMG height=56
				src="${pageContext.request.contextPath}/resource/admin/images/header_left.jpg"
				width=260></TD>
			<TD style="FONT-WEIGHT: bold; COLOR: #fff; PADDING-TOP: 20px"
				align=middle>当前用户：${sessionLoginUser.loginName } &nbsp;&nbsp;&nbsp; 
				<A style="COLOR: #fff"
				onclick="if (confirm('确定要注销当前用户并回到网站前台吗？')) return true; else return false;"
				href="${pageContext.request.contextPath}/indexAction!showIndexPage" target=_top>注销并回到网站前台</A>
			</TD>
			<TD align=right width=268><IMG height=56
				src="${pageContext.request.contextPath}/resource/admin/images/header_right.jpg"
				width=268></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
		<TR bgColor=#1c5db6 height=4>
			<TD></TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
