package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.GkfwDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Gkfw;
import com.jinyu.fdxc.struts.bean.SysUser;

public class GkfwService {

	private GkfwDAO gkfwDAO;

	public void setGkfwDAO(GkfwDAO gkfwDAO) {
		this.gkfwDAO = gkfwDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Gkfw> queryDefaultGkfwList(Gkfw gkfw , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != gkfw && !"".equals(gkfw)) {
			objs[0] = gkfw.getGkfwID();
		}
		return gkfwDAO.queryGkfwList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Gkfw> queryGkfwList(Gkfw gkfw , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != gkfw && !"".equals(gkfw)) {
			objs[1] = gkfw.getGkfwTitle();
		}
		return gkfwDAO.queryGkfwList(objs,page);
	}
	
	
	/**
	 *查一条 
	 */
	public Gkfw findGkfwByID(String GkfwID) throws Exception {
		int id = 0;
			if(null!=GkfwID&&!"".equals(GkfwID)){		
				id = Integer.valueOf(GkfwID);			
			}
			SysUser user = gkfwDAO.findUserByID(id);
			Gkfw gkfw = gkfwDAO.findGkfwByID(id);
			gkfw.getSysUser().setLoginName(user.getLoginName());
			return gkfw;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyGkfw(Gkfw gkfw) throws Exception {
		if (null != gkfw.getGkfwID() && !"".equals(gkfw.getGkfwID())) {
			gkfwDAO.editGkfw(gkfw);
		} else {
			gkfwDAO.saveGkfw(gkfw);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteGkfwByID(String GkfwID) throws Exception {
		int id = 0;
		if(null!=GkfwID&&!"".equals(GkfwID)){		
			id = Integer.valueOf(GkfwID);	
			gkfwDAO.deleteGkfwByID(id);
		}
	}
	

}
