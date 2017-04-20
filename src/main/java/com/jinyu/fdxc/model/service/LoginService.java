package com.jinyu.fdxc.model.service;

import com.jinyu.fdxc.model.dao.LoginDAO;
import com.jinyu.fdxc.struts.bean.SysUser;

public class LoginService {
	private LoginDAO loginDAO;

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	public SysUser findSysUserByNameAndPassword(String name, String password) throws Exception{
		
		return loginDAO.findSysUserByNameAndPassword(name, password);
	}
	
	public SysUser findSysUserByID(String userID) throws Exception {
		int id = 0;
			if(null!=userID&&!"".equals(userID)){		
				id = Integer.valueOf(userID);			
			}
			return loginDAO.findUserByID(id);
	}
	

}
