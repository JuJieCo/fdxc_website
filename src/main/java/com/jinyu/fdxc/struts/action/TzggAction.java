package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.TzggService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Tzgg;

public class TzggAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Tzgg tzgg;
	private List<Tzgg> tzggList;

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

	public Tzgg getTzgg() {
		return tzgg;
	}

	public void setTzgg(Tzgg tzgg) {
		this.tzgg = tzgg;
	}

	public List<Tzgg> getTzggList() {
		return tzggList;
	}

	public void setTzggList(List<Tzgg> tzggList) {
		this.tzggList = tzggList;
	}

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultTzggList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		TzggService tzggService = (TzggService) this.getService("tzggService");
		tzggList = tzggService.queryDefaultTzggList(tzgg, page);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryTzggList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		TzggService tzggService = (TzggService) this.getService("tzggService");
		tzggList = tzggService.queryTzggList(tzgg, page);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findTzggForModify() throws Exception {
		TzggService tzggService = (TzggService) this.getService("tzggService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			tzgg = new Tzgg();
			// 设置发布时间
			tzgg.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute(
					"sessionLoginUser");
			tzgg.setSysUser(user);
		} else if (null != modify && "update".equals(modify)) {
			String tzggID = request.getParameter("tzggID");
			tzgg = tzggService.findTzggByID(tzggID);
		}
		return "modify";
	}

	public String findTzggForShow() throws Exception {
		TzggService tzggService = (TzggService) this.getService("tzggService");
		String tzggID = request.getParameter("tzggID");
		tzgg = tzggService.findTzggByID(tzggID);
		return "show";
	}

	public String modifyTzgg() throws Exception {
		TzggService tzggService = (TzggService) this.getService("tzggService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute(
				"sessionLoginUser");
		if (null != tzgg) {
			tzgg.setSysUser(user);
			tzggService.modifyTzgg(tzgg);
		}
		return this.queryTzggList();
	}

	public String deleteTzggByID() throws Exception {
		TzggService tzggService = (TzggService) this.getService("tzggService");
		;
		String tzggID = request.getParameter("tzggID");
		tzggService.deleteTzggByID(tzggID);
		return this.queryTzggList();
	}

}
