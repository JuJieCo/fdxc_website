package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.FzghDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Fzgh;
import com.jinyu.fdxc.struts.bean.SysUser;

public class FzghService {

	private FzghDAO fzghDAO;
	public void setFzghDAO(FzghDAO fzghDAO) {
		this.fzghDAO = fzghDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Fzgh> queryDefaultFzghList(Fzgh fzgh, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != fzgh && !"".equals(fzgh)) {
			objs[0] = fzgh.getFzghID();
		}
		return fzghDAO.queryFzghList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Fzgh> queryFzghList(Fzgh fzgh, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != fzgh && !"".equals(fzgh)) {
			objs[1] = fzgh.getFzghTitle();
		}
		return fzghDAO.queryFzghList(objs,page);
	}
	
	
	/**
	 *查一条 
	 */
	public Fzgh findFzghByID(String fzghID) throws Exception {
		int id = 0;
			if(null!=fzghID&&!"".equals(fzghID)){		
				id = Integer.valueOf(fzghID);			
			}
			SysUser user = fzghDAO.findUserByID(id);
			Fzgh fzgh= fzghDAO.findFzghByID(id);
			fzgh.getSysUser().setLoginName(user.getLoginName());
			return fzgh;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyFzgh(Fzgh fzgh) throws Exception {
		if (null != fzgh.getFzghID() && !"".equals(fzgh.getFzghID())) {
			fzghDAO.editFzgh(fzgh);
		} else {
			fzghDAO.saveFzgh(fzgh);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteFzghByID(String fzghID) throws Exception {
		int id = 0;
		if(null!=fzghID&&!"".equals(fzghID)){		
			id = Integer.valueOf(fzghID);	
			fzghDAO.deleteFzghByID(id);
		}
	}
	

}
