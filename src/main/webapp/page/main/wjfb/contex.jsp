<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>西咸新区沣东新城计卫文体局</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/css.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.7.2.js"></script>
</head>

<body>
<div id="wrap">
<div id="top">
    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="1000" height="119">
    <param name="movie" value="${pageContext.request.contextPath}/resource/images/logo.swf" />
    <param name="quality" value="high" />
    <embed src="${pageContext.request.contextPath}/resource/images/logo.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="1000" height="119"></embed>
    </object>
</div>
	<div id="nav">
		<script>
			$(function(){
				$(".nav>li").hover(function(){
					$(this).children('ul').stop(true,true).show(300);
				},function(){
					$(this).children('ul').stop(true,true).hide(300);
				})
			})
		</script>
		<div class="menu">
			<ul class="nav">
				<li style="background:none;"><a href="${pageContext.request.contextPath}/indexAction!showIndexPage">网站首页</a></li>
				<li><a href="${pageContext.request.contextPath}/indexAction!queryXinwenMenu?type=0">新闻中心</a>
					<ul class="sub-nav">
						<li><a href="${pageContext.request.contextPath}/indexAction!queryXinwenMenu?type=0">要闻简报</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryXinwenMenu?type=1">政务新闻</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryXinwenMenu?type=2">图片新闻</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryXinwenMenu?type=3">处室动态</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryXinwenMenu?type=4">党建工作</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryXinwenMenu?type=5">领导讲话</a></li>
					</ul>
				</li>
				<li><a href="${pageContext.request.contextPath}/indexAction!queryZzjgMenu">机构设置</a>
					<ul class="sub-nav">
						<li><a href="${pageContext.request.contextPath}/indexAction!queryZzjgMenu">组织机构</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryBjznMenu">本局职能</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryHdryMenu">获得荣誉</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryDsjyMenu">大事记要</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryLxfsMenu">联系方式</a></li>
					</ul>
				</li>
				<li><a href="${pageContext.request.contextPath}/indexAction!queryGkfwMenu">政务公开</a>
					<ul class="sub-nav">
						<li><a href="${pageContext.request.contextPath}/indexAction!queryGkfwMenu">公开范围</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryLdcyMenu">领导成员</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryRsxxMenu">人事信息</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryFzghMenu">发展规划</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryNdjhMenu">年度计划</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryWjfbMenu">文件发布</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryTzggMenu">通知公告</a></li>
						
					</ul>
				</li>
				<li><a href="${pageContext.request.contextPath}/indexAction!queryFGMenu?type=0">政策法规</a>
					<ul class="sub-nav">
						<li><a href="${pageContext.request.contextPath}/indexAction!queryFGMenu?type=0">国家法规</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryFGMenu?type=1">省级法规</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryFGMenu?type=2">市级法规</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryFGMenu?type=3">区级法规</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryFGMenu?type=4">重要文献</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryFGMenu?type=5">法规解读</a></li>
					</ul>
				</li>
					<li><a href="${pageContext.request.contextPath}/indexAction!queryRdgzMenu">热点关注</a></li>
					<li><a href="${pageContext.request.contextPath}/indexAction!queryBsznMenu">办事指南</a></li>
					<li><a href="${pageContext.request.contextPath}/indexAction!queryXzzqMenu">下载专区</a></li>
					<li><a href="${pageContext.request.contextPath}/indexAction!queryJbfcMenu">街办风采</a></li>
					<li><a href="${pageContext.request.contextPath}/indexAction!queryFdyxMenu">沣东印象</a></li>
			</ul>
		</div>
	</div>
<div id="banner">
    <embed src="${pageContext.request.contextPath}/resource/images/banner.swf" width="1000" height="231" wmode="transparent"></embed>
</div>
	<div id="index">
		<div id="sub_L">
			<div class="title4">政务公开</div>
			<ul>
					<li><a href="${pageContext.request.contextPath}/indexAction!queryGkfwMenu">公开范围</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryLdcyMenu">领导成员</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryRsxxMenu">人事信息</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryFzghMenu">发展规划</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryNdjhMenu">年度计划</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryWjfbMenu">文件发布</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryTzggMenu">通知公告</a></li>
						
			</ul>	
		</div>
		<div id="sub_R">
			<div class="title5">当前位置 > 政务公开 > 文件发布</div>
			<div class="contant">
				<div class="con_title">
					<h3>${wjfb.wjfbTitle }</h3>
					<p>作者：${wjfb.sysUser.userName }　发布时间：${wjfb.subDate }</p>
				</div>
				<div class="text">
					${wjfb.wjfbContent } 
					<c:if test="${wjfb.wjfbFileUrl ne null }">
					
					<font color="red">附件下载:</font>	<a href="${pageContext.request.contextPath}${wjfb.wjfbFileUrl }">${wjfb.wjfbFileName }</a>
						
					</c:if>
				</div>
				<p class="c"></p>
			</div>
		</div>
	</div>
	<p class="c"></p>
	<div class="footer">
		<%@include file="/page/main/common/footer.jsp" %>
	</div>
</div>
</body>
</html>

