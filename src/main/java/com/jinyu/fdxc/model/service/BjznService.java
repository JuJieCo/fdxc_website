package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.BjznDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Bjzn;
import com.jinyu.fdxc.struts.bean.SysUser;

public class BjznService {

	private BjznDAO bjznDAO;

	public void setBjznDAO(BjznDAO bjznDAO) {
		this.bjznDAO = bjznDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Bjzn> queryDefaultBjznList(Bjzn bjzn , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != bjzn && !"".equals(bjzn)) {
			objs[0] = bjzn.getBjznID();
		}
		return bjznDAO.queryBjznList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Bjzn> queryBjznList(Bjzn bjzn , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != bjzn && !"".equals(bjzn)) {
			objs[1] = bjzn.getBjznTitle();
		}
		return bjznDAO.queryBjznList(objs,page);
	}
	
	
	/**
	 *查一条 
	 */
	public Bjzn findBjznByID(String bjznID) throws Exception {
		int id = 0;
			if(null!=bjznID&&!"".equals(bjznID)){		
				id = Integer.valueOf(bjznID);			
			}
			SysUser user = bjznDAO.findUserByID(id);
			Bjzn bjzn = bjznDAO.findBjznByID(id);
			bjzn.getSysUser().setLoginName(user.getLoginName());
			return bjzn;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyBjzn(Bjzn bjzn) throws Exception {
		if (null != bjzn.getBjznID() && !"".equals(bjzn.getBjznID())) {
			bjznDAO.editBjzn(bjzn);
		} else {
			bjznDAO.saveBjzn(bjzn);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteBjznByID(String bjznID) throws Exception {
		int id = 0;
		if(null!=bjznID&&!"".equals(bjznID)){		
			id = Integer.valueOf(bjznID);	
			bjznDAO.deleteBjznByID(id);
		}
	}
	

}
