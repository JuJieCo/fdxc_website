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
  		var zzjgTitle = document.getElementById('zzjgTitle').value;
  		var loginName =  document.getElementById('loginName').value;

  		if(zzjgTitle==""){
  			alert('标题是必填项');
  			return false;
  		}
  		if(loginName==""){
  			alert('发布人是必填项');
  			return false;
  		}
  		
  	}
</script> 


<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/uploadify/uploadify.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/uploadify/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/uploadify/jquery.uploadify-3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/uploadify/jquery.uploadify-3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/uploadify/myuploadify-zzjg.js"></script>

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
	
		
	
<form action="${pageContext.request.contextPath}/zzjgAction!modifyZzjg" id="form1" name="form1" method="post"  enctype="multipart/form-data" onsubmit="return validateForm();" >
<s:token name="s_token"></s:token>
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td height="30" background="${pageContext.request.contextPath}/resource/admin/images/tab_05.gif">
    	<%@include file="/page/admin/frame/table_top.jsp" %>
    </td>
  </tr>
  <tr>
    <td>
    
    <input name="zzjg.zzjgID" type="hidden" value="${zzjg.zzjgID }">    
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
        <td width="8" background="${pageContext.request.contextPath}/resource/admin/images/tab_15.gif">&nbsp;</td>
        <td>
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" width="10%">标题：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="40%" > &nbsp;&nbsp;<input type="text" name="zzjg.zzjgTitle" value="${zzjg.zzjgTitle }" size="50" id="zzjgTitle"></td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" width="10%">对应部门：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="40%" >&nbsp;&nbsp;
           		<select name="zzjg.deptType" >
            		<option value="0"  ${zzjg.deptType eq 0 ? "selected":"" }>计卫文体局</option>
            		<option value="1"  ${zzjg.deptType eq 1 ? "selected":"" }>人口计生</option>
            		<option value="2"  ${zzjg.deptType eq 2 ? "selected":"" }>医疗卫生</option>
            		<option value="3"  ${zzjg.deptType eq 3 ? "selected":"" }>文体旅游</option>
            		<option value="4"  ${zzjg.deptType eq 4 ? "selected":"" }>食品药品</option>
            	</select>																																	
            </td>
          </tr>
          <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" width="10%">发布时间：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="40%" >&nbsp;&nbsp;<input type="text" name="zzjg.subDate"  value="<fmt:formatDate value="${zzjg.subDate }" pattern="yyyy-M-d"/>" readonly="readonly" ></td>
           	 <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" width="10%">发布人：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="40%" >&nbsp;&nbsp;<input type="text" name="zzjg.sysUser.loginName" value="${zzjg.sysUser.loginName}"   readonly="readonly"  id="loginName">
            																																						   <input type="hidden" name="zzjg.sysUser.userID" value="${zzjg.sysUser.userID }">
            </td>     	
           	
          </tr>
          <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" width="10%">发布内容：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="40%"  colspan="3">&nbsp;&nbsp;
            	    <textarea id="id_1" name="zzjg.zzjgContent">${zzjg.zzjgContent }</textarea> 
					<ckeditor:replace replace="id_1" basePath="${pageContext.request.contextPath}/resource/ckeditor/" />
            </td>     	
          </tr>
          
          <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/admin/images/bg.gif" width="10%">上传附件：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="40%"  colspan="3">
           支持格式:jpg/gif/jpeg/png/bmp,文件大小小于2MB
           <div  style="height:1px"></div>
            <div id="fileQueue"></div>
  					<input type="file" name="uploadFile" id="uploadFile"  value="">
          	<div id="result" ></div>
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