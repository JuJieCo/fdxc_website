package com.jinyu.fdxc.struts.action;

import java.util.List;

import com.jinyu.fdxc.model.service.IndexWtlyService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Bszn;
import com.jinyu.fdxc.struts.bean.Lxfs;
import com.jinyu.fdxc.struts.bean.Tzgg;
import com.jinyu.fdxc.struts.bean.Whmb;
import com.jinyu.fdxc.struts.bean.XinWen;
import com.jinyu.fdxc.struts.bean.Xwfj;
import com.jinyu.fdxc.struts.bean.Zcfg;
import com.jinyu.fdxc.struts.bean.Znbm;

public class IndexWtlyAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private XinWen xinWen;
	private List<XinWen> xinwen0;
	private List<XinWen> xinwen2;
	private List<XinWen> xinwenList;
	private List<Xwfj> xwfjList;
	private Tzgg tzgg;
	private List<Tzgg> tzgg0;
	private List<Tzgg> tzggList;
	private Zcfg zcfg;
	private List<Zcfg> zcfg0;
	private List<Zcfg> zcfgList;
	private Bszn bszn;
	private List<Bszn> bszn0;
	private List<Bszn> bsznList;
	private Lxfs lxfs;
	//private List<Lxfs> lxfs0;
	private List<Lxfs> lxfsList;
	private Znbm znbm;
	private Whmb whmb;
	private List<Whmb> whmb0;
	private List<Whmb> whmbList;

	private String tiyan;
	private String shezhi;
	
	
	public String getTiyan() {
		return tiyan;
	}

	public void setTiyan(String tiyan) {
		this.tiyan = tiyan;
	}

	public String getShezhi() {
		return shezhi;
	}

	public void setShezhi(String shezhi) {
		this.shezhi = shezhi;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public XinWen getXinWen() {
		return xinWen;
	}

	public void setXinWen(XinWen xinWen) {
		this.xinWen = xinWen;
	}

	public List<XinWen> getXinwen0() {
		return xinwen0;
	}

	public void setXinwen0(List<XinWen> xinwen0) {
		this.xinwen0 = xinwen0;
	}

	public List<XinWen> getXinwen2() {
		return xinwen2;
	}

	public void setXinwen2(List<XinWen> xinwen2) {
		this.xinwen2 = xinwen2;
	}

	public List<XinWen> getXinwenList() {
		return xinwenList;
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

	public Tzgg getTzgg() {
		return tzgg;
	}

	public void setTzgg(Tzgg tzgg) {
		this.tzgg = tzgg;
	}

	public List<Tzgg> getTzgg0() {
		return tzgg0;
	}

	public void setTzgg0(List<Tzgg> tzgg0) {
		this.tzgg0 = tzgg0;
	}

	public List<Tzgg> getTzggList() {
		return tzggList;
	}

	public void setTzggList(List<Tzgg> tzggList) {
		this.tzggList = tzggList;
	}

	public Zcfg getZcfg() {
		return zcfg;
	}

	public void setZcfg(Zcfg zcfg) {
		this.zcfg = zcfg;
	}

	public List<Zcfg> getZcfg0() {
		return zcfg0;
	}

	public void setZcfg0(List<Zcfg> zcfg0) {
		this.zcfg0 = zcfg0;
	}

	public List<Zcfg> getZcfgList() {
		return zcfgList;
	}

	public void setZcfgList(List<Zcfg> zcfgList) {
		this.zcfgList = zcfgList;
	}

	public Bszn getBszn() {
		return bszn;
	}

	public void setBszn(Bszn bszn) {
		this.bszn = bszn;
	}

	public List<Bszn> getBszn0() {
		return bszn0;
	}

	public void setBszn0(List<Bszn> bszn0) {
		this.bszn0 = bszn0;
	}

	public List<Bszn> getBsznList() {
		return bsznList;
	}

	public void setBsznList(List<Bszn> bsznList) {
		this.bsznList = bsznList;
	}


	public Lxfs getLxfs() {
		return lxfs;
	}

	public void setLxfs(Lxfs lxfs) {
		this.lxfs = lxfs;
	}

//	public List<Lxfs> getLxfs0() {
//		return lxfs0;
//	}
//
//	public void setLxfs0(List<Lxfs> lxfs0) {
//		this.lxfs0 = lxfs0;
//	}

	public List<Lxfs> getLxfsList() {
		return lxfsList;
	}

	public void setLxfsList(List<Lxfs> lxfsList) {
		this.lxfsList = lxfsList;
	}

	public Znbm getZnbm() {
		return znbm;
	}

	public void setZnbm(Znbm znbm) {
		this.znbm = znbm;
	}

	public Whmb getWhmb() {
		return whmb;
	}

	public void setWhmb(Whmb whmb) {
		this.whmb = whmb;
	}

	public List<Whmb> getWhmb0() {
		return whmb0;
	}

	public void setWhmb0(List<Whmb> whmb0) {
		this.whmb0 = whmb0;
	}

	public List<Whmb> getWhmbList() {
		return whmbList;
	}

	public void setWhmbList(List<Whmb> whmbList) {
		this.whmbList = whmbList;
	}

	/**
	 * xinwen0 要闻简报
	 *  xinwen2 图片新闻 
	 *  Tzgg通知公告 
	 *  Wjfb 文件发布
	 *   Zcfg 政策法规 
	 *   Bszn 办事指南 
	 *   Rdgz 热点关注 
	 *   Lxfs联系方式
	 * 
	 * 0 计卫文体局 
	 * 1 人口计生 
	 * 2 医疗卫生
	 *  3 文体旅游
	*	4 食品药品
	 */

	public String showIndexPage() throws Exception {
		IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		/** 主页显示的新闻 */
		xinwen0 = this.getXinWen("0", "3");
		if (xinwen0.size() > 10) {
			xinwen0 = xinwen0.subList(0, 10);
		}

		xinwen2 = this.getXinWen("2", "3");
		if(null!=xinwen2&&xinwen2.size()>0){
			if(1<=xinwen2.size()){
				List<Xwfj> xwfj= indexWtlyService.findXwfjByID(xinwen2.get(0).getXinwenID());//查图片
				if(xwfj.size()>0){
					request.setAttribute("tpxwimg0", xwfj.get(0).getXwfjFileUrl());
					request.setAttribute("tpxw0ID", xinwen2.get(0).getXinwenID());
					request.setAttribute("tpxw0Title", xinwen2.get(0).getXinwenTitle());
				}
			}
			if(2<=xinwen2.size()){
				List<Xwfj> xwfj = indexWtlyService.findXwfjByID(xinwen2.get(1).getXinwenID());//查图片
				if(xwfj.size()>0){
					request.setAttribute("tpxwimg1", xwfj.get(0).getXwfjFileUrl());
					request.setAttribute("tpxw1ID", xinwen2.get(1).getXinwenID());
					request.setAttribute("tpxw1Title", xinwen2.get(1).getXinwenTitle());
				}
			}
			if(3<=xinwen2.size()){
				List<Xwfj> xwfj = indexWtlyService.findXwfjByID(xinwen2.get(2).getXinwenID());//查图片
				if(xwfj.size()>0){
					request.setAttribute("tpxwimg2", xwfj.get(0).getXwfjFileUrl());
					request.setAttribute("tpxw2ID", xinwen2.get(2).getXinwenID());
					request.setAttribute("tpxw2Title", xinwen2.get(2).getXinwenTitle());
				}
			}
		}

		/** 主页显示的通知公告 */
		tzgg0 = indexWtlyService.queryDefaultTzggList(null, null, "3");
		if (tzgg0.size() > 9) {
			tzgg0 = tzgg0.subList(0, 9);
		}
		/** 主页显示的文化漫步 */
		
		
		/**主页显示的政策法规*/
		zcfg0 = indexWtlyService.queryDefaultZcfgList(null,null,null,"3");
		if(zcfg0.size()>9){
			zcfg0 = zcfg0.subList(0, 9);
		}
		/**主页显示的办事指南*/
		bszn0 = indexWtlyService.queryDefaultBsznList(null,null,"3");
		if(bszn0.size()>9){
			bszn0 = bszn0.subList(0,9 );
		}
		
		/**主页上显示的文化漫步*/
		whmb0 = indexWtlyService.queryDefaultWhmbList(null, null);
		if(whmb0.size()>9){
			whmb0 = whmb0.subList(0,9 );
		}
		
		
//		/**主页显示的联系方式*/
//		lxfs0 = indexWtlyService.queryDefaultLxfsList(null,null,"3");
//		if(lxfs0.size()>1){
//			lxfs0 = lxfs0.subList(0,1);
//		}
		
		return "indexpage";
	}

	
	
	
	
	
	
	
	
	
	
	/** 查新闻的方法 */
	public List<XinWen> getXinWen(String type, String dept) throws Exception {
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		List<XinWen> list = indexWtlyService.queryDefaultXinWenrList(null,
				null, type, dept);
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	/** 跳转到要闻简报的方法 */
	public String queryXinWen0Menu() throws Exception {
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		if (page == null) {
			page = new Page(1);
		}
		xinwenList = indexWtlyService.queryDefaultXinWenrList(null, page, "0", "3");
		request.setAttribute("tpyeText", "要闻简报");

		return "ywlist";
	}
	public String findXinWen0ForShow() throws Exception {
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		String xinWenID = request.getParameter("xinwenID");
		xinWen = indexWtlyService.findXinWenByID(xinWenID);
		xwfjList = xinWen.getXwfjList();
		request.setAttribute("tpyeText", "要闻简报");
		return "ywshow";
	}

	
	
	
	
	
	
	
	
	
	
	/** 跳转到图片新闻的方法 */
	public String queryXinwen2Menu() throws Exception {
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		if (page == null) {
			page = new Page(1);
		}
		xinwenList = indexWtlyService.queryDefaultXinWenrList(null, page, "2", "3");
		request.setAttribute("tpyeText", "图片新闻");

		return "tplist";
	}
	public String findXinWen2ForShow() throws Exception {
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		String xinWenID = request.getParameter("xinwenID");
		xinWen = indexWtlyService.findXinWenByID(xinWenID);
		xwfjList = xinWen.getXwfjList();
		request.setAttribute("tpyeText", "图片新闻");
		return "tpshow";
	}

	
	
	
	
	
	
	
	
	
	/** 跳转到通知公告的下拉菜单的方法 */
	public String queryTzggMenu() throws Exception {
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		if (page == null) {
			page = new Page(1);
		}
		tzggList = indexWtlyService.queryDefaultTzggList(null, page, "3");
		return "tzgglist";
	}
	public String findTzggForShow() throws Exception {
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		String tzggID = request.getParameter("tzggID");
		tzgg = indexWtlyService.findTzggByID(tzggID);
		return "tzggshow";
	}
	

	
	
	
	
	
	
	
	/**跳转到政策法规的下拉菜单的方法 */	
	public String queryZcfgMenu() throws Exception{
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		if(page==null){
			page = new Page(1);
		}
		zcfgList = indexWtlyService.queryDefaultZcfgList(null,page,null,"3");
		return "zcfglist";
	}
	public String findZcfgForShow() throws Exception {
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		String zcfgID = request.getParameter("zcfgID");
		zcfg = indexWtlyService.findZcfgByID(zcfgID);
		return "zcfgshow";
	}

	
	
	
	
	
	
	
	
	
	/**跳转到办事指南的下拉菜单的方法 */
	public String queryBsznMenu() throws Exception{
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		if(page==null){
			page = new Page(1);
		}
		bsznList = indexWtlyService.queryDefaultBsznList(null,page,"3");
		return "bsznlist";
	}
	public String findBsznForShow() throws Exception {
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		String bsznID = request.getParameter("bsznID");
		bszn = indexWtlyService.findBsznByID(bsznID);
		return "bsznshow";
	}
	
	
	

	
	
	
	
	
	
	/**跳转到联系方式的下拉菜单的方法 */
	public String queryLxfsMenu() throws Exception{
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		if(page==null){
			page = new Page(1);
		}
		lxfsList = indexWtlyService.queryDefaultLxfsList(null,page,"3");
		return "lxfslist";
	}
	public String findLxfsForShow() throws Exception {
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		String lxfsID = request.getParameter("lxfsID");
		lxfs = indexWtlyService.findLxfsByID(lxfsID);
		return "lxfsshow";
	}
	
	
	
	
	
	
	
	
	//职能部门
	public String queryZnbmMenu() throws Exception{
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		znbm = indexWtlyService.findZnbmByID();
		return "znbmlist";
	}
	public String findZnbmForShow() throws Exception{
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		znbm = indexWtlyService.findZnbmByID();
		String type = request.getParameter("type");
		if("0".equals(type)){
			return "bgsshow";
		}else if("1".equals(type)){
			return "ywkshow";
		}else if("2".equals(type)){
			return "fwzshow";
		}else{
			return this.queryZnbmMenu();
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**跳转到联系方式的下拉菜单的方法 */
	public String queryWhmbMenu() throws Exception{
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		if(page==null){
			page = new Page(1);
		}
		whmbList = indexWtlyService.queryDefaultWhmbList(null,page);
		return "whmblist";
	}
	public String findWhmbForShow() throws Exception {
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		String whmbID = request.getParameter("whmbID");
		whmb = indexWtlyService.findWhmbByID(whmbID);
		return "whmbshow";
	}
	
	
	
	
	
	
	

	public String modifyTiyan()throws Exception{
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		//String tiyan = request.getParameter("tiyan");
		indexWtlyService.saveTiyan(tiyan);
		return this.showIndexPage();
	}
	
	//提交网站栏目设置如何
	public String modifyShezhi()throws Exception{
	IndexWtlyService indexWtlyService = (IndexWtlyService) this.getService("indexWtlyService");
		//String shezhi = request.getParameter("shezhi");
		indexWtlyService.saveShezhi(shezhi);
		return this.showIndexPage();
	}
	
}
