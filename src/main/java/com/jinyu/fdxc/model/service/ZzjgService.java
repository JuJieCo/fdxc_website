package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.ZzjgDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Zzjg;



public class ZzjgService {

	private ZzjgDAO zzjgDAO;

	public void setZzjgDAO(ZzjgDAO zzjgDAO) {
		this.zzjgDAO = zzjgDAO;
	}

	/**
	 *默认列表查询 
	 */ 
	public List<Zzjg> queryDefaultZzjgList(Zzjg zzjg , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != zzjg && !"".equals(zzjg)) {
			objs[0] = zzjg.getZzjgID();
		}
		return zzjgDAO.queryZzjgList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Zzjg> queryZzjgList(Zzjg zzjg , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != zzjg && !"".equals(zzjg)) {
			objs[1] = zzjg.getZzjgTitle();
		}
		return zzjgDAO.queryZzjgList(objs,page);
	}
	
	
	/**
	 *查一条 
	 */
	public Zzjg findZzjgByID(String zzjgID) throws Exception {
		int id = 0;
			if(null!=zzjgID&&!"".equals(zzjgID)){		
				id = Integer.valueOf(zzjgID);			
			}
			SysUser user = zzjgDAO.findUserByID(id);
			Zzjg zzjg = zzjgDAO.findZzjgByID(id);
			zzjg.getSysUser().setLoginName(user.getLoginName());
			return zzjg;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyZzjg(Zzjg zzjg, Integer zzjgID) throws Exception {
		if (null != zzjg.getZzjgID() && !"".equals(zzjg.getZzjgID())) {
			zzjgDAO.editZzjg(zzjg);
		} else {
			if(null!=zzjgID&&!"".equals(zzjgID)){//说明已经有附件了
				int id = Integer.valueOf(zzjgID); //获得已经保存的附件的ID
					zzjg.setZzjgID(id);
					zzjgDAO.editAsFJ(zzjg); //保存 = 修改已经上传附件件的记录
			}else{//如果没有附件 直接保存了
				zzjgDAO.saveZzjg(zzjg);
			}
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteZzjgByID(String zzjgID) throws Exception {
		int id = 0;
		if(null!=zzjgID&&!"".equals(zzjgID)){		
			id = Integer.valueOf(zzjgID);	
			zzjgDAO.deleteZzjgByID(id);
		}
	}
	
	
	/**
	 *保存附件 
	 */
	public int saveFJ(Zzjg zzjg) throws Exception {
		 return 	zzjgDAO.saveFJ(zzjg);
	
	}
	
}
