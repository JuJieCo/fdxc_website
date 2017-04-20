package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.LxfsDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Lxfs;
import com.jinyu.fdxc.struts.bean.SysUser;

public class LxfsService {

	private LxfsDAO lxfsDAO;

	public void setLxfsDAO(LxfsDAO lxfsDAO) {
		this.lxfsDAO = lxfsDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Lxfs> queryDefaultLxfsList(Lxfs lxfs , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != lxfs && !"".equals(lxfs)) {
			objs[0] = lxfs.getLxfsID();
		}
		return lxfsDAO.queryLxfsList(objs,page,null);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Lxfs> queryLxfsList(Lxfs lxfs , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != lxfs && !"".equals(lxfs)) {
			objs[1] = lxfs.getLxfsTitle();
		}
		return lxfsDAO.queryLxfsList(objs,page,null);
	}
	
	
	/**
	 *查一条 
	 */
	public Lxfs findLxfsByID(String lxfsID) throws Exception {
		int id = 0;
			if(null!=lxfsID&&!"".equals(lxfsID)){		
				id = Integer.valueOf(lxfsID);			
			}
			SysUser user = lxfsDAO.findUserByID(id);
			Lxfs lxfs = lxfsDAO.findLxfsByID(id);
			lxfs.getSysUser().setLoginName(user.getLoginName());
			return lxfs;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyLxfs(Lxfs lxfs) throws Exception {
		if (null != lxfs.getLxfsID() && !"".equals(lxfs.getLxfsID())) {
			lxfsDAO.editLxfs(lxfs);
		} else {
			lxfsDAO.saveLxfs(lxfs);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteLxfsByID(String lxfsID) throws Exception {
		int id = 0;
		if(null!=lxfsID&&!"".equals(lxfsID)){		
			id = Integer.valueOf(lxfsID);	
			lxfsDAO.deleteLxfsByID(id);
		}
	}
	

}
