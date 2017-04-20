package com.jinyu.fdxc.struts.action;

import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.service.ZcfgService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Zcfg;

public class ZcfgAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Zcfg zcfg;
	private List<Zcfg> zcfgList;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getS_token() {
		return s_token;
	}

	public void setS_token(String s_token) {
		this.s_token = s_token;
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

	/**
	 * 跳转到 list 页面
	 */
	public String queryDefaultZcfgList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		String type = request.getParameter("type");
		ZcfgService zcfgService = (ZcfgService) this.getService("zcfgService");
		zcfgList = zcfgService.queryDefaultZcfgList(zcfg, page,type);
		request.setAttribute("type", type);
		return "list";
	}

	/**
	 * 条件查询
	 */
	public String queryZcfgList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		String type = request.getParameter("type");
		ZcfgService zcfgService = (ZcfgService) this.getService("zcfgService");
		zcfgList = zcfgService.queryZcfgList(zcfg, page,type);
		request.setAttribute("type", type);
		return "list";
	}

	/**
	 * 跳转到 新增&修改 页面
	 */
	public String findZcfgForModify() throws Exception {
		ZcfgService zcfgService = (ZcfgService) this.getService("zcfgService");
		String modify = request.getParameter("modify");
		String type = request.getParameter("type");
		if (null != modify && "save".equals(modify)) {
			zcfg = new Zcfg();
			//设置法规类别
			zcfg.setZcfgType(Integer.valueOf(type));
			// 设置发布时间
			zcfg.setSubDate(new Date());
			// 设置当前登录人即发布人信息
			SysUser user = (SysUser) request.getSession().getAttribute("sessionLoginUser");
			zcfg.setSysUser(user);
			request.setAttribute("type", type);
		} else if (null != modify && "update".equals(modify)) {
			String zcfgID = request.getParameter("zcfgID");
			zcfg = zcfgService.findZcfgByID(zcfgID);
			type = zcfg.getZcfgType().toString();
			request.setAttribute("type", type);
		}
		
		
		//页面显示法规类别
				String zcfgType = "";
				if(null!=zcfg){
					if("0".equals(type)||0==zcfg.getZcfgType()){
						zcfgType = "国家法规";  
					}
					if("1".equals(type)||1==zcfg.getZcfgType()){
						zcfgType = "省级法规";  
					}
					if("2".equals(type)||2==zcfg.getZcfgType()){
						zcfgType = "市级法规";  
					}
					if("3".equals(type)||3==zcfg.getZcfgType()){
						zcfgType = "区级法规";  
					}
					if("4".equals(type)||4==zcfg.getZcfgType()){
						zcfgType = "重要文献";  
					}
					if("5".equals(type)||5==zcfg.getZcfgType()){
						zcfgType = "法规解读";  
					}
					request.setAttribute("zcfgType", zcfgType);
				}
		return "modify";
	}

	
	
	public String findZcfgForShow() throws Exception {
		ZcfgService zcfgService = (ZcfgService) this.getService("zcfgService");
		String zcfgID = request.getParameter("zcfgID");
		zcfg = zcfgService.findZcfgByID(zcfgID);
		
		//页面显示法规类别
		String zcfgType = "";
		if(null!=zcfg){
			if(0==zcfg.getZcfgType()){
				zcfgType = "国家法规";  
			}
			if(1==zcfg.getZcfgType()){
				zcfgType = "省级法规";  
			}
			if(2==zcfg.getZcfgType()){
				zcfgType = "市级法规";  
			}
			if(3==zcfg.getZcfgType()){
				zcfgType = "区级法规";  
			}
			if(4==zcfg.getZcfgType()){
				zcfgType = "重要文献";  
			}
			if(5==zcfg.getZcfgType()){
				zcfgType = "法规解读";  
			}
			request.setAttribute("zcfgType", zcfgType);
		}
		
		return "show";
	}

	public String modifyZcfg() throws Exception {
		ZcfgService zcfgService = (ZcfgService) this.getService("zcfgService");
		// 设置当前登录人即发布人信息
		SysUser user = (SysUser) request.getSession().getAttribute("sessionLoginUser");
		if (null != zcfg) {
			zcfg.setSysUser(user);
			zcfgService.modifyZcfg(zcfg);
		}
		String type = request.getParameter("type");
		request.setAttribute("type", type);
		return this.queryZcfgList();
	}

	public String deleteZcfgByID() throws Exception {
		ZcfgService zcfgService = (ZcfgService) this.getService("zcfgService");
		String zcfgID = request.getParameter("zcfgID");
		zcfgService.deleteZcfgByID(zcfgID);
		
		String type = request.getParameter("type");
		request.setAttribute("type", type);
		return this.queryZcfgList();
	}

}
