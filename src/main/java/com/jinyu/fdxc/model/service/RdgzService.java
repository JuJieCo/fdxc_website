package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.RdgzDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Rdgz;
import com.jinyu.fdxc.struts.bean.SysUser;

public class RdgzService {

	private RdgzDAO rdgzDAO;
	public void setRdgzDAO(RdgzDAO rdgzDAO) {
		this.rdgzDAO = rdgzDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Rdgz> queryDefaultRdgzList(Rdgz rdgz, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != rdgz && !"".equals(rdgz)) {
			objs[0] = rdgz.getRdgzID();
		}
		return rdgzDAO.queryRdgzList(objs,page,null);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Rdgz> queryRdgzList(Rdgz rdgz, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != rdgz && !"".equals(rdgz)) {
			objs[1] = rdgz.getRdgzTitle();
		}
		return rdgzDAO.queryRdgzList(objs,page,null);
	}
	
	
	/**
	 *查一条 
	 */
	public Rdgz findRdgzByID(String rdgzID) throws Exception {
		int id = 0;
			if(null!=rdgzID&&!"".equals(rdgzID)){		
				id = Integer.valueOf(rdgzID);			
			}
			SysUser user = rdgzDAO.findUserByID(id);
			Rdgz rdgz= rdgzDAO.findRdgzByID(id);
			rdgz.getSysUser().setLoginName(user.getLoginName());
			return rdgz;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyRdgz(Rdgz rdgz) throws Exception {
		if (null != rdgz.getRdgzID() && !"".equals(rdgz.getRdgzID())) {
			rdgzDAO.editRdgz(rdgz);
		} else {
			rdgzDAO.saveRdgz(rdgz);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteRdgzByID(String rdgzID) throws Exception {
		int id = 0;
		if(null!=rdgzID&&!"".equals(rdgzID)){		
			id = Integer.valueOf(rdgzID);	
			rdgzDAO.deleteRdgzByID(id);
		}
	}
	

}
