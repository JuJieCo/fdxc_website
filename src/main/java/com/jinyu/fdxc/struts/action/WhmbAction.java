package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.WhmbService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Whmb;

public class WhmbAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Whmb whmb;
	private List<Whmb> whmbList;

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

	public Whmb getWhmb() {
		return whmb;
	}

	public void setWhmb(Whmb whmb) {
		this.whmb = whmb;
	}

	public List<Whmb> getWhmbList() {
		return whmbList;
	}

	public void setWhmbList(List<Whmb> whmbList) {
		this.whmbList = whmbList;
	}

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultWhmbList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		WhmbService whmbService = (WhmbService) this.getService("whmbService");
		whmbList = whmbService.queryDefaultWhmbList(whmb, page);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryWhmbList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		WhmbService whmbService = (WhmbService) this.getService("whmbService");
		whmbList = whmbService.queryWhmbList(whmb, page);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findWhmbForModify() throws Exception {
		WhmbService whmbService = (WhmbService) this.getService("whmbService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			whmb = new Whmb();
			// 设置发布时间
			whmb.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute(
					"sessionLoginUser");
			whmb.setSysUser(user);
		} else if (null != modify && "update".equals(modify)) {
			String whmbID = request.getParameter("whmbID");
			whmb = whmbService.findWhmbByID(whmbID);
		}
		return "modify";
	}

	public String findWhmbForShow() throws Exception {
		WhmbService whmbService = (WhmbService) this.getService("whmbService");
		String whmbID = request.getParameter("whmbID");
		whmb = whmbService.findWhmbByID(whmbID);
		return "show";
	}

	public String modifyWhmb() throws Exception {
		WhmbService whmbService = (WhmbService) this.getService("whmbService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute(
				"sessionLoginUser");
		if (null != whmb) {
			whmb.setSysUser(user);
			whmbService.modifyWhmb(whmb);
		}
		return this.queryWhmbList();
	}

	public String deleteWhmbByID() throws Exception {
		WhmbService whmbService = (WhmbService) this.getService("whmbService");
		;
		String whmbID = request.getParameter("whmbID");
		whmbService.deleteWhmbByID(whmbID);
		return this.queryWhmbList();
	}

}
