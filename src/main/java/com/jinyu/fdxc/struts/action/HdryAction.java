package com.jinyu.fdxc.struts.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.jinyu.fdxc.model.service.HdryService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.FileUtil;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Hdry;
import com.jinyu.fdxc.struts.bean.SysUser;

public class HdryAction  extends BaseActionSupper{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Page page;
	private String s_token;
	private Hdry hdry;
	private List<Hdry> hdryList;
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
	public String queryDefaultHdryList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		HdryService hdryService = (HdryService)this.getService("hdryService");
		hdryList = hdryService.queryDefaultHdryList(hdry, page);
		return "list";
	}
	
	/**
	 *条件查询 
	 */
	public String queryHdryList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		HdryService hdryService = (HdryService)this.getService("hdryService");
		hdryList = hdryService.queryHdryList(hdry, page);
		return "list";
	}
	
	
	/**
	 *跳转到 新增&修改 页面
	 */
	public String findHdryForModify() throws Exception {
		HdryService hdryService = (HdryService)this.getService("hdryService");
		String modify = request.getParameter("modify"); 
		if(null!=modify&&"save".equals(modify)){
			hdry = new Hdry();
			//设置发布时间
			hdry.setSubDate(new Date());
			//设置当前登录人即发布人信息
			SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
			hdry.setSysUser(user);
		}else if(null!=modify&&"update".equals(modify)){
			String hdryID = request.getParameter("hdryID");
			hdry = hdryService.findHdryByID(hdryID);
		}
		return "modify";
	}
    
	
	public String findHdryForShow() throws Exception {
		HdryService hdryService = (HdryService)this.getService("hdryService");
		String hdryID = request.getParameter("hdryID");
		hdry = hdryService.findHdryByID(hdryID);
		return "show";
	}
	
	
	public String modifyHdry() throws Exception {
		HdryService hdryService = (HdryService)this.getService("hdryService");
		//设置当前登录人即发布人信息
		SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
		if(null!=hdry){
			Integer hdryID = (Integer)request.getSession().getAttribute("hdryID");
			hdry.setSysUser(user);
			hdryService.modifyHdry(hdry,hdryID);
			request.getSession().removeAttribute("hdryID");
		}
		return this.queryHdryList();
	}
	
	
	public String deleteHdryByID() throws Exception {
		HdryService hdryService = (HdryService)this.getService("hdryService");
		String hdryID = request.getParameter("hdryID");
		hdryService.deleteHdryByID(hdryID);
		return this.queryHdryList();
	}
	
	
	public String fileUpload() throws Exception{
		HdryService hdryService = (HdryService)this.getService("hdryService");
		
			if(null!=uploadFile){
				String uploadDirectory =servletContext.getRealPath("/upload/file");
				String fileName = FileUtil.resetFileName(uploadFileFileName); 
                File target = new File(uploadDirectory,fileName); 
                FileUtils.copyFile(uploadFile, target);  
                Hdry hdry = new Hdry(); 
                hdry.setHdryFileName(uploadFileFileName);
                hdry.setHdryFileType(uploadFileContentType);
                hdry.setHdryFileUrl("/upload/file/"+fileName);
                int hdryID =  hdryService.saveFJ(hdry);
              	request.getSession().setAttribute("hdryID", hdryID);
                }
		return null ;
	}
    

}
