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
	<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
		<TR height=28>
			<TD background="${pageContext.request.contextPath}/resource/admin/images/title_bg1.jpg">当前位置:</TD>
		</TR>
		<TR>
			<TD bgColor=#b1ceef height=1></TD>
		</TR>
		<TR height=20>
			<TD background="${pageContext.request.contextPath}/resource/admin/images/shadow_bg.jpg"></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
		<TR height=100>
			<TD align=middle width=100><IMG height=100
				src="${pageContext.request.contextPath}/resource/admin/images/admin_p.gif" width=90></TD>
			<TD width=60>&nbsp;</TD>
			<TD>
				<TABLE height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>

					<TR>
						<TD>

<script language=JavaScript> 
today=new Date(); 
function initArray(){ 
this.length=initArray.arguments.length ;
for(var I=0;I<this.length;I++) 
this[I+1]=initArray.arguments[I]; } 
var d=new initArray( 
"星期日", 
"星期一", 
"星期二", 
"星期三", 
"星期四", 
"星期五", 
"星期六"); 
document.write( 
"<font color=##000000 style='font-size:9pt;font-family: 宋体'> ", 
today.getYear(),"年", 
today.getMonth()+1,"月", 
today.getDate(),"日,", 
d[today.getDay()+1], 
"</font>" ); 
</script> 
						</TD>
					</TR>
					<TR>
						<TD style="FONT-WEIGHT: bold; FONT-SIZE: 16px">${sessionLoginUser.loginName }</TD>
					</TR>
					<TR>
						<TD>欢迎进入网站管理中心！</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
		<TR>
			<TD colSpan=3 height=10></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
		<TR height=20>
			<TD></TD>
		</TR>
		<TR height=22>
			<TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff"
				align=middle background="${pageContext.request.contextPath}/resource/admin/images/title_bg2.jpg">您的相关信息</TD>
		</TR>
		<TR bgColor=#ecf4fc height=12>
			<TD></TD>
		</TR>
		<TR height=20>
			<TD></TD>
		</TR>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0>
		<TR>
			<TD align=right width=100>登陆帐号：</TD>
			<TD style="COLOR: #880000">${sessionLoginUser.loginName }</TD>
		</TR>
		<TR>
			<TD align=right>用户真实姓名：</TD>
			<TD style="COLOR: #880000">${sessionLoginUser.userName }</TD>
		</TR>
		<TR>
			<TD align=right>身份过期时限：</TD>
			<TD style="COLOR: #880000">60 分钟</TD>
		</TR>
		<TR>
			<TD align=right>技术支持电话：</TD>
			<TD style="COLOR: #880000">029-82501088</TD>
		</TR>
	</TABLE>
</BODY>
</HTML>