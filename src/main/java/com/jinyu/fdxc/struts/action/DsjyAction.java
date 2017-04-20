package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.DsjyService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Dsjy;
import com.jinyu.fdxc.struts.bean.SysUser;

public class DsjyAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Dsjy dsjy;
	private List<Dsjy> dsjyList;




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

	public Dsjy getDsjy() {
		return dsjy;
	}

	public void setDsjy(Dsjy dsjy) {
		this.dsjy = dsjy;
	}

	public List<Dsjy> getDsjyList() {
		return dsjyList;
	}

	public void setDsjyList(List<Dsjy> dsjyList) {
		this.dsjyList = dsjyList;
	}

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultDsjyList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		DsjyService dsjyService = (DsjyService) this.getService("dsjyService");
		dsjyList = dsjyService.queryDefaultDsjyList(dsjy, page);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryDsjyList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		DsjyService dsjyService = (DsjyService) this.getService("dsjyService");
		dsjyList = dsjyService.queryDsjyList(dsjy, page);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findDsjyForModify() throws Exception {
		DsjyService dsjyService = (DsjyService) this.getService("dsjyService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			dsjy = new Dsjy();
			// 设置发布时间
			dsjy.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute(
					"sessionLoginUser");
			dsjy.setSysUser(user);
		} else if (null != modify && "update".equals(modify)) {
			String dsjyID = request.getParameter("dsjyID");
			dsjy = dsjyService.findDsjyByID(dsjyID);
		}
		return "modify";
	}

	public String findDsjyForShow() throws Exception {
		DsjyService dsjyService = (DsjyService) this.getService("dsjyService");
		String dsjyID = request.getParameter("dsjyID");
		dsjy = dsjyService.findDsjyByID(dsjyID);
		return "show";
	}

	public String modifyDsjy() throws Exception {
		DsjyService dsjyService = (DsjyService) this.getService("dsjyService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute(
				"sessionLoginUser");
		if (null != dsjy) {
			dsjy.setSysUser(user);
			dsjyService.modifyDsjy(dsjy);
		}
		return this.queryDsjyList();
	}

	public String deleteDsjyByID() throws Exception {
		DsjyService dsjyService = (DsjyService) this.getService("dsjyService");
		;
		String dsjyID = request.getParameter("dsjyID");
		dsjyService.deleteDsjyByID(dsjyID);
		return this.queryDsjyList();
	}

}
