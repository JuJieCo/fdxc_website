package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.NdjhService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Ndjh;
import com.jinyu.fdxc.struts.bean.SysUser;

public class NdjhAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Ndjh ndjh;
	private List<Ndjh> ndjhList;
	

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

	public Ndjh getNdjh() {
		return ndjh;
	}

	public void setNdjh(Ndjh ndjh) {
		this.ndjh = ndjh;
	}

	public List<Ndjh> getNdjhList() {
		return ndjhList;
	}

	public void setNdjhList(List<Ndjh> ndjhList) {
		this.ndjhList = ndjhList;
	}

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultNdjhList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		NdjhService ndjhService = (NdjhService) this.getService("ndjhService");
		ndjhList = ndjhService.queryDefaultNdjhList(ndjh, page);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryNdjhList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		NdjhService ndjhService = (NdjhService) this.getService("ndjhService");
		ndjhList = ndjhService.queryNdjhList(ndjh, page);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findNdjhForModify() throws Exception {
		NdjhService ndjhService = (NdjhService) this.getService("ndjhService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			ndjh = new Ndjh();
			// 设置发布时间
			ndjh.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute(
					"sessionLoginUser");
			ndjh.setSysUser(user);
		} else if (null != modify && "update".equals(modify)) {
			String ndjhID = request.getParameter("ndjhID");
			ndjh = ndjhService.findNdjhByID(ndjhID);
		}
		return "modify";
	}

	public String findNdjhForShow() throws Exception {
		NdjhService ndjhService = (NdjhService) this.getService("ndjhService");
		String ndjhID = request.getParameter("ndjhID");
		ndjh = ndjhService.findNdjhByID(ndjhID);
		return "show";
	}

	public String modifyNdjh() throws Exception {
		NdjhService ndjhService = (NdjhService) this.getService("ndjhService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute(
				"sessionLoginUser");
		if (null != ndjh) {
			ndjh.setSysUser(user);
			ndjhService.modifyNdjh(ndjh);
		}
		return this.queryNdjhList();
	}

	public String deleteNdjhByID() throws Exception {
		NdjhService ndjhService = (NdjhService) this.getService("ndjhService");
	
		String ndjhID = request.getParameter("ndjhID");
		ndjhService.deleteNdjhByID(ndjhID);
		return this.queryNdjhList();
	}

}
