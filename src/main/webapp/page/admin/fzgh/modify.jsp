<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<HTML>
<HEAD>
<title>管理中心V1.0</title>
<meta http-equiv=Content-Type content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath }/resource/admin/css/admin.css" >
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath }/resource/uploadify/uploadify.css"  />
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/admin/js/js.js" ></script>

<script type="text/javascript">	
  	function validateForm(){
  		var fzghTitle = document.getElementById('fzghTitle').value;
  		var loginName =  document.getElementById('loginName').value;

  		if(fzghTitle==""){
  			alert('标题是必填项');
  			return false;
  		}
  		if(loginName==""){
  			alert('发布人是必填项');
  			return false;
  		}
  		
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
	
		
	
<form action="${pageContext.request.contextPath}/fzghAction!modifyFzgh" id="form1" name="form1" method="post"  enctype="multipart/form-data" onsubmit="return validateForm();" >
<s:token name="s_token"></s:token>
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td height="30" background="${pageContext.request.contextPath}/resource/admin/images/tab_05.gif">
    	<%@include file="/page/admin/frame/table_top.jsp" %>
    </td>
  </tr>
  <tr>
    <td>
    
    <input name="fzgh.fzghID" type="hidden" value="${fzgh.fzghID }">    
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
        <td width="8" background="${pageContext.request.contextPath}/resource/admin/images/tab_15.gif">&nbsp;</td>
        <td>
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" width="10%">标题：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="40%" > &nbsp;&nbsp;<input type="text" name="fzgh.fzghTitle" value="${fzgh.fzghTitle }" size="50" id="fzghTitle"></td>
        	<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" width="10%">对应部门：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="40%" >&nbsp;&nbsp;
           		<select name="fzgh.deptType" >
            		<option value="0"  ${fzgh.deptType eq 0 ? "selected":"" }>计卫文体局</option>
            		<option value="1"  ${fzgh.deptType eq 1 ? "selected":"" }>人口计生</option>
            		<option value="2"  ${fzgh.deptType eq 2 ? "selected":"" }>医疗卫生</option>
            		<option value="3"  ${fzgh.deptType eq 3 ? "selected":"" }>文体旅游</option>
            		<option value="4"  ${fzgh.deptType eq 4 ? "selected":"" }>食品药品</option>
            	</select>																																	
            </td>
          </tr>
          <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" width="10%">发布时间：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="40%" >&nbsp;&nbsp;<input type="text" name="fzgh.subDate"  value="<fmt:formatDate value="${fzgh.subDate }" pattern="yyyy-M-d"/>" readonly="readonly" ></td>
           	 <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" width="10%">发布人：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="40%" >&nbsp;&nbsp;<input type="text" name="fzgh.sysUser.loginName" value="${fzgh.sysUser.loginName}"   readonly="readonly"  id="loginName">
            																																						   <input type="hidden" name="fzgh.sysUser.userID" value="${fzgh.sysUser.userID }">
            </td>     	
           	
          </tr>
          <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" width="10%">发布内容：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="40%"  colspan="3">&nbsp;&nbsp;
            	    <textarea id="id_1" name="fzgh.fzghContent">${fzgh.fzghContent }</textarea> 
					<ckeditor:replace replace="id_1" basePath="${pageContext.request.contextPath}/resource/ckeditor/" />
            </td>     	
          </tr>
          
      
        </table>
		</td>
        <td  width="8" background="${pageContext.request.contextPath}/resource/admin/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table> 
    </td>
 </tr>
  <tr>
    <td>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="${pageContext.request.contextPath}/resource/admin/images/tab_18.gif" width="12" height="35" /></td>
        <td>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4"></td>
            <td height="35" background="${pageContext.request.contextPath}/resource/admin/images/tab_19.gif">
              <table border="0" align="center" cellpadding="0" cellspacing="0" id="form_oper">
                <tr>
                <td>					
                	<input  type="submit" value="提交" />				
					<input  type="button" value="返回" onclick="history.go(-1)"/>	
				</td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="${pageContext.request.contextPath}/resource/admin/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table>
    
    
    </td>
  </tr>
</table>
</form>
</BODY>
</HTML>