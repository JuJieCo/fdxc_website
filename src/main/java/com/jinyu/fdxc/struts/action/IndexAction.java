package com.jinyu.fdxc.struts.action;

import java.util.ArrayList;
import java.util.List;

import com.jinyu.fdxc.model.service.IndexService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Bjzn;
import com.jinyu.fdxc.struts.bean.Bszn;
import com.jinyu.fdxc.struts.bean.Dsjy;
import com.jinyu.fdxc.struts.bean.Fdfj;
import com.jinyu.fdxc.struts.bean.Fdyx;
import com.jinyu.fdxc.struts.bean.Fzgh;
import com.jinyu.fdxc.struts.bean.Gkfw;
import com.jinyu.fdxc.struts.bean.Hdry;
import com.jinyu.fdxc.struts.bean.Jbfc;
import com.jinyu.fdxc.struts.bean.Jbfj;
import com.jinyu.fdxc.struts.bean.Ldcy;
import com.jinyu.fdxc.struts.bean.Lxfs;
import com.jinyu.fdxc.struts.bean.Ndjh;
import com.jinyu.fdxc.struts.bean.Rdgz;
import com.jinyu.fdxc.struts.bean.Rsxx;
import com.jinyu.fdxc.struts.bean.Tzgg;
import com.jinyu.fdxc.struts.bean.Wjfb;
import com.jinyu.fdxc.struts.bean.XinWen;
import com.jinyu.fdxc.struts.bean.Xwfj;
import com.jinyu.fdxc.struts.bean.Xzzq;
import com.jinyu.fdxc.struts.bean.Zcfg;
import com.jinyu.fdxc.struts.bean.Zzjg;

public class IndexAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private List<XinWen> xinwen;
	private List<XinWen> xinwen0;
	private List<XinWen> xinwen1;
	private List<XinWen> xinwen2;
	private List<XinWen> xinwen3;
	private List<XinWen> xinwen4;
	private List<XinWen> xinwen5;
	private XinWen xinWen;
	private List<Xwfj> xwfjList;
	private List<XinWen> xinwenList;
	private Zzjg zzjg;
	private List<Zzjg> zzjgList;
	private Hdry hdry;
	private List<Hdry> hdryList;
	private Bjzn  bjzn;
	private List<Bjzn> bjznList; 
	private Lxfs lxfs;
	private List<Lxfs> lxfsList;
	private Dsjy dsjy;
	private List<Dsjy> dsjyList;
	private List<Hdry> hdry0;
	private Gkfw gkfw;
	private List<Gkfw> gkfwList;
	private Ldcy ldcy;
	private List<Ldcy> ldcyList;
	private Rsxx rsxx;
	private List<Rsxx> rsxxList;
	private Fzgh fzgh;
	private List<Fzgh> fzghList;
	private Ndjh ndjh;
	private List<Ndjh> ndjhList;
	private Wjfb wjfb;
	private List<Wjfb> wjfbList;
	private List<Wjfb> wjfb0;
	private Tzgg tzgg;
	private List<Tzgg> tzggList;
	private List<Tzgg> tzgg0;
	private Zcfg zcfg;
	private List<Zcfg> zcfgList;
	private List<Zcfg> zcfg0;
	private Rdgz rdgz;
	private List<Rdgz> rdgzList;
	private Bszn bszn;
	private List<Bszn> bsznList;
	private Xzzq xzzq;
	private List<Xzzq> xzzqList;
	private Jbfc jbfc;
	private List<Jbfc> jbfcList;
	private Fdyx fdyx;
	private List<Fdyx> fdyxList; 
	private List<Fdyx> fdyx0;
	private List<Jbfj> JbfjList;
	private List<Fdfj> fdfjList; 
	private List<Fdfj> fdfj0; 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<XinWen> getXinwen() {
		return xinwen;
	}
	public void setXinwen(List<XinWen> xinwen) {
		this.xinwen = xinwen;
	}
	public List<XinWen> getXinwen0() {
		return xinwen0;
	}
	public void setXinwen0(List<XinWen> xinwen0) {
		this.xinwen0 = xinwen0;
	}
	public List<XinWen> getXinwen1() {
		return xinwen1;
	}
	public void setXinwen1(List<XinWen> xinwen1) {
		this.xinwen1 = xinwen1;
	}
	public List<XinWen> getXinwen2() {
		return xinwen2;
	}
	public void setXinwen2(List<XinWen> xinwen2) {
		this.xinwen2 = xinwen2;
	}
	public List<XinWen> getXinwen3() {
		return xinwen3;
	}
	public void setXinwen3(List<XinWen> xinwen3) {
		this.xinwen3 = xinwen3;
	}
	public List<XinWen> getXinwen4() {
		return xinwen4;
	}
	public void setXinwen4(List<XinWen> xinwen4) {
		this.xinwen4 = xinwen4;
	}
	public List<XinWen> getXinwen5() {
		return xinwen5;
	}
	public void setXinwen5(List<XinWen> xinwen5) {
		this.xinwen5 = xinwen5;
	}
	public List<XinWen> getXinwenList() {
		return xinwenList;
	}
	public XinWen getXinWen() {
		return xinWen;
	}
	public void setXinWen(XinWen xinWen) {
		this.xinWen = xinWen;
	}
	public void setXinwenList(List<XinWen> xinwenList) {
		this.xinwenList = xinwenList;
	}
	public List<Xwfj> getXwfjList() {
		return xwfjList;
	}
	public void setXwfjList(List<Xwfj> xwfjList) {
		this.xwfjList = xwfjList;
	}
	public List<Zzjg> getZzjgList() {
		return zzjgList;
	}
	public void setZzjgList(List<Zzjg> zzjgList) {
		this.zzjgList = zzjgList;
	}
	public Zzjg getZzjg() {
		return zzjg;
	}
	public void setZzjg(Zzjg zzjg) {
		this.zzjg = zzjg;
	}
	public Bjzn getBjzn() {
		return bjzn;
	}
	public void setBjzn(Bjzn bjzn) {
		this.bjzn = bjzn;
	}
	public List<Bjzn> getBjznList() {
		return bjznList;
	}
	public void setBjznList(List<Bjzn> bjznList) {
		this.bjznList = bjznList;
	}
	public Hdry getHdry() {
		return hdry;
	}
	public void setHdry(Hdry hdry) {
		this.hdry = hdry;
	}
	public List<Hdry> getHdryList() {
		return hdryList;
	}
	public void setHdryList(List<Hdry> hdryList) {
		this.hdryList = hdryList;
	}
	public Lxfs getLxfs() {
		return lxfs;
	}
	public void setLxfs(Lxfs lxfs) {
		this.lxfs = lxfs;
	}
	public List<Lxfs> getLxfsList() {
		return lxfsList;
	}
	public void setLxfsList(List<Lxfs> lxfsList) {
		this.lxfsList = lxfsList;
	}
	public Dsjy getDsjy() {
		return dsjy;
	}
	public void setDsjy(Dsjy dsjy) {
		this.dsjy = dsjy;
	}
	public List<Dsjy> getDsjyList() {
		return dsjyList;
	}
	public void setDsjyList(List<Dsjy> dsjyList) {
		this.dsjyList = dsjyList;
	}
	public List<Hdry> getHdry0() {
		return hdry0;
	}
	public void setHdry0(List<Hdry> hdry0) {
		this.hdry0 = hdry0;
	}
	public Gkfw getGkfw() {
		return gkfw;
	}
	public void setGkfw(Gkfw gkfw) {
		this.gkfw = gkfw;
	}
	public List<Gkfw> getGkfwList() {
		return gkfwList;
	}
	public void setGkfwList(List<Gkfw> gkfwList) {
		this.gkfwList = gkfwList;
	}
	public Ldcy getLdcy() {
		return ldcy;
	}
	public void setLdcy(Ldcy ldcy) {
		this.ldcy = ldcy;
	}
	public List<Ldcy> getLdcyList() {
		return ldcyList;
	}
	public void setLdcyList(List<Ldcy> ldcyList) {
		this.ldcyList = ldcyList;
	}
	public Rsxx getRsxx() {
		return rsxx;
	}
	public void setRsxx(Rsxx rsxx) {
		this.rsxx = rsxx;
	}
	public List<Rsxx> getRsxxList() {
		return rsxxList;
	}
	public void setRsxxList(List<Rsxx> rsxxList) {
		this.rsxxList = rsxxList;
	}
	public Fzgh getFzgh() {
		return fzgh;
	}
	public void setFzgh(Fzgh fzgh) {
		this.fzgh = fzgh;
	}
	public List<Fzgh> getFzghList() {
		return fzghList;
	}
	public void setFzghList(List<Fzgh> fzghList) {
		this.fzghList = fzghList;
	}
	public Ndjh getNdjh() {
		return ndjh;
	}
	public void setNdjh(Ndjh ndjh) {
		this.ndjh = ndjh;
	}
	public List<Ndjh> getNdjhList() {
		return ndjhList;
	}
	public void setNdjhList(List<Ndjh> ndjhList) {
		this.ndjhList = ndjhList;
	}
	public Wjfb getWjfb() {
		return wjfb;
	}
	public void setWjfb(Wjfb wjfb) {
		this.wjfb = wjfb;
	}
	public List<Wjfb> getWjfbList() {
		return wjfbList;
	}
	public void setWjfbList(List<Wjfb> wjfbList) {
		this.wjfbList = wjfbList;
	}
	public List<Wjfb> getWjfb0() {
		return wjfb0;
	}
	public void setWjfb0(List<Wjfb> wjfb0) {
		this.wjfb0 = wjfb0;
	}
	public Tzgg getTzgg() {
		return tzgg;
	}
	public void setTzgg(Tzgg tzgg) {
		this.tzgg = tzgg;
	}
	public List<Tzgg> getTzggList() {
		return tzggList;
	}
	public void setTzggList(List<Tzgg> tzggList) {
		this.tzggList = tzggList;
	}
	public List<Tzgg> getTzgg0() {
		return tzgg0;
	}
	public void setTzgg0(List<Tzgg> tzgg0) {
		this.tzgg0 = tzgg0;
	}
	public Zcfg getZcfg() {
		return zcfg;
	}
	public void setZcfg(Zcfg zcfg) {
		this.zcfg = zcfg;
	}
	public List<Zcfg> getZcfgList() {
		return zcfgList;
	}
	public void setZcfgList(List<Zcfg> zcfgList) {
		this.zcfgList = zcfgList;
	}
	public List<Zcfg> getZcfg0() {
		return zcfg0;
	}
	public void setZcfg0(List<Zcfg> zcfg0) {
		this.zcfg0 = zcfg0;
	}
	public Rdgz getRdgz() {
		return rdgz;
	}
	public void setRdgz(Rdgz rdgz) {
		this.rdgz = rdgz;
	}
	public List<Rdgz> getRdgzList() {
		return rdgzList;
	}
	public void setRdgzList(List<Rdgz> rdgzList) {
		this.rdgzList = rdgzList;
	}
	public Bszn getBszn() {
		return bszn;
	}
	public void setBszn(Bszn bszn) {
		this.bszn = bszn;
	}
	public List<Bszn> getBsznList() {
		return bsznList;
	}
	public void setBsznList(List<Bszn> bsznList) {
		this.bsznList = bsznList;
	}
	public Xzzq getXzzq() {
		return xzzq;
	}
	public void setXzzq(Xzzq xzzq) {
		this.xzzq = xzzq;
	}
	public List<Xzzq> getXzzqList() {
		return xzzqList;
	}
	public void setXzzqList(List<Xzzq> xzzqList) {
		this.xzzqList = xzzqList;
	}
	public Jbfc getJbfc() {
		return jbfc;
	}
	public void setJbfc(Jbfc jbfc) {
		this.jbfc = jbfc;
	}
	public List<Jbfc> getJbfcList() {
		return jbfcList;
	}
	public void setJbfcList(List<Jbfc> jbfcList) {
		this.jbfcList = jbfcList;
	}
	public Fdyx getFdyx() {
		return fdyx;
	}
	public void setFdyx(Fdyx fdyx) {
		this.fdyx = fdyx;
	}
	public List<Fdyx> getFdyxList() {
		return fdyxList;
	}
	public void setFdyxList(List<Fdyx> fdyxList) {
		this.fdyxList = fdyxList;
	}
	public List<Fdyx> getFdyx0() {
		return fdyx0;
	}
	public void setFdyx0(List<Fdyx> fdyx0) {
		this.fdyx0 = fdyx0;
	}
	public List<Jbfj> getJbfjList() {
		return JbfjList;
	}
	public void setJbfjList(List<Jbfj> jbfjList) {
		JbfjList = jbfjList;
	}
	public List<Fdfj> getFdfjList() {
		return fdfjList;
	}
	public void setFdfjList(List<Fdfj> fdfjList) {
		this.fdfjList = fdfjList;
	}
	public List<Fdfj> getFdfj0() {
		return fdfj0;
	}
	public void setFdfj0(List<Fdfj> fdfj0) {
		this.fdfj0 = fdfj0;
	}
	/**
	 * 新闻的类别 
	 * 0 要闻简报 
	 * 1 政务新闻 
	 * 2 图片新闻 
	 * 3 处室动态 
	 * 4 党建工作 
	 * 5 领导讲话
	 */
	/**
	 * 显示主页的信息
	 */
	public String showIndexPage() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
	
	/**主页显示的新闻*/
		xinwen0 = this.getXinWen("0");
		if(xinwen0.size()>10){
			xinwen0 = xinwen0.subList(0, 10);
		}
		
		xinwen1 = this.getXinWen("1");
		if(xinwen1.size()>9){
			xinwen1 = xinwen1.subList(0, 9);
		}
		
		xinwen2 = this.getXinWen("2");
		if(null!=xinwen2&&xinwen2.size()>0){
			if(1<=xinwen2.size()){
				List<Xwfj> xwfj= indexService.findXwfjByID(xinwen2.get(0).getXinwenID());//查图片
				if(xwfj.size()>0){
					request.setAttribute("tpxwimg0", xwfj.get(0).getXwfjFileUrl());
					request.setAttribute("tpxw0ID", xinwen2.get(0).getXinwenID());
					request.setAttribute("tpxw0Title", xinwen2.get(0).getXinwenTitle());
				}
			}
			if(2<=xinwen2.size()){
				List<Xwfj> xwfj = indexService.findXwfjByID(xinwen2.get(1).getXinwenID());//查图片
				if(xwfj.size()>0){
					request.setAttribute("tpxwimg1", xwfj.get(0).getXwfjFileUrl());
					request.setAttribute("tpxw1ID", xinwen2.get(1).getXinwenID());
					request.setAttribute("tpxw1Title", xinwen2.get(1).getXinwenTitle());
				}
			}
			if(3<=xinwen2.size()){
				List<Xwfj> xwfj = indexService.findXwfjByID(xinwen2.get(2).getXinwenID());//查图片
				if(xwfj.size()>0){
					request.setAttribute("tpxwimg2", xwfj.get(0).getXwfjFileUrl());
					request.setAttribute("tpxw2ID", xinwen2.get(2).getXinwenID());
					request.setAttribute("tpxw2Title", xinwen2.get(2).getXinwenTitle());
				}
			}
		}
		
		xinwen3 = this.getXinWen("3");
		if(xinwen3.size()>9){
			xinwen3 = xinwen3.subList(0, 9);
		}
		
		xinwen4 = this.getXinWen("4");
		if(xinwen4.size()>9){
			xinwen4 = xinwen4.subList(0, 9);
		}
		
		xinwen5 = this.getXinWen("5");
		if(null!=xinwen5&&xinwen5.size()>0){
			if(null!=xinwen5.get(0)){
				List<Xwfj> xwfj= indexService.findXwfjByID(xinwen5.get(0).getXinwenID());//查图片
				if(xwfj.size()>0){
					request.setAttribute("ldimg", xwfj.get(0).getXwfjFileUrl());
				}
			}
		}
		
		/**主页显示的获得荣誉*/
		hdry0 = indexService.queryDefaultHdryList(null,null);
		if(null!=hdry0&&hdry0.size()>0){
			if(null!=hdry0.get(0)){
				request.setAttribute("ryimg", hdry0.get(0));
			}
		}
		/**主页显示的文件发布*/
		wjfb0 = indexService.queryDefaultWjfbList(null,null);
		if(wjfb0.size()>9){
			wjfb0 = wjfb0.subList(0, 9);
			//request.setAttribute("wjfb0", wjfb0);
		}
		/**主页显示的通知公告*/
		tzgg0 = indexService.queryDefaultTzggList(null,null);
		if(tzgg0.size()>9){
			tzgg0 = tzgg0.subList(0, 9);
			//request.setAttribute("tzgg0", tzgg0);
		}
		/**主页显示的政策法规*/
		zcfg0 = indexService.queryDefaultZcfgList(null,null,null);
		if(zcfg0.size()>6){
			zcfg0 = zcfg0.subList(0, 6);
			//request.setAttribute("zcfg0", zcfg0);
		}
		
		/**主页显示沣东印象*/
		fdyx0 = indexService.queryDefaultFdyxList(null, null);
		fdfj0 = new ArrayList<Fdfj>();
		for (int i=0 ;i<fdyx0.size();i++) {
			List<Fdfj> fdfjList = fdyx0.get(i).getFdfjList();
			for (Fdfj fdfj : fdfjList) {
				fdfj0.add(fdfj);
			}
		}
		if(fdfj0.size()>4){
			fdfj0 = fdfj0.subList(0, 4);
		}
	
		
		
		return "indexpage";
	}

	
	
	
	
	
	
	
	
	
	/**查新闻的方法*/
	public List<XinWen>  getXinWen(String type) throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		List<XinWen> list = indexService.queryDefaultXinWenrList(null, null, type);
			return list  ;
		}
	
	
	
	
	
	
	
	
	
	
	
	/**跳转到新闻的下拉菜单的方法 */
	public String queryXinwenMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		String[] tpyeTexts = {"要闻简报","政务新闻","图片新闻","处室动态","党建工作","领导讲话"};
		String type = request.getParameter("type");
		if(null!=type&&!"".equals(type)){
			request.setAttribute("tpyeText", tpyeTexts[Integer.valueOf(type)]);
		}
		xinwenList = indexService.queryDefaultXinWenrList(null,page,type);
		request.setAttribute("type", type);
		return "xwlist";
	}
	public String findXinWenForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");

		String[] tpyeTexts = {"要闻简报","政务新闻","图片新闻","处室动态","党建工作","领导讲话"};
		String type = request.getParameter("type");
		if(null!=type&&!"".equals(type)){
			request.setAttribute("tpyeText", tpyeTexts[Integer.valueOf(type)]);
		}
		
		String xinWenID = request.getParameter("xinwenID");
		xinWen = indexService.findXinWenByID(xinWenID);
		xwfjList = xinWen.getXwfjList();
		
		return "xwshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到组织机构的下拉菜单的方法 */
	public String queryZzjgMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		zzjgList = indexService.queryDefaultZzjgList(null,page);
		return "zzjglist";
	}
	public String findZzjgForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String zzjgID = request.getParameter("zzjgID");
		zzjg = indexService.findZzjgByID(zzjgID);
		return "zzjgshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到本局职能的下拉菜单的方法 */
	public String queryBjznMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		bjznList = indexService.queryDefaultBjznList(null,page);
		return "bjznlist";
	}
	public String findBjznForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String bjznID = request.getParameter("bjznID");
		bjzn = indexService.findBjznByID(bjznID);
		return "bjznshow";
	}
	
	
	
	
	
	
	
	
	

	/**跳转到获得荣誉的下拉菜单的方法 */
	public String queryHdryMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		hdryList = indexService.queryDefaultHdryList(null,page);
		return "hdrylist";
	}
	public String findHdryForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String hdryID = request.getParameter("hdryID");
		hdry = indexService.findHdryByID(hdryID);
		return "hdryshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到大事记要的下拉菜单的方法 */
	public String queryDsjyMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		dsjyList = indexService.queryDefaultDsjyList(null,page);
		return "dsjylist";
	}
	public String findDsjyForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String dsjyID = request.getParameter("dsjyID");
		dsjy = indexService.findDsjyByID(dsjyID);
		return "dsjyshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到联系方式的下拉菜单的方法 */
	public String queryLxfsMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		lxfsList = indexService.queryDefaultLxfsList(null,page);
		return "lxfslist";
	}
	public String findLxfsForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String lxfsID = request.getParameter("lxfsID");
		lxfs = indexService.findLxfsByID(lxfsID);
		return "lxfsshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到公开范围的下拉菜单的方法 */
	public String queryGkfwMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		gkfwList = indexService.queryDefaultGkfwList(null,page);
		return "gkfwlist";
	}
	public String findGkfwForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String gkfwID = request.getParameter("gkfwID");
		gkfw = indexService.findGkfwByID(gkfwID);
		return "gkfwshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到领导成员的下拉菜单的方法 */
	public String queryLdcyMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		ldcyList = indexService.queryDefaultLdcyList(null,page);
		return "ldcylist";
	}
	public String findLdcyForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String ldcyID = request.getParameter("ldcyID");
		ldcy = indexService.findLdcyByID(ldcyID);
		return "ldcyshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到人事信息的下拉菜单的方法 */
	public String queryRsxxMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		rsxxList = indexService.queryDefaultRsxxList(null,page);
		return "rsxxlist";
	}
	public String findRsxxForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String rsxxID = request.getParameter("rsxxID");
		rsxx = indexService.findRsxxByID(rsxxID);
		return "rsxxshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到发展规划的下拉菜单的方法 */
	public String queryFzghMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		fzghList = indexService.queryDefaultFzghList(null,page);
		return "fzghlist";
	}
	public String findFzghForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String fzghID = request.getParameter("fzghID");
		fzgh = indexService.findFzghByID(fzghID);
		return "fzghshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到年度计划的下拉菜单的方法 */
	public String queryNdjhMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		ndjhList = indexService.queryDefaultNdjhList(null,page);
		return "ndjhlist";
	}
	public String findNdjhForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String ndjhID = request.getParameter("ndjhID");
		ndjh = indexService.findNdjhByID(ndjhID);
		return "ndjhshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到文件发布的下拉菜单的方法 */
	public String queryWjfbMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		wjfbList = indexService.queryDefaultWjfbList(null,page);
		return "wjfblist";
	}
	public String findWjfbForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String wjfbID = request.getParameter("wjfbID");
		wjfb = indexService.findWjfbByID(wjfbID);
		return "wjfbshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到通知公告的下拉菜单的方法 */
	public String queryTzggMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		tzggList = indexService.queryDefaultTzggList(null,page);
		return "tzgglist";
	}
	public String findTzggForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String tzggID = request.getParameter("tzggID");
		tzgg = indexService.findTzggByID(tzggID);
		return "tzggshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到政策法规的下拉菜单的方法 */	
	public String queryFGMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		String[] tpyeTexts = {"国家法规","省级法规","市级法规","区级法规","重要文献","法规解读"};
		String type = request.getParameter("type");
		if(null!=type&&!"".equals(type)){
			request.setAttribute("tpyeText", tpyeTexts[Integer.valueOf(type)]);
		}
		zcfgList = indexService.queryDefaultZcfgList(null,page,type);
		request.setAttribute("type", type);
		return "zcfglist";
	}
	public String findZcfgForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String[] tpyeTexts = {"国家法规","省级法规","市级法规","区级法规","重要文献","法规解读"};
		String type = request.getParameter("type");
		if(null!=type&&!"".equals(type)){
			request.setAttribute("tpyeText", tpyeTexts[Integer.valueOf(type)]);
		}
		String zcfgID = request.getParameter("zcfgID");
		zcfg = indexService.findZcfgByID(zcfgID);
		return "zcfgshow";
	}

	
	
	
	
	
	
	
	
	
	
	/**跳转到公开目录的下拉菜单的方法 */	
	public String queryGkmlMenu(){
		
		return "indexpage";
	}
	
	
	
	
	
	
	
	
	
	/**跳转到热点关注的下拉菜单的方法 */
	public String queryRdgzMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		rdgzList = indexService.queryDefaultRdgzList(null,page);
		return "rdgzlist";
	}
	public String findRdgzForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String rdgzID = request.getParameter("rdgzID");
		rdgz = indexService.findRdgzByID(rdgzID);
		return "rdgzshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到办事指南的下拉菜单的方法 */
	public String queryBsznMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		bsznList = indexService.queryDefaultBsznList(null,page);
		return "bsznlist";
	}
	public String findBsznForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String bsznID = request.getParameter("bsznID");
		bszn = indexService.findBsznByID(bsznID);
		return "bsznshow";
	}


	
	
	
	
	
	
	
	
	
	/**跳转到下载专区的下拉菜单的方法 */
	public String queryXzzqMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		xzzqList = indexService.queryDefaultXzzqList(null,page);
		return "xzzqlist";
	}
	public String findXzzqForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String xzzqID = request.getParameter("xzzqID");
		xzzq = indexService.findXzzqByID(xzzqID);
		return "xzzqshow";
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到街办风采的下拉菜单的方法 */
	public String queryJbfcMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		jbfcList = indexService.queryDefaultJbfcList(null,page);
		return "jbfclist";
	}
	public String findJbfcForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String jbfcID = request.getParameter("jbfcID");
		jbfc = indexService.findJbfcByID(jbfcID);
		JbfjList = jbfc.getJbfjList();
		return "jbfcshow";
	}
	
	
	
	
	
	
	
	
	
	/**跳转到沣东印象的下拉菜单的方法 */
	public String queryFdyxMenu() throws Exception{
		IndexService indexService = (IndexService) this.getService("indexService");
		if(page==null){
			page = new Page(1);
		}
		fdyxList = indexService.queryDefaultFdyxList(null,page);
		return "fdyxlist";
	}
	public String findFdyxForShow() throws Exception {
		IndexService indexService = (IndexService) this.getService("indexService");
		String fdyxID = request.getParameter("fdyxID");
		fdyx = indexService.findFdyxByID(fdyxID);
		fdfjList = fdyx.getFdfjList();
		return "fdyxshow";
	}

}
