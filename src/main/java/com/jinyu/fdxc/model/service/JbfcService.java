package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.JbfcDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Jbfc;
import com.jinyu.fdxc.struts.bean.Jbfj;
import com.jinyu.fdxc.struts.bean.SysUser;

public class JbfcService {
	private JbfcDAO jbfcDAO;
	public void setJbfcDAO(JbfcDAO jbfcDAO) {
		this.jbfcDAO = jbfcDAO;
	}

	/**
	 *默认列表查询 
	 */ 
	public List<Jbfc> queryDefaultJbfcList(Jbfc jbfc , Page page) throws Exception {
		

		Object[] objs = new Object[2];
		if (null != jbfc && !"".equals(jbfc)) {
			objs[0] = jbfc.getJbfcID();
		}
		return jbfcDAO.queryJbfcList(objs,page);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<Jbfc> queryJbfcList(Jbfc jbfc , Page page) throws Exception {
		Object[] objs = new Object[2];
		if (null != jbfc && !"".equals(jbfc)) {
			objs[1] = jbfc.getJbfcTitle();
		}
		return jbfcDAO.queryJbfcList(objs,page);
	}
	
	
	
	/**
	 *查一条 
	 */
	public Jbfc findJbfcByID(String jbfcID) throws Exception {
		int id = 0;
			if(null!=jbfcID&&!"".equals(jbfcID)){		
				id = Integer.valueOf(jbfcID);			
			}
			SysUser user = jbfcDAO.findUserByID(id);
			Jbfc jbfc = jbfcDAO.findJbfcByID(id);
			jbfc.getSysUser().setLoginName(user.getLoginName());
			jbfc.setJbfjList(jbfcDAO.queryJbfjByJbIDList(id));
			return jbfc;
	}
	
	
	/**
	 *修改 新增 
	 */
	public void modifyJbfc(Jbfc jbfc , Integer jbfjID) throws Exception {
		if (null != jbfc.getJbfcID() && !"".equals(jbfc.getJbfcID())) {
			jbfcDAO.editJbfc(jbfc);
		} else {
			int jbfcID = jbfcDAO.saveJbfc(jbfc);
			if(null!=jbfjID){
				jbfcDAO.editJbfj(jbfcID, Integer.valueOf(jbfjID));
			}
		}
	}
	
	/**
	 *删除 
	 */
	public void deleteJbfcByID(String jbfcID) throws Exception {
		int id = 0;
		if(null!=jbfcID&&!"".equals(jbfcID)){		
			id = Integer.valueOf(jbfcID);	
			jbfcDAO.deleteJbfjByID(id);
			jbfcDAO.deleteJbfcByID(id);
		}
	}
	
	/**
	 *保存附件 
	 */
	public int saveJbfj(Jbfj jbfj) throws Exception {
		 return 	jbfcDAO.saveJbfj(jbfj);
	
	}
	

}
