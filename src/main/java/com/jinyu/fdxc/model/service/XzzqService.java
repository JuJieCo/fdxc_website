package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.XzzqDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Xzzq;

public class XzzqService {
	private XzzqDAO xzzqDAO;

	public void setXzzqDAO(XzzqDAO xzzqDAO) {
		this.xzzqDAO = xzzqDAO;
	}

	/**
	 *默认列表查询 
	 */ 
	public List<Xzzq> queryDefaultXzzqList(Xzzq xzzq , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != xzzq && !"".equals(xzzq)) {
			objs[0] = xzzq.getXzzqID();
		}
		return xzzqDAO.queryXzzqList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Xzzq> queryXzzqList(Xzzq xzzq , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != xzzq && !"".equals(xzzq)) {
			objs[1] = xzzq.getXzzqTitle();
		}
		return xzzqDAO.queryXzzqList(objs,page);
	}
	
	
	/**
	 *查一条 
	 */
	public Xzzq findXzzqByID(String xzzqID) throws Exception {
		int id = 0;
			if(null!=xzzqID&&!"".equals(xzzqID)){		
				id = Integer.valueOf(xzzqID);			
			}
			SysUser user = xzzqDAO.findUserByID(id);
			Xzzq xzzq = xzzqDAO.findXzzqByID(id);
			xzzq.getSysUser().setLoginName(user.getLoginName());
			return xzzq;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyXzzq(Xzzq xzzq, Integer xzzqID) throws Exception {
		if (null != xzzq.getXzzqID() && !"".equals(xzzq.getXzzqID())) {
			xzzqDAO.editXzzq(xzzq);
		} else {
			if(null!=xzzqID&&!"".equals(xzzqID)){//说明已经有附件了
				int id = Integer.valueOf(xzzqID); //获得已经保存的附件的ID
				xzzq.setXzzqID(id);
					xzzqDAO.editAsFJ(xzzq); //保存 = 修改已经上传附件件的记录
			}else{//如果没有附件 直接保存了
				xzzqDAO.saveXzzq(xzzq);
			}
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteXzzqByID(String xzzqID) throws Exception {
		int id = 0;
		if(null!=xzzqID&&!"".equals(xzzqID)){		
			id = Integer.valueOf(xzzqID);	
			xzzqDAO.deleteXzzqByID(id);
		}
	}
	
	
	/**
	 *保存附件 
	 */
	public int saveFJ(Xzzq xzzq) throws Exception {
		 return xzzqDAO.saveFJ(xzzq);
	
	}

}
