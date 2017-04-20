package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.RsxxService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Rsxx;
import com.jinyu.fdxc.struts.bean.SysUser;

public class RsxxAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Rsxx rsxx;
	private List<Rsxx> rsxxList;


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

	public Rsxx getRsxx() {
		return rsxx;
	}

	public void setRsxx(Rsxx rsxx) {
		this.rsxx = rsxx;
	}

	public List<Rsxx> getRsxxList() {
		return rsxxList;
	}

	public void setRsxxList(List<Rsxx> rsxxList) {
		this.rsxxList = rsxxList;
	}

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultRsxxList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		RsxxService rsxxService = (RsxxService) this.getService("rsxxService");
		rsxxList = rsxxService.queryDefaultRsxxList(rsxx, page);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryRsxxList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		RsxxService rsxxService = (RsxxService) this.getService("rsxxService");
		rsxxList = rsxxService.queryRsxxList(rsxx, page);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findRsxxForModify() throws Exception {
		RsxxService rsxxService = (RsxxService) this.getService("rsxxService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			rsxx = new Rsxx();
			// 设置发布时间
			rsxx.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute(
					"sessionLoginUser");
			rsxx.setSysUser(user);
		} else if (null != modify && "update".equals(modify)) {
			String rsxxID = request.getParameter("rsxxID");
			rsxx = rsxxService.findRsxxByID(rsxxID);
		}
		return "modify";
	}

	public String findRsxxForShow() throws Exception {
		RsxxService rsxxService = (RsxxService) this.getService("rsxxService");
		String rsxxID = request.getParameter("rsxxID");
		rsxx = rsxxService.findRsxxByID(rsxxID);
		return "show";
	}

	public String modifyRsxx() throws Exception {
		RsxxService rsxxService = (RsxxService) this.getService("rsxxService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute(
				"sessionLoginUser");
		if (null != rsxx) {
			rsxx.setSysUser(user);
			rsxxService.modifyRsxx(rsxx);
		}
		return this.queryRsxxList();
	}

	public String deleteRsxxByID() throws Exception {
		RsxxService rsxxService = (RsxxService) this.getService("rsxxService");
		;
		String rsxxID = request.getParameter("rsxxID");
		rsxxService.deleteRsxxByID(rsxxID);
		return this.queryRsxxList();
	}

}
