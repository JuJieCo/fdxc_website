package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.BsznService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Bszn;
import com.jinyu.fdxc.struts.bean.SysUser;

public class BsznAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Bszn bszn;
	private List<Bszn> bsznList;


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

	public Bszn getBszn() {
		return bszn;
	}

	public void setBszn(Bszn bszn) {
		this.bszn = bszn;
	}

	public List<Bszn> getBsznList() {
		return bsznList;
	}

	public void setBsznList(List<Bszn> bsznList) {
		this.bsznList = bsznList;
	}

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultBsznList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BsznService bsznService = (BsznService) this.getService("bsznService");
		bsznList = bsznService.queryDefaultBsznList(bszn, page);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryBsznList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BsznService bsznService = (BsznService) this.getService("bsznService");
		bsznList = bsznService.queryBsznList(bszn, page);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findBsznForModify() throws Exception {
		BsznService bsznService = (BsznService) this.getService("bsznService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			bszn = new Bszn();
			// 设置发布时间
			bszn.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute(
					"sessionLoginUser");
			bszn.setSysUser(user);
		} else if (null != modify && "update".equals(modify)) {
			String bsznID = request.getParameter("bsznID");
			bszn = bsznService.findBsznByID(bsznID);
		}
		return "modify";
	}

	public String findBsznForShow() throws Exception {
		BsznService bsznService = (BsznService) this.getService("bsznService");
		String bsznID = request.getParameter("bsznID");
		bszn = bsznService.findBsznByID(bsznID);
		return "show";
	}

	public String modifyBszn() throws Exception {
		BsznService bsznService = (BsznService) this.getService("bsznService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute(
				"sessionLoginUser");
		if (null != bszn) {
			bszn.setSysUser(user);
			bsznService.modifyBszn(bszn);
		}
		return this.queryBsznList();
	}

	public String deleteBsznByID() throws Exception {
		BsznService bsznService = (BsznService) this.getService("bsznService");
		;
		String bsznID = request.getParameter("bsznID");
		bsznService.deleteBsznByID(bsznID);
		return this.queryBsznList();
	}

}
