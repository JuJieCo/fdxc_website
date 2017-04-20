package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.HdryDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Hdry;
import com.jinyu.fdxc.struts.bean.SysUser;

public class HdryService {
	private HdryDAO hdryDAO;

	public void setHdryDAO(HdryDAO hdryDAO) {
		this.hdryDAO = hdryDAO;
	}
	/**
	 *默认列表查询 hdry
	 */ 
	public List<Hdry> queryDefaultHdryList(Hdry hdry , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != hdry && !"".equals(hdry)) {
			objs[0] = hdry.getHdryID();
		}
		return hdryDAO.queryHdryList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Hdry> queryHdryList(Hdry hdry , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != hdry && !"".equals(hdry)) {
			objs[1] = hdry.getHdryTitle();
		}
		return hdryDAO.queryHdryList(objs,page);
	}
	
	
	/**
	 *查一条 
	 */
	public Hdry findHdryByID(String hdryID) throws Exception {
		int id = 0;
			if(null!=hdryID&&!"".equals(hdryID)){		
				id = Integer.valueOf(hdryID);			
			}
			SysUser user = hdryDAO.findUserByID(id);
			Hdry hdry = hdryDAO.findHdryByID(id);
			hdry.getSysUser().setLoginName(user.getLoginName());
			return hdry;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyHdry(Hdry hdry, Integer hdryID) throws Exception {
		if (null != hdry.getHdryID() && !"".equals(hdry.getHdryID())) {
			hdryDAO.editHdry(hdry);
		} else {
			if(null!=hdryID&&!"".equals(hdryID)){//说明已经有附件了
				int id = Integer.valueOf(hdryID); //获得已经保存的附件的ID
				hdry.setHdryID(id);
					hdryDAO.editAsFJ(hdry); //保存 = 修改已经上传附件件的记录
			}else{//如果没有附件 直接保存了
				hdryDAO.saveHdry(hdry);
			}
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteHdryByID(String hdryID) throws Exception {
		int id = 0;
		if(null!=hdryID&&!"".equals(hdryID)){		
			id = Integer.valueOf(hdryID);	
			hdryDAO.deleteHdryByID(id);
		}
	}
	
	
	/**
	 *保存附件 
	 */
	public int saveFJ(Hdry hdry) throws Exception {
		 return 	hdryDAO.saveFJ(hdry);
	
	}

}
