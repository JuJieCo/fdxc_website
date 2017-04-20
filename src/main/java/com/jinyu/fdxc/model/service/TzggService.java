package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.TzggDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Tzgg;

public class TzggService {

	private TzggDAO tzggDAO;
	public void setTzggDAO(TzggDAO tzggDAO) {
		this.tzggDAO = tzggDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Tzgg> queryDefaultTzggList(Tzgg tzgg, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != tzgg && !"".equals(tzgg)) {
			objs[0] = tzgg.getTzggID();
		}
		return tzggDAO.queryTzggList(objs,page,null);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Tzgg> queryTzggList(Tzgg tzgg, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != tzgg && !"".equals(tzgg)) {
			objs[1] = tzgg.getTzggTitle();
		}
		return tzggDAO.queryTzggList(objs,page,null);
	}
	
	
	/**
	 *查一条 
	 */
	public Tzgg findTzggByID(String tzggID) throws Exception {
		int id = 0;
			if(null!=tzggID&&!"".equals(tzggID)){		
				id = Integer.valueOf(tzggID);			
			}
			SysUser user = tzggDAO.findUserByID(id);
			Tzgg tzgg= tzggDAO.findTzggByID(id);
			tzgg.getSysUser().setLoginName(user.getLoginName());
			return tzgg;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyTzgg(Tzgg tzgg) throws Exception {
		if (null != tzgg.getTzggID() && !"".equals(tzgg.getTzggID())) {
			tzggDAO.editTzgg(tzgg);
		} else {
			tzggDAO.saveTzgg(tzgg);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteTzggByID(String tzggID) throws Exception {
		int id = 0;
		if(null!=tzggID&&!"".equals(tzggID)){		
			id = Integer.valueOf(tzggID);	
			tzggDAO.deleteTzggByID(id);
		}
	}
	

}
