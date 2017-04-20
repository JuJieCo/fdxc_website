<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<title>管理中心V1.0</title>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resource/admin/css/admin.css" type="text/css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resource/admin/js/js.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.7.2.js"></script>



<script type="text/javascript">

	function selectPage(currentPage){
		var form = document.forms.form1;
		form.action = form.action+"?page.currentPage="+currentPage;
		//alert(form.action);
		form.submit();
	}
	
</script>

</HEAD>
<BODY>
	<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
		<TR height=28>
			<TD background="${pageContext.request.contextPath}/resource/admin/images/title_bg1.jpg">&nbsp;西咸新区沣东新城计卫文体局网站后台管理系统</TD>
		</TR>
		<TR>
			<TD bgColor=#b1ceef height=1></TD>
		</TR>
		<TR height=20>
			<TD background="${pageContext.request.contextPath}/resource/admin/images/shadow_bg.jpg"></TD>
		</TR>
	</TABLE>
	
		
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
    	<td height="30" background="${pageContext.request.contextPath}/resource/admin/images/tab_05.gif">
    		<%@include file="/page/admin/frame/table_top.jsp" %>
    	</td>
	</tr>
	<tr>
    	<td>
 <table width="100%" border="0" cellspacing="0" cellpadding="0">
 	<tr height="30">
 		<td width="8"  background="${pageContext.request.contextPath}/resource/admin/images/tab_15.gif">&nbsp;</td>
	  	<td >
			<form action="${pageContext.request.contextPath}/sysUserAction!queryUserList" name="form1"  method="post" >
 			<s:token name="s_token"></s:token>
	<table width="100%"  bgcolor="#EFF6FE">
	<tr>
		<td class="STYLE4" ></td>
		<td class="STYLE4" >条件查询
			登录名：<input type="text" name="sysUser.loginName" value="${sysUser.loginName }">
			<input type="hidden" name="sysUser.userID" value="${sysUser.userID }">
			<input type="submit" value="查询" name="button">
		</td>
		<td class="STYLE4" ></td>
		<td  class="STYLE4">
			<input type="button" value="新增" name="button" onclick="location.href='${pageContext.request.contextPath}/sysUserAction!findUserForModify'">
		</td>
	</tr> 
</table>
	 	</form>
		</td>
		<td width="8" background="${pageContext.request.contextPath}/resource/admin/images/tab_15.gif">&nbsp;</td>
	</tr>
	<tr>
		<td width="8" background="${pageContext.request.contextPath}/resource/admin/images/tab_15.gif">&nbsp;</td>
        <td>
        
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
	<tr>
		<td  height="22" align="center" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" bgcolor="#FFFFFF" width="15%"><span class="STYLE1">登陆名</span></td>
		<td  height="22" align="center" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" bgcolor="#FFFFFF" width="15%"><span class="STYLE1">密码</span></td>
		<td  height="22" align="center" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" bgcolor="#FFFFFF" width="15%"><span class="STYLE1">姓名</span></td>
		<td  height="22" align="center" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" bgcolor="#FFFFFF" width="15%"><span class="STYLE1">用户类型</span></td>
		<td  height="22" align="center" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" bgcolor="#FFFFFF" width="10%"><span class="STYLE1">操作</span></td>                     
	</tr>
	<!-- 迭代   	-->
	<s:iterator value="sysUserList" var="list">
	<tr>
		<td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.loginName}</span></td>
		<td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.password}</span></td>
		<td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.userName}</span></td>
		<td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.userType  eq 0 ? "管理员":"普通用户" }</span></td>
		<td height="20" bgcolor="#FFFFFF" align="center">
 			<span class="STYLE1"> 
			<c:if test="${list.hold eq 0}">
			<a href="${pageContext.request.contextPath}/sysUserAction!findUserForModify?userID=${list.userID}">修改</a>
			<a href="${pageContext.request.contextPath}/sysUserAction!findUserForShow?userID=${list.userID}">查看</a>
			<a href="${pageContext.request.contextPath}/sysUserAction!deleteUserByID?userID=${list.userID}" onclick="return(confirm('确认要设置为失效用户吗?'))" >设为失效</a>
			</c:if>
			
			<c:if test="${list.hold eq 1}">
			<font color="red">失效用户</font>
			<a href="${pageContext.request.contextPath}/sysUserAction!showUserByID?userID=${list.userID}" onclick="return(confirm('确认要设置为有效用户吗?'))" >设为有效</a>
			</c:if>
			</span>
		</td>
	</tr> 
	</s:iterator>
	<!--迭代 end -->
</table>
		</td>
        <td  width="8" background="${pageContext.request.contextPath}/resource/admin/images/tab_15.gif">&nbsp;</td>
	</tr>
</table>
		</td>
	</tr>
 	<tr>
    	<td height="35" background="${pageContext.request.contextPath}/resource/admin/images/tab_19.gif">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td width="12" height="35">
        	<img src="${pageContext.request.contextPath}/resource/admin/images/tab_18.gif" width="12" height="35" />
        </td>
        <td>
        	 <%@include file="/page/admin/frame/page.jsp" %>
        </td>
        <td width="16">
        	<img src="${pageContext.request.contextPath}/resource/admin/images/tab_20.gif" width="16" height="35" />
        </td>
 	</tr>
</table>
		</td>
	</tr>
</table>

</BODY>
</HTML>