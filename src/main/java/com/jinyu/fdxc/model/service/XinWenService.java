package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.XinWenDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.XinWen;
import com.jinyu.fdxc.struts.bean.Xwfj;

public class XinWenService {
	private XinWenDAO xinWenDAO;

	public void setXinWenDAO(XinWenDAO xinWenDAO) {
		this.xinWenDAO = xinWenDAO;
	}
	
	
	
	/**
	 *默认列表查询 
	 */ 
	public List<XinWen> queryDefaultXinWenrList(XinWen xinwen , Page page , String type) throws Exception {
		
		int xinWenType = 0;
		if(null!=type&&!"".equals(type)){
			xinWenType = Integer.valueOf(type);
		}
		Object[] objs = new Object[2];
		if (null != xinwen && !"".equals(xinwen)) {
			objs[0] = xinwen.getXinwenID();
		}
		return xinWenDAO.queryXinWenList(objs,page,xinWenType,null);
	}
	
	
	/**
	 *列表查询 
	 */ 
	public List<XinWen> queryXinWenList(XinWen xinWen , Page page, String type) throws Exception {
		int xinWenType = 0;
		if(null!=type&&!"".equals(type)){
			xinWenType = Integer.valueOf(type);
		}
		Object[] objs = new Object[2];
		if (null != xinWen && !"".equals(xinWen)) {
			objs[1] = xinWen.getXinwenTitle();
		}
		return xinWenDAO.queryXinWenList(objs,page,xinWenType,null);
	}
	
	
	
	/**
	 *查一条 
	 */
	public XinWen findXinWenByID(String xinWenID) throws Exception {
		int id = 0;
			if(null!=xinWenID&&!"".equals(xinWenID)){		
				id = Integer.valueOf(xinWenID);			
			}
			SysUser user = xinWenDAO.findUserByID(id);
			XinWen xinwen = xinWenDAO.findXinWenByID(id);
			xinwen.getSysUser().setLoginName(user.getLoginName());
			xinwen.setXwfjList(xinWenDAO.queryXwfjByXwIDList(id));
			return xinwen;
	}
	
	
	
	/**
	 *修改 新增 
	 */
	public void modifyXinWen(XinWen xinWen , Integer xwfjID) throws Exception {
		if (null != xinWen.getXinwenID() && !"".equals(xinWen.getXinwenID())) {
			xinWenDAO.editXinWen(xinWen);
		} else {
				int xinwenID = xinWenDAO.saveXinWen(xinWen);
				if(null!=xwfjID){
					xinWenDAO.editXwfj(xinwenID, Integer.valueOf(xwfjID));
				}
			
		}
	}
	
	
	/**
	 *删除 
	 */
	public void deleteXinWenByID(String xinWenID) throws Exception {
		int id = 0;
		if(null!=xinWenID&&!"".equals(xinWenID)){		
			id = Integer.valueOf(xinWenID);	
			xinWenDAO.deleteXwfjByID(id);
			xinWenDAO.deleteXinWenByID(id);
		}
	}
	
	
	/**
	 *保存附件 
	 */
	public int saveXwfj(Xwfj xwfj) throws Exception {
		 return 	xinWenDAO.saveXwfj(xwfj);
	
	}

}
