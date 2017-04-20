package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.NdjhDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Ndjh;
import com.jinyu.fdxc.struts.bean.SysUser;

public class NdjhService {

	private NdjhDAO ndjhDAO;
	public void setndjhDAO(NdjhDAO ndjhDAO) {
		this.ndjhDAO = ndjhDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Ndjh> queryDefaultNdjhList(Ndjh ndjh, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != ndjh && !"".equals(ndjh)) {
			objs[0] = ndjh.getNdjhID();
		}
		return ndjhDAO.queryNdjhList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Ndjh> queryNdjhList(Ndjh ndjh, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != ndjh && !"".equals(ndjh)) {
			objs[1] = ndjh.getNdjhTitle();
		}
		return ndjhDAO.queryNdjhList(objs,page);
	}
	
	
	/**
	 *查一条 
	 */
	public Ndjh findNdjhByID(String ndjhID) throws Exception {
		int id = 0;
			if(null!=ndjhID&&!"".equals(ndjhID)){		
				id = Integer.valueOf(ndjhID);			
			}
			SysUser user = ndjhDAO.findUserByID(id);
			Ndjh ndjh= ndjhDAO.findNdjhByID(id);
			ndjh.getSysUser().setLoginName(user.getLoginName());
			return ndjh;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyNdjh(Ndjh ndjh) throws Exception {
		if (null != ndjh.getNdjhID() && !"".equals(ndjh.getNdjhID())) {
			ndjhDAO.editNdjh(ndjh);
		} else {
			ndjhDAO.saveNdjh(ndjh);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteNdjhByID(String ndjhID) throws Exception {
		int id = 0;
		if(null!=ndjhID&&!"".equals(ndjhID)){		
			id = Integer.valueOf(ndjhID);	
			ndjhDAO.deleteNdjhByID(id);
		}
	}
	

}
