package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.GkfwService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Gkfw;
import com.jinyu.fdxc.struts.bean.SysUser;

public class GkfwAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Gkfw gkfw;
	private List<Gkfw> gkfwList;


	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getS_token() {
		return s_token;
	}

	public void setS_token(String s_token) {
		this.s_token = s_token;
	}

	public Gkfw getGkfw() {
		return gkfw;
	}

	public void setGkfw(Gkfw gkfw) {
		this.gkfw = gkfw;
	}

	public List<Gkfw> getGkfwList() {
		return gkfwList;
	}

	public void setGkfwList(List<Gkfw> gkfwList) {
		this.gkfwList = gkfwList;
	}

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultGkfwList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		GkfwService gkfwService = (GkfwService) this.getService("gkfwService");
		gkfwList = gkfwService.queryDefaultGkfwList(gkfw, page);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryGkfwList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		GkfwService gkfwService = (GkfwService) this.getService("gkfwService");
		gkfwList = gkfwService.queryGkfwList(gkfw, page);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findGkfwForModify() throws Exception {
		GkfwService gkfwService = (GkfwService) this.getService("gkfwService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			gkfw = new Gkfw();
			// 设置发布时间
			gkfw.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute(
					"sessionLoginUser");
			gkfw.setSysUser(user);
		} else if (null != modify && "update".equals(modify)) {
			String gkfwID = request.getParameter("gkfwID");
			gkfw = gkfwService.findGkfwByID(gkfwID);
		}
		return "modify";
	}

	public String findGkfwForShow() throws Exception {
		GkfwService gkfwService = (GkfwService) this.getService("gkfwService");
		String gkfwID = request.getParameter("gkfwID");
		gkfw = gkfwService.findGkfwByID(gkfwID);
		return "show";
	}

	public String modifyGkfw() throws Exception {
		GkfwService gkfwService = (GkfwService) this.getService("gkfwService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute("sessionLoginUser");
		if (null != gkfw) {
			gkfw.setSysUser(user);
			gkfwService.modifyGkfw(gkfw);
		}
		return this.queryGkfwList();
	}

	public String deleteGkfwByID() throws Exception {
		GkfwService gkfwService = (GkfwService) this.getService("gkfwService");
		;
		String gkfwID = request.getParameter("gkfwID");
		gkfwService.deleteGkfwByID(gkfwID);
		return this.queryGkfwList();
	}

}
