package com.jinyu.fdxc.struts.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.jinyu.fdxc.model.service.WjfbService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.FileUtil;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Wjfb;


public class WjfbAction  extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Wjfb wjfb;
	private List<Wjfb> wjfbList;
	private File uploadFile;
    private String uploadFileFileName; 
    private String uploadFileContentType;
	
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

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	/**
	 *跳转到 list 页面 
	 */
	public String queryDefaultWjfbList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		WjfbService wjfbService = (WjfbService)this.getService("wjfbService");
		wjfbList = wjfbService.queryDefaultWjfbList(wjfb, page);
		return "list";
	}
	
	/**
	 *条件查询 
	 */
	public String queryWjfbList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		WjfbService wjfbService = (WjfbService)this.getService("wjfbService");
		wjfbList = wjfbService.queryWjfbList(wjfb, page);
		return "list";
	}
	
	
	/**
	 *跳转到 新增&修改 页面
	 */
	public String findWjfbForModify() throws Exception {
		WjfbService wjfbService = (WjfbService)this.getService("wjfbService");
		String modify = request.getParameter("modify"); 
		if(null!=modify&&"save".equals(modify)){
			wjfb = new Wjfb();
			//设置发布时间
			wjfb.setSubDate(new Date());
			//设置当前登录人即发布人信息
			SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
			wjfb.setSysUser(user);
		}else if(null!=modify&&"update".equals(modify)){
			String wjfbID = request.getParameter("wjfbID");
			wjfb = wjfbService.findWjfbByID(wjfbID);
		}
		return "modify";
	}
    
	
	public String findWjfbForShow() throws Exception {
		WjfbService wjfbService = (WjfbService)this.getService("wjfbService");
		String wjfbID = request.getParameter("wjfbID");
		wjfb = wjfbService.findWjfbByID(wjfbID);
		return "show";
	}
	
	
	public String modifyWjfb() throws Exception {
		WjfbService wjfbService = (WjfbService)this.getService("wjfbService");
		//设置当前登录人即发布人信息
		SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
		if(null!=wjfb){
			Integer wjfbID = (Integer)request.getSession().getAttribute("wjfbID");
			wjfb.setSysUser(user);
			wjfbService.modifyWjfb(wjfb,wjfbID);
			request.getSession().removeAttribute("wjfbID");
		}
		return this.queryWjfbList();
	}
	
	
	public String deleteWjfbByID() throws Exception {
		WjfbService wjfbService = (WjfbService)this.getService("wjfbService");
		String wjfbID = request.getParameter("wjfbID");
		wjfbService.deleteWjfbByID(wjfbID);
		return this.queryWjfbList();
	}
	
	
	public String fileUpload() throws Exception{
		WjfbService wjfbService = (WjfbService)this.getService("wjfbService");
		
			if(null!=uploadFile){
				String uploadDirectory =servletContext.getRealPath("/upload/file");
				String fileName = FileUtil.resetFileName(uploadFileFileName); 
                File target = new File(uploadDirectory,fileName); 
                FileUtils.copyFile(uploadFile, target);  
                Wjfb wjfb = new Wjfb(); 
                wjfb.setWjfbFileName(uploadFileFileName);
                wjfb.setWjfbFileType(uploadFileContentType);
                wjfb.setWjfbFileUrl("/upload/file/"+fileName);
                int wjfbID =  wjfbService.saveFJ(wjfb);
              	request.getSession().setAttribute("wjfbID", wjfbID);
                }
		return null ;
	}
    
    
}
