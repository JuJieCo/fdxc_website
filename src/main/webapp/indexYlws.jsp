<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>西咸新区沣东新城计卫文体局  医疗卫生</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/css.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.tabso_yeso.js"></script>
<script type="text/javascript">
$(document).ready(function($){
	
	//默认选项卡切换
	$("#normaltab").tabso({
		cntSelect:"#normalcon",
		tabEvent:"mouseover",
		tabStyle:"normal"
	});
	
});
</script>
</head>

<body>
<div id="wrap">
	<div id="top">
		<img src="${pageContext.request.contextPath}/resource/images/top_yiliao.jpg" />
	</div>
	<div id="banner">
		<img src="${pageContext.request.contextPath}/resource/images/banner.jpg" />
	</div>
	<div id="index">
		<div id="index_L">
			<div id="index_L_1">
				<div class="index_L_img_news">
					<div class="title">图片新闻</div>
					<div class="change">
		<script type="text/javascript">
		
		var focus_width=316;
		var focus_height=230;
		var text_height=20;
		var swf_height = focus_height+text_height;
		var pics = "";
		var links = "";
		var texts = "";
		
		
		pics += "${pageContext.request.contextPath}${tpxwimg0 }";
		links += "${pageContext.request.contextPath}/indexYlwsAction!findXinWen2ForShow?xinwenID=${tpxw0ID }";
		texts += "${tpxw0Title}";
		
		pics += "|";
		links += "|";
		texts += "|";
		
		pics += "${pageContext.request.contextPath}${tpxwimg1 }";
		links += "${pageContext.request.contextPath}/indexYlwsAction!findXinWen2ForShow?xinwenID=${tpxw1ID }";
		texts += "${tpxw1Title}";
		
		pics += "|";
		links += "|";
		texts += "|";
		
		pics += "${pageContext.request.contextPath}${tpxwimg2 }";
		links += "${pageContext.request.contextPath}/indexYlwsAction!findXinWen2ForShow?xinwenID=${tpxw2ID }";
		texts += "${tpxw2Title}";

		

		
		
		document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ focus_width +'" height="'+ swf_height +'">');
		document.write('<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="${pageContext.request.contextPath}/resource/images/focus.swf"><param name="quality" value="high"><param name="bgcolor" value="#FFFFFF">');
		document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
		document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'">');
		document.write('<embed src="${pageContext.request.contextPath}/resource/images/focus.swf" wmode="opaque" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'" menu="false" ?bgcolor="#ffffff" quality="high" width="'+ focus_width +'" height="'+ swf_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');  
		document.write('</object>');
		
		</script>
					</div>
				</div>
				<div class="index_L_yaowen">
					<div class="title1"><a href="${pageContext.request.contextPath}/indexYlwsAction!queryXinWen0Menu">
					<img src="${pageContext.request.contextPath}/resource/images/more.jpg" /></a>要闻简报</div>
					<ul class="yaowen_list">
						<s:iterator value="xinwen0" var="xw" >
						<li>
							<span><fmt:formatDate value="${xw.subDate }" pattern="[yyyy-MM-dd]"/></span>
							·<a href="${pageContext.request.contextPath}/indexYlwsAction!findXinWen0ForShow?xinwenID=${xw.xinwenID }">
							${fn:substring(xw.xinwenTitle , 0, 23)}...
							</a>
						</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div id="index_L_2">
				<div class="index_L_ry">
					<div class="title2"><a href="${pageContext.request.contextPath}/indexYlwsAction!queryWjfbMenu">
					<img src="${pageContext.request.contextPath}/resource/images/more.jpg" /></a>文件发布</div>
					<ul class="wenjian">
					<s:iterator value="wjfb0" var="wj" >
						<li>·<a href="${pageContext.request.contextPath}/indexYlwsAction!findWjfbForShow?wjfbID=${wj.wjfbID }">
						${fn:substring(wj.wjfbTitle , 0, 23)}...
						</a></li>
					</s:iterator>
					</ul>
				</div>
				<div class="index_L_zc1">
					<div class="title1"><a href="${pageContext.request.contextPath}/indexYlwsAction!queryZcfgMenu">
					<img src="${pageContext.request.contextPath}/resource/images/more.jpg" /></a>政策法规</div>
					<ul>
						<s:iterator value="zcfg0" var="zc">
							<li>·<a href="${pageContext.request.contextPath}/indexYlwsAction!findZcfgForShow?zcfgID=${zc.zcfgID }">
							${fn:substring(zc.zcfgTitle , 0, 28)}... 
							</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<p class="c"></p>
		</div>
		<div id="index_R">
			<div class="index_R_1">
				<div class="title4"><a href="${pageContext.request.contextPath}/indexYlwsAction!queryTzggMenu">
				<img src="${pageContext.request.contextPath}/resource/images/more2.jpg" /></a>通知公告</div>
				<ul>
					<s:iterator value="tzgg0" var="tz" >
						<li>·<a href="${pageContext.request.contextPath}/indexYlwsAction!findTzggForShow?tzggID=${tz.tzggID }">
						${fn:substring(tz.tzggTitle , 0, 16)}...  
						</a></li>
					</s:iterator>
				</ul>
			</div>	
			<div class="index_R_1" style="margin-top:14px;">
				<div class="title4"><a href="${pageContext.request.contextPath}/indexYlwsAction!queryZnbmMenu">
					<img src="${pageContext.request.contextPath}/resource/images/more2.jpg" /></a>职能部门</div>
				<ul class="zhineng">
					<li><a href="${pageContext.request.contextPath}/indexYlwsAction!findZnbmForShow?type=0">办公室职能</a></li>
					<li><a href="${pageContext.request.contextPath}/indexYlwsAction!findZnbmForShow?type=1">业务科职能</a></li>
					<li><a href="${pageContext.request.contextPath}/indexYlwsAction!findZnbmForShow?type=2">服务站职能</a></li>
				</ul>
			</div>	
		</div>
	</div>
	<p class="c"></p>
	<div class="tl"><img src="${pageContext.request.contextPath}/resource/images/yiliao_tl.jpg" width="1000" height="93" /></div>
	<div class="renkou">
		<div id="renkou_L">
			<div class="index_L_ry">
				<div class="title2"><a href="${pageContext.request.contextPath}/indexYlwsAction!queryBsznMenu">
				<img src="${pageContext.request.contextPath}/resource/images/more.jpg" /></a>办事指南</div>
				<div class="renkou_L_b">
					<ul>
					<s:iterator value="bszn0" var="bs" >
						<li>·<a href="${pageContext.request.contextPath}/indexYlwsAction!findBsznForShow?bsznID=${bs.bsznID }">
						${fn:substring(bs.bsznTitle , 0, 23)}...  
						</a></li>
					</s:iterator>
					</ul>
				</div>
			</div>
			<div class="renkou_M">
				<div class="title1"><a href="${pageContext.request.contextPath}/indexYlwsAction!queryRdgzMenu">
				<img src="${pageContext.request.contextPath}/resource/images/more.jpg" /></a>热点关注</div>
				<ul>
					<s:iterator value="rdgz0" var="rd" >
							<li>·<a href="${pageContext.request.contextPath}/indexYlwsAction!findRdgzForShow?rdgzID=${rd.rdgzID }">
							${fn:substring(rd.rdgzTitle  , 0, 28)}...
							</a></li>
					</s:iterator>
				</ul>
			</div>
			<div class="renkou_R">
			<div class="title4"><a href="${pageContext.request.contextPath}/indexYlwsAction!queryLxfsMenu">
				<img src="${pageContext.request.contextPath}/resource/images/more2.jpg" /></a>联系方式</div>
				<p>电话：029-84501556</p>
				<p>传真：029-84501556</p>
				<p>邮箱：983748342@QQ.com</p>
				<p>邮编：710086</p>
				<p>地址：西安市建章路中段158号</p>
			</div>
		</div>
	</div>
	<p class="c"></p>
	<div class="link">
		<select class="input">
			<option>国务院各部委</option>
			<option>国务院各部委...</option>
		</select>
		<select class="input">
			<option>省级政府网站</option>
			<option>省级政府网站...</option>
		</select>
		<select class="input">
			<option>西安市各级政府网站</option>
			<option>国务院各部委...</option>
		</select>
		<select class="input">
			<option>其他友情链接</option>
			<option>其他友情链接...</option>
		</select>
	</div>
	<div class="footer">
	<%@include file="/page/main/common/footer.jsp" %>
	</div>
</div>
</body>
</html>