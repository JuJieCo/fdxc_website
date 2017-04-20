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

<SCRIPT language=javascript>
	function expand(el) {
		childObj = document.getElementById("child" + el);

		if (childObj.style.display == 'none') {
			childObj.style.display = 'block';
		} else {
			childObj.style.display = 'none';
		}
		return;
	}
</SCRIPT>
</HEAD>


<BODY>
	<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170
		background=${pageContext.request.contextPath}/resource/admin/images/menu_bg.jpg
		border=0>
		<TR>
			<TD vAlign=top align=middle>
				<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>

					<TR>
						<TD height=10></TD>
					</TR>
				</TABLE>




				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background=${pageContext.request.contextPath}/resource/admin/images/menu_bt.jpg><A
							class=menuParent onclick=expand(1) href="javascript:void(0);">新闻中心</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child1 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/xinWenAction!queryDefaultXinWenList?type=0" target=main>要闻简报</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/xinWenAction!queryDefaultXinWenList?type=1" target=main>政务新闻</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/xinWenAction!queryDefaultXinWenList?type=2" target=main>图片新闻</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/xinWenAction!queryDefaultXinWenList?type=3" target=main>处室动态</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/xinWenAction!queryDefaultXinWenList?type=4" target=main>党建工作</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/xinWenAction!queryDefaultXinWenList?type=5" target=main>领导讲话</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>




				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background=${pageContext.request.contextPath}/resource/admin/images/menu_bt.jpg><A
							class=menuParent onclick=expand(2) href="javascript:void(0);">机构设置</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child2 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/zzjgAction!queryDefaultZzjgList" target=main>组织机构</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/bjznAction!queryDefaultBjznList" target=main>本局职能</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/hdryAction!queryDefaultHdryList" target=main>获得荣誉</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/dsjyAction!queryDefaultDsjyList" target=main>大事记要</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/lxfsAction!queryDefaultLxfsList" target=main>联系方式</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>




				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background=${pageContext.request.contextPath}/resource/admin/images/menu_bt.jpg><A
							class=menuParent onclick=expand(3) href="javascript:void(0);">政务公开</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child3 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/gkfwAction!queryDefaultGkfwList" target=main>公开范围</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/ldcyAction!queryDefaultLdcyList" target=main>领导成员</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/rsxxAction!queryDefaultRsxxList" target=main>人事信息</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/fzghAction!queryDefaultFzghList" target=main>发展规划</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/ndjhAction!queryDefaultNdjhList" target=main>年度计划</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/wjfbAction!queryDefaultWjfbList" target=main>文件发布</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/tzggAction!queryDefaultTzggList" target=main>通知公告</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>
				
				
				
				
				
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background=${pageContext.request.contextPath}/resource/admin/images/menu_bt.jpg><A
							class=menuParent onclick=expand(4) href="javascript:void(0);">政策法规</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child4 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/zcfgAction!queryDefaultZcfgList?type=0" target=main>国家法规</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/zcfgAction!queryDefaultZcfgList?type=1" target=main>省级法规</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/zcfgAction!queryDefaultZcfgList?type=2" target=main>市级法规</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/zcfgAction!queryDefaultZcfgList?type=3" target=main>区级法规</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/zcfgAction!queryDefaultZcfgList?type=4" target=main>重要文献</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/zcfgAction!queryDefaultZcfgList?type=5" target=main>法规解读</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>
				
				
				
				
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background=${pageContext.request.contextPath}/resource/admin/images/menu_bt.jpg><A
							class=menuParent onclick=expand(5) href="javascript:void(0);">热点关注</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child5 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/rdgzAction!queryDefaultRdgzList" target=main>热点关注</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>
				
				
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background=${pageContext.request.contextPath}/resource/admin/images/menu_bt.jpg><A
							class=menuParent onclick=expand(6) href="javascript:void(0);">办事指南</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child6 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/bsznAction!queryDefaultBsznList" target=main>办事指南</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>
				
				
				
				
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background=${pageContext.request.contextPath}/resource/admin/images/menu_bt.jpg><A
							class=menuParent onclick=expand(7) href="javascript:void(0);">下载专区</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child7 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/xzzqAction!queryDefaultXzzqList" target=main>下载专区</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>
				
				
				
				
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background=${pageContext.request.contextPath}/resource/admin/images/menu_bt.jpg><A
							class=menuParent onclick=expand(8) href="javascript:void(0);">街办风采</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child8 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/jbfcAction!queryDefaultJbfcList" target=main>街办风采</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>
				
				
				
				
				
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background=${pageContext.request.contextPath}/resource/admin/images/menu_bt.jpg><A
							class=menuParent onclick=expand(9) href="javascript:void(0);">沣东印象</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child9 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/fdyxAction!queryDefaultFdyxList" target=main>沣东印象</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>
				
				
				
				
				
				
				
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background=${pageContext.request.contextPath}/resource/admin/images/menu_bt.jpg><A
							class=menuParent onclick=expand(10) href="javascript:void(0);">职能部门</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child10 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/znbmAction!queryDefaultZnbmList" target=main>职能部门</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>
				
				
				
				
					<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background=${pageContext.request.contextPath}/resource/admin/images/menu_bt.jpg><A
							class=menuParent onclick=expand(11) href="javascript:void(0);">文化漫步</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child11 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/whmbAction!queryDefaultWhmbList" target=main>文化漫步</A></TD>
					</TR>
					<TR height=4>
						<TD colSpan=2></TD>
					</TR>
				</TABLE>
				
				
				
				<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
					<TR height=22>
						<TD style="PADDING-LEFT: 30px"
							background=${pageContext.request.contextPath}/resource/admin/images/menu_bt.jpg><A
							class=menuParent onclick=expand(0) href="javascript:void(0);">系统管理</A></TD>
					</TR>
					<TR height=4>
						<TD></TD>
					</TR>
				</TABLE>
				<TABLE id=child0 style="DISPLAY: none" cellSpacing=0 cellPadding=0
					width=150 border=0>

					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild href="${pageContext.request.contextPath}/sysUserAction!queryDefaultUserList" target=main>人员信息</A></TD>
					</TR>
					<TR height=20>
						<TD align=middle width=30><IMG height=9
							src="${pageContext.request.contextPath}/resource/admin/images/menu_icon.gif"
							width=9></TD>
						<TD><A class=menuChild
							onclick="if (confirm('确定要退出吗？')) return true; else return false;"
							href="${pageContext.request.contextPath}/loginAction!showAdminLogin" target=_top>退出系统</A></TD>
					</TR>
				</TABLE>
			</TD>
			<TD width=1 bgColor=#d1e6f7></TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
