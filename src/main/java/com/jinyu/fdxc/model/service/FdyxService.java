package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.FdyxDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Fdfj;
import com.jinyu.fdxc.struts.bean.Fdyx;
import com.jinyu.fdxc.struts.bean.SysUser;

public class FdyxService {
	private FdyxDAO fdyxDAO;
	public void setFdyxDAO(FdyxDAO fdyxDAO) {
		this.fdyxDAO = fdyxDAO;
	}


	/**
	 *默认列表查询 
	 */ 
	public List<Fdyx> queryDefaultFdyxList(Fdyx fdyx , Page page) throws Exception {
		Object[] objs = new Object[2];
		if (null != fdyx && !"".equals(fdyx)) {
			objs[0] = fdyx.getFdyxID();
		}
		return fdyxDAO.queryFdyxList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Fdyx> queryFdyxList(Fdyx fdyx , Page page) throws Exception {
		Object[] objs = new Object[2];
		if (null != fdyx && !"".equals(fdyx)) {
			objs[1] = fdyx.getFdyxTitle();
		}
		return fdyxDAO.queryFdyxList(objs,page);
	}
	
	
	
	
	/**
	 *查一条 
	 */
	public Fdyx findFdyxByID(String fdyxID) throws Exception {
		int id = 0;
			if(null!=fdyxID&&!"".equals(fdyxID)){		
				id = Integer.valueOf(fdyxID);			
			}
			SysUser user = fdyxDAO.findUserByID(id);
			Fdyx fdyx = fdyxDAO.findFdyxByID(id);
			fdyx.getSysUser().setLoginName(user.getLoginName());
			fdyx.setFdfjList(fdyxDAO.queryFdfjByFdIDList(id));
			return fdyx;
	}
	
	
	/**
	 *修改 新增 
	 */
	public void modifyFdyx(Fdyx fdyx , Integer fdfjID) throws Exception {
		if (null != fdyx.getFdyxID() && !"".equals(fdyx.getFdyxID())) {
			fdyxDAO.editFdyx(fdyx);
		} else {
				int fdyxID = fdyxDAO.saveFdyx(fdyx);
				if(null!=fdfjID){
					fdyxDAO.editFdfj(fdyxID, Integer.valueOf(fdfjID));
				}	
		}
	}
	
	/**
	 *删除 
	 */
	public void deleteFdyxByID(String fdyxID) throws Exception {
		int id = 0;
		if(null!=fdyxID&&!"".equals(fdyxID)){		
			id = Integer.valueOf(fdyxID);	
			fdyxDAO.deleteFdfjByID(id);
			fdyxDAO.deleteFdyxByID(id);
		}
	}
	
	/**
	 *保存附件 
	 */
	public int saveFdfj(Fdfj fdfj) throws Exception {
		 return 	fdyxDAO.saveFdfj(fdfj);
	
	}
	

}
