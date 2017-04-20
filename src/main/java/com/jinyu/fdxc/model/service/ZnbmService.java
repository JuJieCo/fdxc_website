package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.ZnbmDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Znbm;
import com.jinyu.fdxc.struts.bean.SysUser;

public class ZnbmService {

	private ZnbmDAO znbmDAO;

	public void setZnbmDAO(ZnbmDAO znbmDAO) {
		this.znbmDAO = znbmDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Znbm> queryDefaultZnbmList(Znbm znbm , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != znbm && !"".equals(znbm)) {
			objs[0] = znbm.getZnbmID();
		}
		return znbmDAO.queryZnbmList(objs,page,null);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Znbm> queryZnbmList(Znbm znbm , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != znbm && !"".equals(znbm)) {
			objs[1] = znbm.getZnbmTitle();
		}
		return znbmDAO.queryZnbmList(objs,page,null);
	}
	
	
	/**
	 *查一条 
	 */
	public Znbm findZnbmByID(String znbmID) throws Exception {
		int id = 0;
			if(null!=znbmID&&!"".equals(znbmID)){		
				id = Integer.valueOf(znbmID);			
			}
			SysUser user = znbmDAO.findUserByID(id);
			Znbm znbm = znbmDAO.findZnbmByID(id);
			znbm.getUser().setLoginName(user.getLoginName());
			return znbm;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyZnbm(Znbm znbm) throws Exception {
		if (null != znbm.getZnbmID() && !"".equals(znbm.getZnbmID())) {
			znbmDAO.editZnbm(znbm);
		} else {
			znbmDAO.saveZnbm(znbm);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteZnbmByID(String znbmID) throws Exception {
		int id = 0;
		if(null!=znbmID&&!"".equals(znbmID)){		
			id = Integer.valueOf(znbmID);	
			znbmDAO.deleteZnbmByID(id);
		}
	}
	

}
