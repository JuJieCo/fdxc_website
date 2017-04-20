package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.RsxxDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Rsxx;
import com.jinyu.fdxc.struts.bean.SysUser;

public class RsxxService {

	private RsxxDAO rsxxDAO;
	public void setRsxxDAO(RsxxDAO rsxxDAO) {
		this.rsxxDAO = rsxxDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Rsxx> queryDefaultRsxxList(Rsxx rsxx, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != rsxx && !"".equals(rsxx)) {
			objs[0] = rsxx.getRsxxID();
		}
		return rsxxDAO.queryRsxxList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Rsxx> queryRsxxList(Rsxx rsxx, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != rsxx && !"".equals(rsxx)) {
			objs[1] = rsxx.getRsxxTitle();
		}
		return rsxxDAO.queryRsxxList(objs,page);
	}
	
	
	/**
	 *查一条 
	 */
	public Rsxx findRsxxByID(String rsxxID) throws Exception {
		int id = 0;
			if(null!=rsxxID&&!"".equals(rsxxID)){		
				id = Integer.valueOf(rsxxID);			
			}
			SysUser user = rsxxDAO.findUserByID(id);
			Rsxx rsxx= rsxxDAO.findRsxxByID(id);
			rsxx.getSysUser().setLoginName(user.getLoginName());
			return rsxx;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyRsxx(Rsxx rsxx) throws Exception {
		if (null != rsxx.getRsxxID() && !"".equals(rsxx.getRsxxID())) {
			rsxxDAO.editRsxx(rsxx);
		} else {
			rsxxDAO.saveRsxx(rsxx);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteRsxxByID(String rsxxID) throws Exception {
		int id = 0;
		if(null!=rsxxID&&!"".equals(rsxxID)){		
			id = Integer.valueOf(rsxxID);	
			rsxxDAO.deleteRsxxByID(id);
		}
	}
	

}
