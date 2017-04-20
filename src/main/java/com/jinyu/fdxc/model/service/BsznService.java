package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.BsznDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Bszn;
import com.jinyu.fdxc.struts.bean.SysUser;

public class BsznService {

	private BsznDAO bsznDAO;
	public void setBsznDAO(BsznDAO bsznDAO) {
		this.bsznDAO = bsznDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Bszn> queryDefaultBsznList(Bszn bszn, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != bszn && !"".equals(bszn)) {
			objs[0] = bszn.getBsznID();
		}
		return bsznDAO.queryBsznList(objs,page,null);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Bszn> queryBsznList(Bszn bszn, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != bszn && !"".equals(bszn)) {
			objs[1] = bszn.getBsznTitle();
		}
		return bsznDAO.queryBsznList(objs,page,null);
	}
	
	
	/**
	 *查一条 
	 */
	public Bszn findBsznByID(String bsznID) throws Exception {
		int id = 0;
			if(null!=bsznID&&!"".equals(bsznID)){		
				id = Integer.valueOf(bsznID);			
			}
			SysUser user = bsznDAO.findUserByID(id);
			Bszn bszn= bsznDAO.findBsznByID(id);
			bszn.getSysUser().setLoginName(user.getLoginName());
			return bszn;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyBszn(Bszn bszn) throws Exception {
		if (null != bszn.getBsznID() && !"".equals(bszn.getBsznID())) {
			bsznDAO.editBszn(bszn);
		} else {
			bsznDAO.saveBszn(bszn);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteBsznByID(String bsznID) throws Exception {
		int id = 0;
		if(null!=bsznID&&!"".equals(bsznID)){		
			id = Integer.valueOf(bsznID);	
			bsznDAO.deleteBsznByID(id);
		}
	}
	

}
