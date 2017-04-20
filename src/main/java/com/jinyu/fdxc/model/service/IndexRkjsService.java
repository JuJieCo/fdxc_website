package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.BsznDAO;
import com.jinyu.fdxc.model.dao.LxfsDAO;
import com.jinyu.fdxc.model.dao.RdgzDAO;
import com.jinyu.fdxc.model.dao.TzggDAO;
import com.jinyu.fdxc.model.dao.WjfbDAO;
import com.jinyu.fdxc.model.dao.XinWenDAO;
import com.jinyu.fdxc.model.dao.ZcfgDAO;
import com.jinyu.fdxc.model.dao.ZnbmDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Bszn;
import com.jinyu.fdxc.struts.bean.Lxfs;
import com.jinyu.fdxc.struts.bean.Rdgz;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Tzgg;
import com.jinyu.fdxc.struts.bean.Wjfb;
import com.jinyu.fdxc.struts.bean.XinWen;
import com.jinyu.fdxc.struts.bean.Xwfj;
import com.jinyu.fdxc.struts.bean.Zcfg;
import com.jinyu.fdxc.struts.bean.Znbm;

public class IndexRkjsService {
	
	private XinWenDAO xinWenDAO;
	private TzggDAO tzggDAO;
	private WjfbDAO wjfbDAO;
	private ZcfgDAO zcfgDAO;
	private BsznDAO bsznDAO;
	private RdgzDAO rdgzDAO;
	private LxfsDAO lxfsDAO;
	private ZnbmDAO znbmDAO;
	public void setXinWenDAO(XinWenDAO xinWenDAO) {
		this.xinWenDAO = xinWenDAO;
	}
	public void setTzggDAO(TzggDAO tzggDAO) {
		this.tzggDAO = tzggDAO;
	}
	public void setWjfbDAO(WjfbDAO wjfbDAO) {
		this.wjfbDAO = wjfbDAO;
	}
	public void setZcfgDAO(ZcfgDAO zcfgDAO) {
		this.zcfgDAO = zcfgDAO;
	}
	public void setBsznDAO(BsznDAO bsznDAO) {
		this.bsznDAO = bsznDAO;
	}
	public void setRdgzDAO(RdgzDAO rdgzDAO) {
		this.rdgzDAO = rdgzDAO;
	}
	public void setLxfsDAO(LxfsDAO lxfsDAO) {
		this.lxfsDAO = lxfsDAO;
	}
	public void setZnbmDAO(ZnbmDAO znbmDAO) {
		this.znbmDAO = znbmDAO;
	}
	// 新闻
	public List<XinWen> queryDefaultXinWenrList(XinWen xinwen , Page page , String type , String dept) throws Exception {
			
			Integer xinWenType = null;
			if(null!=type&&!"".equals(type)){
				xinWenType = Integer.valueOf(type);
			}
			Integer deptType = null;
			if(null!=dept&&!"".equals(dept)){
				deptType = Integer.valueOf(dept);
			}
			Object[] objs = new Object[2];
			if (null != xinwen && !"".equals(xinwen)) {
				objs[0] = xinwen.getXinwenID();
			}
			return xinWenDAO.queryXinWenList(objs,page,xinWenType,deptType);
		}
	
	
	public XinWen findXinWenByID(String xinWenID) throws Exception {
		int id = 0;
			if(null!=xinWenID&&!"".equals(xinWenID)){		
				id = Integer.valueOf(xinWenID);			
			}
			SysUser user = xinWenDAO.findUserByID(id);
			XinWen xinwen = xinWenDAO.findXinWenByID(id);
			xinwen.getSysUser().setUserName(user.getUserName());
			xinwen.setXwfjList(xinWenDAO.queryXwfjByXwIDList(id));
			return xinwen;
	}
	
	// 用来查 图片新闻 和领导讲话的图片 用于显示在主页上
	public List<Xwfj> findXwfjByID(int xinWenID) throws Exception {

			return xinWenDAO.queryXwfjByXwIDList(xinWenID);
			
	}
	
	
	//通知公告
	public List<Tzgg> queryDefaultTzggList(Tzgg tzgg , Page page , String dept) throws Exception {
		Integer deptType = null;
		if(null!=dept&&!"".equals(dept)){
			deptType = Integer.valueOf(dept);
		}
		
		Object[] objs = new Object[2];
		if (null != tzgg && !"".equals(tzgg)) {
			objs[0] = tzgg.getTzggID();
		}
		return tzggDAO.queryTzggList(objs,page , deptType);
	}
	public Tzgg findTzggByID(String tzggID) throws Exception {
		int id = 0;
			if(null!=tzggID&&!"".equals(tzggID)){		
				id = Integer.valueOf(tzggID);			
			}
			SysUser user = tzggDAO.findUserByID(id);
			Tzgg tzgg = tzggDAO.findTzggByID(id);
			tzgg.getSysUser().setUserName(user.getUserName());
			return tzgg;
	}
	
	
	//文件发布
	public List<Wjfb> queryDefaultWjfbList(Wjfb wjfb , Page page ,String dept) throws Exception {
		Integer deptType = null;
		if(null!=dept&&!"".equals(dept)){
			deptType = Integer.valueOf(dept);
		}
		Object[] objs = new Object[2];
		if (null != wjfb && !"".equals(wjfb)) {
			objs[0] = wjfb.getWjfbID();
		}
		return wjfbDAO.queryWjfbList(objs,page , deptType);
	}
	public Wjfb findWjfbByID(String wjfbID) throws Exception {
		int id = 0;
			if(null!=wjfbID&&!"".equals(wjfbID)){		
				id = Integer.valueOf(wjfbID);			
			}
			SysUser user = wjfbDAO.findUserByID(id);
			Wjfb wjfb = wjfbDAO.findWjfbByID(id);
			wjfb.getSysUser().setUserName(user.getUserName());
			return wjfb;
	}

	
	//政策法规
	public List<Zcfg> queryDefaultZcfgList(Zcfg zcfg , Page page ,String type  ,String dept) throws Exception {
		Integer deptType = null;
		if(null!=dept&&!"".equals(dept)){
			deptType = Integer.valueOf(dept);
		}
		Object[] objs = new Object[2];
		if (null != zcfg && !"".equals(zcfg)) {
			objs[0] = zcfg.getZcfgID();
		}
		return zcfgDAO.queryZcfgList(objs,page, type ,deptType );
	}
	public Zcfg findZcfgByID(String zcfgID) throws Exception {
		int id = 0;
			if(null!=zcfgID&&!"".equals(zcfgID)){		
				id = Integer.valueOf(zcfgID);			
			}
			SysUser user = zcfgDAO.findUserByID(id);
			Zcfg zcfg = zcfgDAO.findZcfgByID(id);
			zcfg.getSysUser().setUserName(user.getUserName());
			return zcfg;
	}
	
	
	//办事指南
	public List<Bszn> queryDefaultBsznList(Bszn bszn , Page page,String dept ) throws Exception {
		Integer deptType = null;
		if(null!=dept&&!"".equals(dept)){
			deptType = Integer.valueOf(dept);
		}
		Object[] objs = new Object[2];
		if (null != bszn && !"".equals(bszn)) {
			objs[0] = bszn.getBsznID();
		}
		return bsznDAO.queryBsznList(objs,page,deptType);
	}
	public Bszn findBsznByID(String bsznID) throws Exception {
		int id = 0;
			if(null!=bsznID&&!"".equals(bsznID)){		
				id = Integer.valueOf(bsznID);			
			}
			SysUser user = bsznDAO.findUserByID(id);
			Bszn bszn = bsznDAO.findBsznByID(id);
			bszn.getSysUser().setUserName(user.getUserName());
			return bszn;
	}
	
	
	//热点关注
	public List<Rdgz> queryDefaultRdgzList(Rdgz rdgz , Page page,String dept  ) throws Exception {
		Integer deptType = null;
		if(null!=dept&&!"".equals(dept)){
			deptType = Integer.valueOf(dept);
		}
		Object[] objs = new Object[2];
		if (null != rdgz && !"".equals(rdgz)) {
			objs[0] = rdgz.getRdgzID();
		}
		return rdgzDAO.queryRdgzList(objs,page,deptType);
	}
	public Rdgz findRdgzByID(String rdgzID) throws Exception {
		int id = 0;
			if(null!=rdgzID&&!"".equals(rdgzID)){		
				id = Integer.valueOf(rdgzID);			
			}
			SysUser user = rdgzDAO.findUserByID(id);
			Rdgz rdgz = rdgzDAO.findRdgzByID(id);
			rdgz.getSysUser().setUserName(user.getUserName());
			return rdgz;
	}
	
	
	//联系方式
	public List<Lxfs> queryDefaultLxfsList(Lxfs lxfs , Page page ,String dept) throws Exception {
		Integer deptType = null;
		if(null!=dept&&!"".equals(dept)){
			deptType = Integer.valueOf(dept);
		}
		Object[] objs = new Object[2];
		if (null != lxfs && !"".equals(lxfs)) {
			objs[0] = lxfs.getLxfsID();
		}
		return lxfsDAO.queryLxfsList(objs,page,deptType);
	}
	public Lxfs findLxfsByID(String lxfsID) throws Exception {
		int id = 0;
			if(null!=lxfsID&&!"".equals(lxfsID)){		
				id = Integer.valueOf(lxfsID);			
			}
			SysUser user = lxfsDAO.findUserByID(id);
			Lxfs lxfs = lxfsDAO.findLxfsByID(id);
			lxfs.getSysUser().setUserName(user.getUserName());
			return lxfs;
	}
	
	
	//职能部门
	public Znbm findZnbmByID() throws Exception {
		
		Znbm znbm = znbmDAO.findZnbmByID(4);
			return znbm;
	}

}
