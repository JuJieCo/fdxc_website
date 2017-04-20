package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.WjfbDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Wjfb;



public class WjfbService {

	private WjfbDAO wjfbDAO;
	public void setWjfbDAO(WjfbDAO wjfbDAO) {
		this.wjfbDAO = wjfbDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Wjfb> queryDefaultWjfbList(Wjfb wjfb , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != wjfb && !"".equals(wjfb)) {
			objs[0] = wjfb.getWjfbID();
		}
		return wjfbDAO.queryWjfbList(objs,page,null);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Wjfb> queryWjfbList(Wjfb wjfb , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != wjfb && !"".equals(wjfb)) {
			objs[1] = wjfb.getWjfbTitle();
		}
		return wjfbDAO.queryWjfbList(objs,page,null);
	}
	
	
	/**
	 *查一条 
	 */
	public Wjfb findWjfbByID(String wjfbID) throws Exception {
		int id = 0;
			if(null!=wjfbID&&!"".equals(wjfbID)){		
				id = Integer.valueOf(wjfbID);			
			}
			SysUser user = wjfbDAO.findUserByID(id);
			Wjfb wjfb = wjfbDAO.findWjfbByID(id);
			wjfb.getSysUser().setLoginName(user.getLoginName());
			return wjfb;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyWjfb(Wjfb wjfb, Integer wjfbID) throws Exception {
		if (null != wjfb.getWjfbID() && !"".equals(wjfb.getWjfbID())) {
			wjfbDAO.editWjfb(wjfb);
		} else {
			if(null!=wjfbID&&!"".equals(wjfbID)){//说明已经有附件了
				int id = Integer.valueOf(wjfbID); //获得已经保存的附件的ID
				wjfb.setWjfbID(id);
					wjfbDAO.editAsFJ(wjfb); //保存 = 修改已经上传附件件的记录
			}else{//如果没有附件 直接保存了
				wjfbDAO.saveWjfb(wjfb);
			}
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteWjfbByID(String wjfbID) throws Exception {
		int id = 0;
		if(null!=wjfbID&&!"".equals(wjfbID)){		
			id = Integer.valueOf(wjfbID);	
			wjfbDAO.deleteWjfbByID(id);
		}
	}
	
	
	/**
	 *保存附件 
	 */
	public int saveFJ(Wjfb wjfb) throws Exception {
		 return 	wjfbDAO.saveFJ(wjfb);
	
	}
	
}
