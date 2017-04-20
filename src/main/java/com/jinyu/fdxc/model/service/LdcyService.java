package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.LdcyDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Ldcy;
import com.jinyu.fdxc.struts.bean.SysUser;



public class LdcyService {

	private LdcyDAO ldcyDAO;

	public void setLdcyDAO(LdcyDAO ldcyDAO) {
		this.ldcyDAO = ldcyDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Ldcy> queryDefaultLdcyList(Ldcy ldcy , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != ldcy && !"".equals(ldcy)) {
			objs[0] = ldcy.getLdcyID();
		}
		return ldcyDAO.queryLdcyList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Ldcy> queryLdcyList(Ldcy ldcy , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != ldcy && !"".equals(ldcy)) {
			objs[1] = ldcy.getLdcyTitle();
		}
		return ldcyDAO.queryLdcyList(objs,page);
	}
	
	
	/**
	 *查一条 
	 */
	public Ldcy findLdcyByID(String ldcyID) throws Exception {
		int id = 0;
			if(null!=ldcyID&&!"".equals(ldcyID)){		
				id = Integer.valueOf(ldcyID);			
			}
			SysUser user = ldcyDAO.findUserByID(id);
			Ldcy ldcy = ldcyDAO.findLdcyByID(id);
			ldcy.getSysUser().setLoginName(user.getLoginName());
			return ldcy;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyLdcy(Ldcy ldcy, Integer ldcyID) throws Exception {
		if (null != ldcy.getLdcyID() && !"".equals(ldcy.getLdcyID())) {
			ldcyDAO.editLdcy(ldcy);
		} else {
			if(null!=ldcyID&&!"".equals(ldcyID)){//说明已经有附件了
				int id = Integer.valueOf(ldcyID); //获得已经保存的附件的ID
					ldcy.setLdcyID(id);
					ldcyDAO.editAsFJ(ldcy); //保存 = 修改已经上传附件件的记录
			}else{//如果没有附件 直接保存了
				ldcyDAO.saveLdcy(ldcy);
			}
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteLdcyByID(String ldcyID) throws Exception {
		int id = 0;
		if(null!=ldcyID&&!"".equals(ldcyID)){		
			id = Integer.valueOf(ldcyID);	
			ldcyDAO.deleteLdcyByID(id);
		}
	}
	
	
	/**
	 *保存附件 
	 */
	public int saveFJ(Ldcy ldcy) throws Exception {
		 return 	ldcyDAO.saveFJ(ldcy);
	
	}
	
}
