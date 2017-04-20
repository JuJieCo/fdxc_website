<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>西咸新区沣东新城计卫文体局</title>
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
		links += escape("${pageContext.request.contextPath}/indexAction!findXinWenForShow?xinwenID=${tpxw0ID}&type=2");
		texts += "${tpxw0Title}";
		
		pics += "|";
		links += "|";
		texts += "|";
		
		pics += "${pageContext.request.contextPath}${tpxwimg1 }";
		links += escape("${pageContext.request.contextPath}/indexAction!findXinWenForShow?xinwenID=${tpxw1ID}&type=2");
		texts += "${tpxw1Title}";
		
		pics += "|";
		links += "|";
		texts += "|";
		
		pics += "${pageContext.request.contextPath}${tpxwimg2 }";
		links += escape("${pageContext.request.contextPath}/indexAction!findXinWenForShow?xinwenID=${tpxw2ID}&type=2");
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
			
				<!-- iterator 要闻简报 -->
				<div class="index_L_yaowen">
					<div class="title1"><a href="${pageContext.request.contextPath}/indexAction!queryXinwenMenu?type=0">
					<img src="${pageContext.request.contextPath}/resource/images/more.jpg" /></a>要闻简报</div>
					<ul class="yaowen_list">
						<s:iterator value="xinwen0" var="xw" >
						<li>
							<span><fmt:formatDate value="${xw.subDate }" pattern="[yyyy-MM-dd]"/></span>
							·<a href="${pageContext.request.contextPath}/indexAction!findXinWenForShow?xinwenID=${xw.xinwenID }&type=0">
								 ${fn:substring(xw.xinwenTitle , 0, 23)}...
							</a>
						</li>
						</s:iterator>
					</ul>
				</div>
				
			</div>
			<div id="index_L_2">
				<div class="index_L_ry">
					<div class="title2"><a href="${pageContext.request.contextPath}/indexAction!queryHdryMenu">
					<img src="${pageContext.request.contextPath}/resource/images/more.jpg" /></a>获得荣誉</div>
					<div class="ry">
						
							<c:if test="${ryimg.hdryFileUrl ne null }">
							<img width="246px" height="182px" src="${pageContext.request.contextPath}${ryimg.hdryFileUrl }" />
							</c:if>
							<p>${ryimg.hdryTitle }</p>
						
					</div>
				</div>
				<div class="index_L_zu">	
					<ul class="tabbtn" id="normaltab">
						<li class="current"><a href="${pageContext.request.contextPath}/indexAction!queryXinwenMenu?type=1">政务新闻</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryXinwenMenu?type=3">处室动态</a></li>
						<li><a href="${pageContext.request.contextPath}/indexAction!queryXinwenMenu?type=4">党建工作</a></li>
						<li class="more"><a href="#"><img src="${pageContext.request.contextPath}/resource/images/more1.jpg" /></a></li>
					</ul><!--tabbtn end-->
					<p class="c"></p>
					<div class="tabcon" id="normalcon">
						
						<!-- iterator 政务新闻 -->
						<div class="sublist">
							<ul>
								<s:iterator value="xinwen1" var="xw">
								<li>
									<span><fmt:formatDate value="${xw.subDate }" pattern="[yyyy-MM-dd]"/></span>
									·<a href="${pageContext.request.contextPath}/indexAction!findXinWenForShow?xinwenID=${xw.xinwenID }&type=1">
										 ${fn:substring(xw.xinwenTitle , 0, 23)}...
									</a>
								</li>
								</s:iterator>
							</ul>
						</div><!--tabcon end-->
						
						<!-- iterator 处室动态 -->
						<div class="sublist" style="display:none;">
							<ul>
								<s:iterator value="xinwen3" var="xw">
									<li>
										<span><fmt:formatDate value="${xw.subDate }" pattern="[yyyy-MM-dd]"/></span>
										·<a href="${pageContext.request.contextPath}/indexAction!findXinWenForShow?xinwenID=${xw.xinwenID }&type=3">
											${fn:substring(xw.xinwenTitle , 0, 23)}...
										</a>
									</li>
								</s:iterator>
							</ul>
						</div><!--tabcon end-->
						
						<!-- iterator 党建工作-->
						<div class="sublist" style="display:none;">
							<ul>
								<s:iterator value="xinwen4" var="xw">
									<li>
										<span><fmt:formatDate value="${xw.subDate }" pattern="[yyyy-MM-dd]"/></span>
										·<a href="${pageContext.request.contextPath}/indexAction!findXinWenForShow?xinwenID=${xw.xinwenID }&type=4">
											${fn:substring(xw.xinwenTitle , 0, 23)}...
										</a>
									</li>
								</s:iterator>
							</ul>
						</div><!--tabcon end-->
					</div><!--tabcon end-->					
			</div>
		</div>
		<div id="index_L_3">
			<a href="${pageContext.request.contextPath}/indexRkjsAction!showIndexPage"  target="_blank" style="margin-left:0px;"><img src="${pageContext.request.contextPath}/resource/images/pic1.jpg" /></a>
			<a href="${pageContext.request.contextPath}/indexYlwsAction!showIndexPage" target="_blank"><img src="${pageContext.request.contextPath}/resource/images/pic2.jpg" /></a>
			<a href="${pageContext.request.contextPath}/indexWtlyAction!showIndexPage" target="_blank"><img src="${pageContext.request.contextPath}/resource/images/pic3.jpg" /></a>
		</div>
		<div id="index_L_4">
			<img src="${pageContext.request.contextPath}/resource/images/tonglan.jpg" />
		</div>
		<div id="index_L_5">
				<div class="index_L_jigou">
					<div class="title2"><a href="${pageContext.request.contextPath}/indexAction!queryZzjgMenu">
					<img src="${pageContext.request.contextPath}/resource/images/more.jpg" /></a>机构设置</div>
					<div class="jigou">
						<ul>
							<li><a href="${pageContext.request.contextPath}/indexAction!queryZzjgMenu"><img src="${pageContext.request.contextPath}/resource/images/jigou1.jpg" /></a></li>
							<li><a href="${pageContext.request.contextPath}/indexAction!queryBjznMenu"><img src="${pageContext.request.contextPath}/resource/images/jigou2.jpg" /></a></li>
							<li><a href="${pageContext.request.contextPath}/indexAction!queryDsjyMenu"><img src="${pageContext.request.contextPath}/resource/images/jigou3.jpg" /></a></li>
							<li><a href="${pageContext.request.contextPath}/indexAction!queryLxfsMenu"><img src="${pageContext.request.contextPath}/resource/images/jigou4.jpg" /></a></li>
						</ul>	
					</div>
				</div>
				<div class="index_L_zc">
					<div class="title1"><a href="${pageContext.request.contextPath}/indexAction!queryFGMenu?type=0">
					<img src="${pageContext.request.contextPath}/resource/images/more.jpg" /></a>政策法规</div>
					<ul class="zc_list">
						<s:iterator value="zcfg0" var="zc">
						<li>·<a href="${pageContext.request.contextPath}/indexAction!findZcfgForShow?zcfgID=${zc.zcfgID }">
								${fn:substring(zc.zcfgTitle , 0, 23)}...
							</a>
						</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<p class="c"></p>
			<div id="index_L_6">
				<div class="title3"><a href="${pageContext.request.contextPath}/indexAction!queryFdyxMenu">
				<img src="${pageContext.request.contextPath}/resource/images/more.jpg" /></a>沣东印象</div>
				<ul>
					<s:iterator value="fdfj0" var="fd"> 
					<li><img src="${pageContext.request.contextPath}${fd.fdfjFileUrl }" width="140px"  height="105px" /></li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div id="index_R">
			<div class="index_R_1">
				<div class="title4"><a href="${pageContext.request.contextPath}/indexAction!queryTzggMenu">
				<img src="${pageContext.request.contextPath}/resource/images/more2.jpg" /></a>通知公告</div>
				<ul>
					<s:iterator value="tzgg0" var="tz" >
						<li>·<a href="${pageContext.request.contextPath}/indexAction!findTzggForShow?tzggID=${tz.tzggID }">
								${fn:substring(tz.tzggTitle , 0, 16)}...
							</a>
						</li>
					</s:iterator>
				</ul>
			</div>	
			<div class="index_R_1" style="margin-top:14px;">
				<div class="title4"><a href="${pageContext.request.contextPath}/indexAction!queryXinwenMenu?type=5">
					<img src="${pageContext.request.contextPath}/resource/images/more2.jpg" /></a>领导讲话</div>
					<div class="ld">
					<c:if test="${ldimg ne null }">
						<img width="200px" height="150px" src="${pageContext.request.contextPath}${ldimg }" />
					</c:if>
					<p>&nbsp;${fn:substring(xinwen5[0].xinwenTitle , 0, 15)}...&nbsp;</p>
				</div>
				<div align="center">
					<a href="${pageContext.request.contextPath}/indexAction!findXinWenForShow?xinwenID=${xinwen5[0].xinwenID }&type=5">
					 	${fn:substring(xinwen5[0].xinwenContent , 0, 70)}...
					</a>
				</div>
			</div>
			<div class="index_R_1" style="margin-top:15px;">
				<div class="title4"><a href="${pageContext.request.contextPath}/indexAction!queryWjfbMenu">
				<img src="${pageContext.request.contextPath}/resource/images/more2.jpg" /></a>文件发布</div>
				<ul>
				<s:iterator value="wjfb0" var="wj" >
					<li>·<a href="${pageContext.request.contextPath}/indexAction!findWjfbForShow?wjfbID=${wj.wjfbID }">
							${fn:substring(wj.wjfbTitle , 0, 16)}... 
						</a>
					</li>
				</s:iterator>
				</ul>
			</div>	
			<div class="index_R_2" style="margin-top:15px;">
				<ul>
					<li><a href="${pageContext.request.contextPath}/indexAction!queryXzzqMenu"><img src="${pageContext.request.contextPath}/resource/images/btn1.jpg" /></a></li>
					<li><a href="${pageContext.request.contextPath}/indexAction!queryRdgzMenu"><img src="${pageContext.request.contextPath}/resource/images/btn2.jpg" /></a></li>
					<li><a href="${pageContext.request.contextPath}/indexAction!queryBsznMenu"><img src="${pageContext.request.contextPath}/resource/images/btn3.jpg" /></a></li>
					<li><a href="${pageContext.request.contextPath}/indexAction!queryJbfcMenu"><img src="${pageContext.request.contextPath}/resource/images/btn4.jpg" /></a></li>
					<li><a href="${pageContext.request.contextPath}/indexAction!queryFdyxMenu"><img src="${pageContext.request.contextPath}/resource/images/btn5.jpg" /></a></li>
				</ul>
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
		<p>主办单位：西咸新区沣东新城计卫文体局</p>
		
		<p>计生：029-84501556 &nbsp; &nbsp;  &nbsp;卫生：029-89106955  </p>
		<p>旅游热线：029-89108513 &nbsp; &nbsp; &nbsp;文化：029-84501586 </p>
		
		<p>技术支持：西安金裕数码有限公司</p>
		<p>电话：029-84501556
			<a href="${pageContext.request.contextPath}/loginAction!showAdminLogin">管理</a>
		</p>
	</div>
</div>
</body>
</html>


