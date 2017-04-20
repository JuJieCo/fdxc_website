package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.ZnbmService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Znbm;
import com.jinyu.fdxc.struts.bean.SysUser;

public class ZnbmAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Znbm znbm;
	private List<Znbm> znbmList;
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

	public Znbm getZnbm() {
		return znbm;
	}

	public void setZnbm(Znbm znbm) {
		this.znbm = znbm;
	}

	public List<Znbm> getZnbmList() {
		return znbmList;
	}

	public void setZnbmList(List<Znbm> znbmList) {
		this.znbmList = znbmList;
	}

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultZnbmList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		ZnbmService znbmService = (ZnbmService) this.getService("znbmService");
		znbmList = znbmService.queryDefaultZnbmList(znbm, page);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryZnbmList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		ZnbmService znbmService = (ZnbmService) this.getService("znbmService");
		znbmList = znbmService.queryZnbmList(znbm, page);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findZnbmForModify() throws Exception {
		ZnbmService znbmService = (ZnbmService) this.getService("znbmService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			znbm = new Znbm();
			// 设置发布时间
			znbm.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute(
					"sessionLoginUser");
			znbm.setUser(user);
		} else if (null != modify && "update".equals(modify)) {
			String znbmID = request.getParameter("znbmID");
			znbm = znbmService.findZnbmByID(znbmID);
		}
		return "modify";
	}

	public String findZnbmForShow() throws Exception {
		ZnbmService znbmService = (ZnbmService) this.getService("znbmService");
		String znbmID = request.getParameter("znbmID");
		znbm = znbmService.findZnbmByID(znbmID);
		return "show";
	}

	public String modifyZnbm() throws Exception {
		ZnbmService znbmService = (ZnbmService) this.getService("znbmService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute("sessionLoginUser");
		if (null != znbm) {
			znbm.setUser(user);
			znbmService.modifyZnbm(znbm);
		}
		return this.queryZnbmList();
	}

	public String deleteZnbmByID() throws Exception {
		ZnbmService znbmService = (ZnbmService) this.getService("znbmService");
		;
		String znbmID = request.getParameter("znbmID");
		znbmService.deleteZnbmByID(znbmID);
		return this.queryZnbmList();
	}

}
