package com.jinyu.fdxc.struts.action;

import java.util.List;

import com.jinyu.fdxc.model.service.SysUserService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;

public class SysUserAction extends BaseActionSupper{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Page page;
	private String s_token;
	private SysUser sysUser;
	private List<SysUser> sysUserList;
	
	
	
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
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public List<SysUser> getSysUserList() {
		return sysUserList;
	}
	public void setSysUserList(List<SysUser> sysUserList) {
		this.sysUserList = sysUserList;
	}
	
	
	
	/**
	 *跳转到 list 页面 
	 */
	public String queryDefaultUserList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		SysUserService sysUserService = (SysUserService)this.getService("sysUserService");
		sysUserList = sysUserService.queryDefaultUserList(sysUser , page);
		return "list";
	}
	
	
	/**
	 *条件查询 
	 */
	public String queryUserList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		SysUserService sysUserService = (SysUserService)this.getService("sysUserService");
		sysUserList = sysUserService.queryUserList(sysUser,page);
		return "list";
	}
	
	
	/**
	 *跳转到show页面 
	 */
	public String findUserForShow() throws Exception {
		SysUserService sysUserService = (SysUserService)this.getService("sysUserService");
		String userID = request.getParameter("userID");
		sysUser = sysUserService.findUserByID(userID);
		return "show";
	}
	
	
	/**
	 *跳转到 新增&修改 页面
	 */
	public String findUserForModify() throws Exception {
		SysUserService sysUserService = (SysUserService)this.getService("sysUserService");
		String userID = request.getParameter("userID");
		sysUser = sysUserService.findUserByID(userID);
		return "modify";
	}
	
	
	/**
	 *新增&修改 
	 */	
	public String modifyUser() throws Exception {
		SysUserService sysUserService = (SysUserService)this.getService("sysUserService");
		sysUserService.modifyUser(sysUser);
		return this.queryUserList();
	}
	
	/**
	 * 使失效
	 */
	
	public String deleteUserByID() throws Exception{
		SysUserService sysUserService = (SysUserService)this.getService("sysUserService");
		String userID = request.getParameter("userID");
		sysUserService.deleteUserByID(userID);
		return this.queryUserList();
	}
	
	
	/**
	 * 使有效
	 */
	public String showUserByID() throws Exception{
		SysUserService sysUserService = (SysUserService)this.getService("sysUserService");
		String userID = request.getParameter("userID");
		sysUserService.resetUserByID(userID);
		return this.queryUserList();
	}
	

}
