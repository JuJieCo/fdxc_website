package com.jinyu.fdxc.model.service;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.dao.BsznDAO;
import com.jinyu.fdxc.model.dao.LxfsDAO;
import com.jinyu.fdxc.model.dao.TouPiaoDAO;
import com.jinyu.fdxc.model.dao.TzggDAO;
import com.jinyu.fdxc.model.dao.WhmbDAO;
import com.jinyu.fdxc.model.dao.XinWenDAO;
import com.jinyu.fdxc.model.dao.ZcfgDAO;
import com.jinyu.fdxc.model.dao.ZnbmDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Bszn;
import com.jinyu.fdxc.struts.bean.Lxfs;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.TouPiao;
import com.jinyu.fdxc.struts.bean.Tzgg;
import com.jinyu.fdxc.struts.bean.Whmb;
import com.jinyu.fdxc.struts.bean.XinWen;
import com.jinyu.fdxc.struts.bean.Xwfj;
import com.jinyu.fdxc.struts.bean.Zcfg;
import com.jinyu.fdxc.struts.bean.Znbm;

public class IndexWtlyService {
	
	private XinWenDAO xinWenDAO;
	private TzggDAO tzggDAO;
	private WhmbDAO whmbDAO;
	private ZcfgDAO zcfgDAO;
	private BsznDAO bsznDAO;
	private TouPiaoDAO touPiaoDAO; 
	private LxfsDAO lxfsDAO;
	private ZnbmDAO znbmDAO;
	public void setTouPiaoDAO(TouPiaoDAO touPiaoDAO) {
		this.touPiaoDAO = touPiaoDAO;
	}
	public void setXinWenDAO(XinWenDAO xinWenDAO) {
		this.xinWenDAO = xinWenDAO;
	}
	public void setTzggDAO(TzggDAO tzggDAO) {
		this.tzggDAO = tzggDAO;
	}
	public void setZcfgDAO(ZcfgDAO zcfgDAO) {
		this.zcfgDAO = zcfgDAO;
	}
	public void setBsznDAO(BsznDAO bsznDAO) {
		this.bsznDAO = bsznDAO;
	}
	public void setLxfsDAO(LxfsDAO lxfsDAO) {
		this.lxfsDAO = lxfsDAO;
	}
	public void setZnbmDAO(ZnbmDAO znbmDAO) {
		this.znbmDAO = znbmDAO;
	}
	public void setWhmbDAO(WhmbDAO whmbDAO) {
		this.whmbDAO = whmbDAO;
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
		
		Znbm znbm = znbmDAO.findZnbmByID(2);
			return znbm;
	}
	
	
	//文化漫步
	public List<Whmb> queryDefaultWhmbList(Whmb whmb , Page page ) throws Exception {
		
		Object[] objs = new Object[2];
		if (null != whmb && !"".equals(whmb)) {
			objs[0] = whmb.getWhmbID();
		}
		return whmbDAO.queryWhmbList(objs,page);
	}
	public Whmb findWhmbByID(String whmbID) throws Exception {
		int id = 0;
			if(null!=whmbID&&!"".equals(whmbID)){		
				id = Integer.valueOf(whmbID);			
			}
			SysUser user = whmbDAO.findUserByID(id);
			Whmb whmb = whmbDAO.findWhmbByID(id);
			whmb.getSysUser().setUserName(user.getUserName());
			return whmb;
	}
	
	public int saveTiyan(String tiyan) throws Exception {
		//插入网站栏目设置为99为条件 查出来的是网站用户体验的数
		TouPiao touPiao = new TouPiao();
		if(null!=tiyan&&!"".equals(tiyan)){
			touPiao.setTiyan(Integer.valueOf(tiyan));
			touPiao.setShezhi(99);
			touPiao.setSubDate(new Date());
			return touPiaoDAO.saveTouPiao(touPiao);
		}else{
			return 0;
		}
		
	}
	
	public int saveShezhi(String shezhi) throws Exception {
		//插入网站用户体验为99为条件 查出来的是网站栏目设置的数
		TouPiao touPiao = new TouPiao();
		if(null!=shezhi&&!"".equals(shezhi)){
			touPiao.setShezhi(Integer.valueOf(shezhi));
			touPiao.setTiyan(99);
			touPiao.setSubDate(new Date());
			return touPiaoDAO.saveTouPiao(touPiao);
		}else{
			return 0;
		}
		
	}

}
