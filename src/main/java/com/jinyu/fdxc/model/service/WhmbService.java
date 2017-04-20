package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.WhmbDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Whmb;

public class WhmbService {

	private WhmbDAO whmbDAO;
	public void setWhmbDAO(WhmbDAO whmbDAO) {
		this.whmbDAO = whmbDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Whmb> queryDefaultWhmbList(Whmb whmb, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != whmb && !"".equals(whmb)) {
			objs[0] = whmb.getWhmbID();
		}
		return whmbDAO.queryWhmbList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Whmb> queryWhmbList(Whmb whmb, Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != whmb && !"".equals(whmb)) {
			objs[1] = whmb.getWhmbTitle();
		}
		return whmbDAO.queryWhmbList(objs,page);
	}
	
	
	/**
	 *查一条 
	 */
	public Whmb findWhmbByID(String whmbID) throws Exception {
		int id = 0;
			if(null!=whmbID&&!"".equals(whmbID)){		
				id = Integer.valueOf(whmbID);			
			}
			SysUser user = whmbDAO.findUserByID(id);
			Whmb whmb= whmbDAO.findWhmbByID(id);
			whmb.getSysUser().setLoginName(user.getLoginName());
			return whmb;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyWhmb(Whmb whmb) throws Exception {
		if (null != whmb.getWhmbID() && !"".equals(whmb.getWhmbID())) {
			whmbDAO.editWhmb(whmb);
		} else {
			whmbDAO.saveWhmb(whmb);
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteWhmbByID(String whmbID) throws Exception {
		int id = 0;
		if(null!=whmbID&&!"".equals(whmbID)){		
			id = Integer.valueOf(whmbID);	
			whmbDAO.deleteWhmbByID(id);
		}
	}
	

}
