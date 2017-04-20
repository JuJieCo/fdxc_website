package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.RdgzService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Rdgz;
import com.jinyu.fdxc.struts.bean.SysUser;

public class RdgzAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Rdgz rdgz;
	private List<Rdgz> rdgzList;


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

	public Rdgz getRdgz() {
		return rdgz;
	}

	public void setRdgz(Rdgz rdgz) {
		this.rdgz = rdgz;
	}

	public List<Rdgz> getRdgzList() {
		return rdgzList;
	}

	public void setRdgzList(List<Rdgz> rdgzList) {
		this.rdgzList = rdgzList;
	}

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultRdgzList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		RdgzService rdgzService = (RdgzService) this.getService("rdgzService");
		rdgzList = rdgzService.queryDefaultRdgzList(rdgz, page);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryRdgzList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		RdgzService rdgzService = (RdgzService) this.getService("rdgzService");
		rdgzList = rdgzService.queryRdgzList(rdgz, page);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findRdgzForModify() throws Exception {
		RdgzService rdgzService = (RdgzService) this.getService("rdgzService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			rdgz = new Rdgz();
			// 设置发布时间
			rdgz.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute(
					"sessionLoginUser");
			rdgz.setSysUser(user);
		} else if (null != modify && "update".equals(modify)) {
			String rdgzID = request.getParameter("rdgzID");
			rdgz = rdgzService.findRdgzByID(rdgzID);
		}
		return "modify";
	}

	public String findRdgzForShow() throws Exception {
		RdgzService rdgzService = (RdgzService) this.getService("rdgzService");
		String rdgzID = request.getParameter("rdgzID");
		rdgz = rdgzService.findRdgzByID(rdgzID);
		return "show";
	}

	public String modifyRdgz() throws Exception {
		RdgzService rdgzService = (RdgzService) this.getService("rdgzService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute(
				"sessionLoginUser");
		if (null != rdgz) {
			rdgz.setSysUser(user);
			rdgzService.modifyRdgz(rdgz);
		}
		return this.queryRdgzList();
	}

	public String deleteRdgzByID() throws Exception {
		RdgzService rdgzService = (RdgzService) this.getService("rdgzService");
		;
		String rdgzID = request.getParameter("rdgzID");
		rdgzService.deleteRdgzByID(rdgzID);
		return this.queryRdgzList();
	}

}
