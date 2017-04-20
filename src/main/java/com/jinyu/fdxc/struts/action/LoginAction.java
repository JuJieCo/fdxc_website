package com.jinyu.fdxc.struts.action;

import com.jinyu.fdxc.model.service.LoginService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.struts.bean.SysUser;

public class LoginAction extends BaseActionSupper{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private SysUser sysUser;
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

	/**
	 *由主页跳转到后台登陆页 
	 */
	public String showAdminLogin() throws  Exception {
		
		return "showAdminLogin";
	}

	/**
	 *后台登陆 
	 */
	public String login() throws Exception {
		LoginService loginService = (LoginService) this.getService("loginService");
		
		response.setCharacterEncoding("UTF-8");
		try{
			sysUser = loginService.findSysUserByNameAndPassword(sysUser.getLoginName(), sysUser.getPassword());
			if(sysUser!=null){
				SysUser loginUser = loginService.findSysUserByID(sysUser.getUserID().toString());
																
				if(loginUser.getUserID()==null){
					this.getCxt().put("mesg", "用户不存在！");
					return "login";
				}else{
					request.getSession().setAttribute("sessionLoginUser", loginUser);
				}
			}else{
				this.getCxt().put("mesg", "登录名或密码有误！");
				return "login";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "login";
		}
		return "index";
	}
	
	
	public String logout() throws Exception {
		request.getSession().removeAttribute("sessionLoginUser");
		return "logout";
	}
	
	



}
