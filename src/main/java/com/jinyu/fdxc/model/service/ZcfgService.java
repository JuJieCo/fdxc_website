package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.ZcfgDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Zcfg;

public class ZcfgService {

	private ZcfgDAO zcfgDAO;
	public void setZcfgDAO(ZcfgDAO zcfgDAO) {
		this.zcfgDAO = zcfgDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Zcfg> queryDefaultZcfgList(Zcfg zcfg, Page page ,String type) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != zcfg && !"".equals(zcfg)) {
			objs[0] = zcfg.getZcfgID();
		}
		return zcfgDAO.queryZcfgList(objs,page,type,null);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Zcfg> queryZcfgList(Zcfg zcfg, Page page ,String type) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != zcfg && !"".equals(zcfg)) {
			objs[1] = zcfg.getZcfgTitle();
		}
		return zcfgDAO.queryZcfgList(objs,page,type,null);
	}
	
	
	/**
	 *查一条 
	 */
	public Zcfg findZcfgByID(String zcfgID) throws Exception {
		int id = 0;
			if(null!=zcfgID&&!"".equals(zcfgID)){		
				id = Integer.valueOf(zcfgID);			
			}
			SysUser user = zcfgDAO.findUserByID(id);
			Zcfg zcfg= zcfgDAO.findZcfgByID(id);
			zcfg.getSysUser().setLoginName(user.getLoginName());
			return zcfg;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyZcfg(Zcfg zcfg) throws Exception {
		if (null != zcfg.getZcfgID() && !"".equals(zcfg.getZcfgID())) {
			zcfgDAO.editZcfg(zcfg);
		} else {
			zcfgDAO.saveZcfg(zcfg);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteZcfgByID(String zcfgID) throws Exception {
		int id = 0;
		if(null!=zcfgID&&!"".equals(zcfgID)){		
			id = Integer.valueOf(zcfgID);	
			zcfgDAO.deleteZcfgByID(id);
		}
	}
	

}
