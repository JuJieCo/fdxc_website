package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.DsjyDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Dsjy;
import com.jinyu.fdxc.struts.bean.SysUser;

public class DsjyService {


	private DsjyDAO dsjyDAO;

	public void setDsjyDAO(DsjyDAO dsjyDAO) {
		this.dsjyDAO = dsjyDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Dsjy> queryDefaultDsjyList(Dsjy dsjy , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != dsjy && !"".equals(dsjy)) {
			objs[0] = dsjy.getDsjyID();
		}
		return dsjyDAO.queryDsjyList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Dsjy> queryDsjyList(Dsjy dsjy , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != dsjy && !"".equals(dsjy)) {
			objs[1] = dsjy.getDsjyTitle();
		}
		return dsjyDAO.queryDsjyList(objs,page);
	}
	
	
	/**
	 *查一条 
	 */
	public Dsjy findDsjyByID(String dsjyID) throws Exception {
		int id = 0;
			if(null!=dsjyID&&!"".equals(dsjyID)){		
				id = Integer.valueOf(dsjyID);			
			}
			SysUser user = dsjyDAO.findUserByID(id);
			Dsjy dsjy = dsjyDAO.findDsjyByID(id);
			dsjy.getSysUser().setLoginName(user.getLoginName());
			return dsjy;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyDsjy(Dsjy dsjy) throws Exception {
		if (null != dsjy.getDsjyID() && !"".equals(dsjy.getDsjyID())) {
			dsjyDAO.editDsjy(dsjy);
		} else {
			dsjyDAO.saveDsjy(dsjy);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteDsjyByID(String dsjyID) throws Exception {
		int id = 0;
		if(null!=dsjyID&&!"".equals(dsjyID)){		
			id = Integer.valueOf(dsjyID);	
			dsjyDAO.deleteDsjyByID(id);
		}
	}
	

}
