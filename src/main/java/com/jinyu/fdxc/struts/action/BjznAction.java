package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.BjznService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Bjzn;
import com.jinyu.fdxc.struts.bean.SysUser;

public class BjznAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Bjzn bjzn;
	private List<Bjzn> bjznList;

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

	public Bjzn getBjzn() {
		return bjzn;
	}

	public void setBjzn(Bjzn bjzn) {
		this.bjzn = bjzn;
	}

	public List<Bjzn> getBjznList() {
		return bjznList;
	}

	public void setBjznList(List<Bjzn> bjznList) {
		this.bjznList = bjznList;
	}

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultBjznList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BjznService bjznService = (BjznService) this.getService("bjznService");
		bjznList = bjznService.queryDefaultBjznList(bjzn, page);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryBjznList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BjznService bjznService = (BjznService) this.getService("bjznService");
		bjznList = bjznService.queryBjznList(bjzn, page);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findBjznForModify() throws Exception {
		BjznService bjznService = (BjznService) this.getService("bjznService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			bjzn = new Bjzn();
			// 设置发布时间
			bjzn.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute(
					"sessionLoginUser");
			bjzn.setSysUser(user);
		} else if (null != modify && "update".equals(modify)) {
			String bjznID = request.getParameter("bjznID");
			bjzn = bjznService.findBjznByID(bjznID);
		}
		return "modify";
	}

	public String findBjznForShow() throws Exception {
		BjznService bjznService = (BjznService) this.getService("bjznService");
		String bjznID = request.getParameter("bjznID");
		bjzn = bjznService.findBjznByID(bjznID);
		return "show";
	}

	public String modifyBjzn() throws Exception {
		BjznService bjznService = (BjznService) this.getService("bjznService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute(
				"sessionLoginUser");
		if (null != bjzn) {
			bjzn.setSysUser(user);
			bjznService.modifyBjzn(bjzn);
		}
		return this.queryBjznList();
	}

	public String deleteBjznByID() throws Exception {
		BjznService bjznService = (BjznService) this.getService("bjznService");
		;
		String bjznID = request.getParameter("bjznID");
		bjznService.deleteBjznByID(bjznID);
		return this.queryBjznList();
	}

}
