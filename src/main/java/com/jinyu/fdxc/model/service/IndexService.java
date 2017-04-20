package com.jinyu.fdxc.model.service;

import java.util.List;

import com.jinyu.fdxc.model.dao.BjznDAO;
import com.jinyu.fdxc.model.dao.BsznDAO;
import com.jinyu.fdxc.model.dao.DsjyDAO;
import com.jinyu.fdxc.model.dao.FdyxDAO;
import com.jinyu.fdxc.model.dao.FzghDAO;
import com.jinyu.fdxc.model.dao.GkfwDAO;
import com.jinyu.fdxc.model.dao.HdryDAO;
import com.jinyu.fdxc.model.dao.JbfcDAO;
import com.jinyu.fdxc.model.dao.LdcyDAO;
import com.jinyu.fdxc.model.dao.LxfsDAO;
import com.jinyu.fdxc.model.dao.NdjhDAO;
import com.jinyu.fdxc.model.dao.RdgzDAO;
import com.jinyu.fdxc.model.dao.RsxxDAO;
import com.jinyu.fdxc.model.dao.TzggDAO;
import com.jinyu.fdxc.model.dao.WjfbDAO;
import com.jinyu.fdxc.model.dao.XinWenDAO;
import com.jinyu.fdxc.model.dao.XzzqDAO;
import com.jinyu.fdxc.model.dao.ZcfgDAO;
import com.jinyu.fdxc.model.dao.ZzjgDAO;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Bjzn;
import com.jinyu.fdxc.struts.bean.Bszn;
import com.jinyu.fdxc.struts.bean.Dsjy;
import com.jinyu.fdxc.struts.bean.Fdyx;
import com.jinyu.fdxc.struts.bean.Fzgh;
import com.jinyu.fdxc.struts.bean.Gkfw;
import com.jinyu.fdxc.struts.bean.Hdry;
import com.jinyu.fdxc.struts.bean.Jbfc;
import com.jinyu.fdxc.struts.bean.Ldcy;
import com.jinyu.fdxc.struts.bean.Lxfs;
import com.jinyu.fdxc.struts.bean.Ndjh;
import com.jinyu.fdxc.struts.bean.Rdgz;
import com.jinyu.fdxc.struts.bean.Rsxx;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Tzgg;
import com.jinyu.fdxc.struts.bean.Wjfb;
import com.jinyu.fdxc.struts.bean.XinWen;
import com.jinyu.fdxc.struts.bean.Xwfj;
import com.jinyu.fdxc.struts.bean.Xzzq;
import com.jinyu.fdxc.struts.bean.Zcfg;
import com.jinyu.fdxc.struts.bean.Zzjg;

public class IndexService {

	private XinWenDAO xinWenDAO;
	private ZzjgDAO zzjgDAO;
	private BjznDAO bjznDAO;
	private HdryDAO hdryDAO;
	private DsjyDAO dsjyDAO;
	private LxfsDAO lxfsDAO;
	private GkfwDAO gkfwDAO;
	private LdcyDAO ldcyDAO;
	private RsxxDAO rsxxDAO;
	private FzghDAO fzghDAO;
	private NdjhDAO ndjhDAO;
	private WjfbDAO wjfbDAO;
	private TzggDAO tzggDAO;
	private ZcfgDAO zcfgDAO;
	private RdgzDAO rdgzDAO;
	private BsznDAO bsznDAO;
	private XzzqDAO xzzqDAO;
	private JbfcDAO jbfcDAO;
	private FdyxDAO fdyxDAO;
	
	public void setXinWenDAO(XinWenDAO xinWenDAO) {
		this.xinWenDAO = xinWenDAO;
	}
	public void setZzjgDAO(ZzjgDAO zzjgDAO) {
		this.zzjgDAO = zzjgDAO;
	}
	public void setBjznDAO(BjznDAO bjznDAO) {
		this.bjznDAO = bjznDAO;
	}
	public void setHdryDAO(HdryDAO hdryDAO) {
		this.hdryDAO = hdryDAO;
	}
	public void setDsjyDAO(DsjyDAO dsjyDAO) {
		this.dsjyDAO = dsjyDAO;
	}
	public void setLxfsDAO(LxfsDAO lxfsDAO) {
		this.lxfsDAO = lxfsDAO;
	}
	public void setGkfwDAO(GkfwDAO gkfwDAO) {
		this.gkfwDAO = gkfwDAO;
	}
	public void setLdcyDAO(LdcyDAO ldcyDAO) {
		this.ldcyDAO = ldcyDAO;
	}
	public void setRsxxDAO(RsxxDAO rsxxDAO) {
		this.rsxxDAO = rsxxDAO;
	}
	public void setFzghDAO(FzghDAO fzghDAO) {
		this.fzghDAO = fzghDAO;
	}
	public void setNdjhDAO(NdjhDAO ndjhDAO) {
		this.ndjhDAO = ndjhDAO;
	}
	public void setWjfbDAO(WjfbDAO wjfbDAO) {
		this.wjfbDAO = wjfbDAO;
	}
	public void setTzggDAO(TzggDAO tzggDAO) {
		this.tzggDAO = tzggDAO;
	}
	public void setZcfgDAO(ZcfgDAO zcfgDAO) {
		this.zcfgDAO = zcfgDAO;
	}
	public void setRdgzDAO(RdgzDAO rdgzDAO) {
		this.rdgzDAO = rdgzDAO;
	}
	public void setBsznDAO(BsznDAO bsznDAO) {
		this.bsznDAO = bsznDAO;
	}
	public void setXzzqDAO(XzzqDAO xzzqDAO) {
		this.xzzqDAO = xzzqDAO;
	}
	public void setJbfcDAO(JbfcDAO jbfcDAO) {
		this.jbfcDAO = jbfcDAO;
	}
	public void setFdyxDAO(FdyxDAO fdyxDAO) {
		this.fdyxDAO = fdyxDAO;
	}
// 新闻
public List<XinWen> queryDefaultXinWenrList(XinWen xinwen , Page page , String type) throws Exception {
		
		Integer xinWenType = null;
		if(null!=type&&!"".equals(type)){
			xinWenType = Integer.valueOf(type);
		}
		Object[] objs = new Object[2];
		if (null != xinwen && !"".equals(xinwen)) {
			objs[0] = xinwen.getXinwenID();
		}
		return xinWenDAO.queryXinWenList(objs,page,xinWenType,null);
	}


// 用来查 图片新闻 和领导讲话的图片 用于显示在主页上
public List<Xwfj> findXwfjByID(int xinWenID) throws Exception {

		return xinWenDAO.queryXwfjByXwIDList(xinWenID);
		
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

//组织机构
public List<Zzjg> queryDefaultZzjgList(Zzjg zzjg , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != zzjg && !"".equals(zzjg)) {
		objs[0] = zzjg.getZzjgID();
	}
	return zzjgDAO.queryZzjgList(objs,page);
}
public Zzjg findZzjgByID(String zzjgID) throws Exception {
	int id = 0;
		if(null!=zzjgID&&!"".equals(zzjgID)){		
			id = Integer.valueOf(zzjgID);			
		}
		SysUser user = zzjgDAO.findUserByID(id);
		Zzjg zzjg = zzjgDAO.findZzjgByID(id);
		zzjg.getSysUser().setUserName(user.getUserName());
		return zzjg;
}



//本局职能
public List<Bjzn> queryDefaultBjznList(Bjzn bjzn , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != bjzn && !"".equals(bjzn)) {
		objs[0] = bjzn.getBjznID();
	}
	return bjznDAO.queryBjznList(objs,page);
}
public Bjzn findBjznByID(String bjznID) throws Exception {
	int id = 0;
		if(null!=bjznID&&!"".equals(bjznID)){		
			id = Integer.valueOf(bjznID);			
		}
		SysUser user = bjznDAO.findUserByID(id);
		Bjzn bjzn = bjznDAO.findBjznByID(id);
		bjzn.getSysUser().setUserName(user.getUserName());
		return bjzn;
}


//获得荣誉
public List<Hdry> queryDefaultHdryList(Hdry hdry , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != hdry && !"".equals(hdry)) {
		objs[0] = hdry.getHdryID();
	}
	return hdryDAO.queryHdryList(objs,page);
}
public Hdry findHdryByID(String hdryID) throws Exception {
	int id = 0;
		if(null!=hdryID&&!"".equals(hdryID)){		
			id = Integer.valueOf(hdryID);			
		}
		SysUser user = hdryDAO.findUserByID(id);
		Hdry hdry = hdryDAO.findHdryByID(id);
		hdry.getSysUser().setUserName(user.getUserName());
		return hdry;
}


//大事记要
public List<Dsjy> queryDefaultDsjyList(Dsjy dsjy , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != dsjy && !"".equals(dsjy)) {
		objs[0] = dsjy.getDsjyID();
	}
	return dsjyDAO.queryDsjyList(objs,page);
}
public Dsjy findDsjyByID(String dsjyID) throws Exception {
	int id = 0;
		if(null!=dsjyID&&!"".equals(dsjyID)){		
			id = Integer.valueOf(dsjyID);			
		}
		SysUser user = dsjyDAO.findUserByID(id);
		Dsjy dsjy = dsjyDAO.findDsjyByID(id);
		dsjy.getSysUser().setUserName(user.getUserName());
		return dsjy;
}


//联系方式
public List<Lxfs> queryDefaultLxfsList(Lxfs lxfs , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != lxfs && !"".equals(lxfs)) {
		objs[0] = lxfs.getLxfsID();
	}
	return lxfsDAO.queryLxfsList(objs,page,null);
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


//公开范围
public List<Gkfw> queryDefaultGkfwList(Gkfw gkfw , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != gkfw && !"".equals(gkfw)) {
		objs[0] = gkfw.getGkfwID();
	}
	return gkfwDAO.queryGkfwList(objs,page);
}
public Gkfw findGkfwByID(String gkfwID) throws Exception {
	int id = 0;
		if(null!=gkfwID&&!"".equals(gkfwID)){		
			id = Integer.valueOf(gkfwID);			
		}
		SysUser user = gkfwDAO.findUserByID(id);
		Gkfw gkfw = gkfwDAO.findGkfwByID(id);
		gkfw.getSysUser().setUserName(user.getUserName());
		return gkfw;
}



//领导成员
public List<Ldcy> queryDefaultLdcyList(Ldcy ldcy , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != ldcy && !"".equals(ldcy)) {
		objs[0] = ldcy.getLdcyID();
	}
	return ldcyDAO.queryLdcyList(objs,page);
}
public Ldcy findLdcyByID(String ldcyID) throws Exception {
	int id = 0;
		if(null!=ldcyID&&!"".equals(ldcyID)){		
			id = Integer.valueOf(ldcyID);			
		}
		SysUser user = ldcyDAO.findUserByID(id);
		Ldcy ldcy = ldcyDAO.findLdcyByID(id);
		ldcy.getSysUser().setUserName(user.getUserName());
		return ldcy;
}



//人事信息
public List<Rsxx> queryDefaultRsxxList(Rsxx rsxx , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != rsxx && !"".equals(rsxx)) {
		objs[0] = rsxx.getRsxxID();
	}
	return rsxxDAO.queryRsxxList(objs,page);
}
public Rsxx findRsxxByID(String rsxxID) throws Exception {
	int id = 0;
		if(null!=rsxxID&&!"".equals(rsxxID)){		
			id = Integer.valueOf(rsxxID);			
		}
		SysUser user = rsxxDAO.findUserByID(id);
		Rsxx rsxx = rsxxDAO.findRsxxByID(id);
		rsxx.getSysUser().setUserName(user.getUserName());
		return rsxx;
}


//发展规划
public List<Fzgh> queryDefaultFzghList(Fzgh fzgh , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != fzgh && !"".equals(fzgh)) {
		objs[0] = fzgh.getFzghID();
	}
	return fzghDAO.queryFzghList(objs,page);
}
public Fzgh findFzghByID(String fzghID) throws Exception {
	int id = 0;
		if(null!=fzghID&&!"".equals(fzghID)){		
			id = Integer.valueOf(fzghID);			
		}
		SysUser user = fzghDAO.findUserByID(id);
		Fzgh fzgh = fzghDAO.findFzghByID(id);
		fzgh.getSysUser().setUserName(user.getUserName());
		return fzgh;
}



//年度计划
public List<Ndjh> queryDefaultNdjhList(Ndjh ndjh , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != ndjh && !"".equals(ndjh)) {
		objs[0] = ndjh.getNdjhID();
	}
	return ndjhDAO.queryNdjhList(objs,page);
}
public Ndjh findNdjhByID(String ndjhID) throws Exception {
	int id = 0;
		if(null!=ndjhID&&!"".equals(ndjhID)){		
			id = Integer.valueOf(ndjhID);			
		}
		SysUser user = ndjhDAO.findUserByID(id);
		Ndjh ndjh = ndjhDAO.findNdjhByID(id);
		ndjh.getSysUser().setUserName(user.getUserName());
		return ndjh;
}


//文件发布
public List<Wjfb> queryDefaultWjfbList(Wjfb wjfb , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != wjfb && !"".equals(wjfb)) {
		objs[0] = wjfb.getWjfbID();
	}
	return wjfbDAO.queryWjfbList(objs,page,null);
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



//通知公告
public List<Tzgg> queryDefaultTzggList(Tzgg tzgg , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != tzgg && !"".equals(tzgg)) {
		objs[0] = tzgg.getTzggID();
	}
	return tzggDAO.queryTzggList(objs,page,null);
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
public List<Zcfg> queryDefaultZcfgList(Zcfg zcfg , Page page ,String type ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != zcfg && !"".equals(zcfg)) {
		objs[0] = zcfg.getZcfgID();
	}
	return zcfgDAO.queryZcfgList(objs,page, type,null);
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


//热点关注
public List<Rdgz> queryDefaultRdgzList(Rdgz rdgz , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != rdgz && !"".equals(rdgz)) {
		objs[0] = rdgz.getRdgzID();
	}
	return rdgzDAO.queryRdgzList(objs,page,null);
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


//办事指南
public List<Bszn> queryDefaultBsznList(Bszn bszn , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != bszn && !"".equals(bszn)) {
		objs[0] = bszn.getBsznID();
	}
	return bsznDAO.queryBsznList(objs,page,null);
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


//下载专区
public List<Xzzq> queryDefaultXzzqList(Xzzq xzzq , Page page ) throws Exception {
	
	Object[] objs = new Object[2];
	if (null != xzzq && !"".equals(xzzq)) {
		objs[0] = xzzq.getXzzqID();
	}
	return xzzqDAO.queryXzzqList(objs,page);
}
public Xzzq findXzzqByID(String xzzqID) throws Exception {
	int id = 0;
		if(null!=xzzqID&&!"".equals(xzzqID)){		
			id = Integer.valueOf(xzzqID);			
		}
		SysUser user = xzzqDAO.findUserByID(id);
		Xzzq xzzq = xzzqDAO.findXzzqByID(id);
		xzzq.getSysUser().setUserName(user.getUserName());
		return xzzq;
}


//街办风采
public List<Jbfc> queryDefaultJbfcList(Jbfc jbfc , Page page) throws Exception {
		Object[] objs = new Object[2];
		if (null != jbfc && !"".equals(jbfc)) {
			objs[0] = jbfc.getJbfcID();
		}
		return jbfcDAO.queryJbfcList(objs,page);
	}
public Jbfc findJbfcByID(String jbfcID) throws Exception {
	int id = 0;
		if(null!=jbfcID&&!"".equals(jbfcID)){		
			id = Integer.valueOf(jbfcID);			
		}
		SysUser user = jbfcDAO.findUserByID(id);
		Jbfc jbfc = jbfcDAO.findJbfcByID(id);
		jbfc.getSysUser().setUserName(user.getUserName());
		jbfc.setJbfjList(jbfcDAO.queryJbfjByJbIDList(id));
		return jbfc;
}


//沣东印象
public List<Fdyx> queryDefaultFdyxList(Fdyx fdyx , Page page) throws Exception {
	Object[] objs = new Object[2];
	if (null != fdyx && !"".equals(fdyx)) {
		objs[0] = fdyx.getFdyxID();
	}
	List<Fdyx> fdyxList = fdyxDAO.queryFdyxList(objs,page);
	for (Fdyx fdyxT : fdyxList) {
		fdyxT.setFdfjList(fdyxDAO.queryFdfjByFdIDList(fdyxT.getFdyxID()));
	}
	return fdyxList;
}
public Fdyx findFdyxByID(String fdyxID) throws Exception {
int id = 0;
	if(null!=fdyxID&&!"".equals(fdyxID)){		
		id = Integer.valueOf(fdyxID);			
	}
	SysUser user = fdyxDAO.findUserByID(id);
	Fdyx fdyx = fdyxDAO.findFdyxByID(id);
	fdyx.getSysUser().setUserName(user.getUserName());
	fdyx.setFdfjList(fdyxDAO.queryFdfjByFdIDList(id));
	return fdyx;
}


////用来查 沣东印象的图片 用于显示在主页上
//public List<Fdfj> findFdfjByID(int fdyxID) throws Exception {
//
//		return fdyxDAO.queryFdfjByFdIDList(fdyxID);
//		
//}


}
