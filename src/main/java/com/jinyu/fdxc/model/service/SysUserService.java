package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.SysUserDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;

public class SysUserService {
	
	private SysUserDAO sysUserDAO;

	public void setSysUserDAO(SysUserDAO sysUserDAO) {
		this.sysUserDAO = sysUserDAO;
	}
	
	
	/**
	 *默认列表查询 
	 */ 
	public List<SysUser> queryDefaultUserList(SysUser sysUser , Page page) throws Exception {
		Object[] objs = new Object[2];
		if (null != sysUser && !"".equals(sysUser)) {
			objs[0] = sysUser.getUserID();
		}
		return sysUserDAO.queryUserList(objs,page);
	}
	
	/**
	 *条件列表查询 
	 */ 
	public List<SysUser> queryUserList(SysUser sysUser , Page page) throws Exception {
		Object[] objs = new Object[2];
		if (null != sysUser && !"".equals(sysUser)) {
			objs[1] = sysUser.getLoginName();
		}
		return sysUserDAO.queryUserList(objs , page );
	}
	
	
	public SysUser findUserByID(String userID) throws Exception {
		int id = 0;
			if(null!=userID&&!"".equals(userID)){		
				id = Integer.valueOf(userID);			
			}
			return sysUserDAO.findUserByID(id);
	}
	
	public void modifyUser(SysUser sysUser) throws Exception {
		if (null != sysUser.getUserID() && !"".equals(sysUser.getUserID())) {
			sysUserDAO.editUser(sysUser);
		} else {
			sysUser.setHold("0");
			sysUserDAO.saveUser(sysUser);
		}
	}
	
	public void deleteUserByID(String userID) throws Exception {
		int id = 0;
		if(null!=userID&&!"".equals(userID)){		
			id = Integer.valueOf(userID);		
			sysUserDAO.deleteUserByID(id);
		}
	}
	
	public void resetUserByID(String userID) throws Exception {
		int id = 0;
		if(null!=userID&&!"".equals(userID)){		
			id = Integer.valueOf(userID);		
			sysUserDAO.resetUserByID(id);
		}
	}
	

}
