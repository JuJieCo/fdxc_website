package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.FzghService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Fzgh;
import com.jinyu.fdxc.struts.bean.SysUser;

public class FzghAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Fzgh fzgh;
	private List<Fzgh> fzghList;

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

	public Fzgh getFzgh() {
		return fzgh;
	}

	public void setFzgh(Fzgh fzgh) {
		this.fzgh = fzgh;
	}

	public List<Fzgh> getFzghList() {
		return fzghList;
	}

	public void setFzghList(List<Fzgh> fzghList) {
		this.fzghList = fzghList;
	}

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultFzghList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		FzghService fzghService = (FzghService) this.getService("fzghService");
		fzghList =fzghService.queryDefaultFzghList(fzgh, page);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryFzghList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		FzghService fzghService = (FzghService) this.getService("fzghService");
		fzghList =fzghService.queryFzghList(fzgh, page);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findFzghForModify() throws Exception {
		FzghService fzghService = (FzghService) this.getService("fzghService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			fzgh = new Fzgh();
			// 设置发布时间
			fzgh.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute(
					"sessionLoginUser");
			fzgh.setSysUser(user);
		} else if (null != modify && "update".equals(modify)) {
			String fzghID = request.getParameter("fzghID");
			fzgh = fzghService.findFzghByID(fzghID);
		}
		return "modify";
	}

	public String findFzghForShow() throws Exception {
		FzghService fzghService = (FzghService) this.getService("fzghService");
		String fzghID = request.getParameter("fzghID");
		fzgh = fzghService.findFzghByID(fzghID);
		return "show";
	}

	public String modifyFzgh() throws Exception {
		FzghService fzghService = (FzghService) this.getService("fzghService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute(
				"sessionLoginUser");
		if (null != fzgh) {
			fzgh.setSysUser(user);
			fzghService.modifyFzgh(fzgh);
		}
		return this.queryFzghList();
	}

	public String deleteFzghByID() throws Exception {
		FzghService fzghService = (FzghService) this.getService("fzghService");
		;
		String fzghID = request.getParameter("fzghID");
		fzghService.deleteFzghByID(fzghID);
		return this.queryFzghList();
	}

}
