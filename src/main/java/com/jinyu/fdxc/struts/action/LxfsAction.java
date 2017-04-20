package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.LxfsService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Lxfs;
import com.jinyu.fdxc.struts.bean.SysUser;

public class LxfsAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Lxfs lxfs;
	private List<Lxfs> lxfsList;
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

	public Lxfs getLxfs() {
		return lxfs;
	}

	public void setLxfs(Lxfs lxfs) {
		this.lxfs = lxfs;
	}

	public List<Lxfs> getLxfsList() {
		return lxfsList;
	}

	public void setLxfsList(List<Lxfs> lxfsList) {
		this.lxfsList = lxfsList;
	}

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultLxfsList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		LxfsService lxfsService = (LxfsService) this.getService("lxfsService");
		lxfsList = lxfsService.queryDefaultLxfsList(lxfs, page);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryLxfsList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		LxfsService lxfsService = (LxfsService) this.getService("lxfsService");
		lxfsList = lxfsService.queryLxfsList(lxfs, page);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findLxfsForModify() throws Exception {
		LxfsService lxfsService = (LxfsService) this.getService("lxfsService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			lxfs = new Lxfs();
			// 设置发布时间
			lxfs.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute(
					"sessionLoginUser");
			lxfs.setSysUser(user);
		} else if (null != modify && "update".equals(modify)) {
			String lxfsID = request.getParameter("lxfsID");
			lxfs = lxfsService.findLxfsByID(lxfsID);
		}
		return "modify";
	}

	public String findLxfsForShow() throws Exception {
		LxfsService lxfsService = (LxfsService) this.getService("lxfsService");
		String lxfsID = request.getParameter("lxfsID");
		lxfs = lxfsService.findLxfsByID(lxfsID);
		return "show";
	}

	public String modifyLxfs() throws Exception {
		LxfsService lxfsService = (LxfsService) this.getService("lxfsService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute(
				"sessionLoginUser");
		if (null != lxfs) {
			lxfs.setSysUser(user);
			lxfsService.modifyLxfs(lxfs);
		}
		return this.queryLxfsList();
	}

	public String deleteLxfsByID() throws Exception {
		LxfsService lxfsService = (LxfsService) this.getService("lxfsService");
		;
		String lxfsID = request.getParameter("lxfsID");
		lxfsService.deleteLxfsByID(lxfsID);
		return this.queryLxfsList();
	}

}
