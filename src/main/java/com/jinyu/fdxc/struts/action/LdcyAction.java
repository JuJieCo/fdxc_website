package com.jinyu.fdxc.struts.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.jinyu.fdxc.model.service.LdcyService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.FileUtil;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Ldcy;
import com.jinyu.fdxc.struts.bean.SysUser;


public class LdcyAction  extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Ldcy ldcy;
	private List<Ldcy> ldcyList;
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
	public String queryDefaultLdcyList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		LdcyService ldcyService = (LdcyService)this.getService("ldcyService");
		ldcyList = ldcyService.queryDefaultLdcyList(ldcy, page);
		return "list";
	}
	
	/**
	 *条件查询 
	 */
	public String queryLdcyList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		LdcyService ldcyService = (LdcyService)this.getService("ldcyService");
		ldcyList = ldcyService.queryLdcyList(ldcy, page);
		return "list";
	}
	
	
	/**
	 *跳转到 新增&修改 页面
	 */
	public String findLdcyForModify() throws Exception {
		LdcyService ldcyService = (LdcyService)this.getService("ldcyService");
		String modify = request.getParameter("modify"); 
		if(null!=modify&&"save".equals(modify)){
			ldcy = new Ldcy();
			//设置发布时间
			ldcy.setSubDate(new Date());
			//设置当前登录人即发布人信息
			SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
			ldcy.setSysUser(user);
		}else if(null!=modify&&"update".equals(modify)){
			String ldcyID = request.getParameter("ldcyID");
			ldcy = ldcyService.findLdcyByID(ldcyID);
		}
		return "modify";
	}
    
	
	public String findLdcyForShow() throws Exception {
		LdcyService ldcyService = (LdcyService)this.getService("ldcyService");
		String ldcyID = request.getParameter("ldcyID");
		ldcy = ldcyService.findLdcyByID(ldcyID);
		return "show";
	}
	
	
	public String modifyLdcy() throws Exception {
		LdcyService ldcyService = (LdcyService)this.getService("ldcyService");
		//设置当前登录人即发布人信息
		SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
		if(null!=ldcy){
			Integer ldcyID = (Integer)request.getSession().getAttribute("ldcyID");
			ldcy.setSysUser(user);
			ldcyService.modifyLdcy(ldcy,ldcyID);
			request.getSession().removeAttribute("ldcyID");
		}
		return this.queryLdcyList();
	}
	
	
	public String deleteLdcyByID() throws Exception {
		LdcyService ldcyService = (LdcyService)this.getService("ldcyService");
		String ldcyID = request.getParameter("ldcyID");
		ldcyService.deleteLdcyByID(ldcyID);
		return this.queryLdcyList();
	}
	
	
	public String fileUpload() throws Exception{
		LdcyService ldcyService = (LdcyService)this.getService("ldcyService");
		
			if(null!=uploadFile){
				String uploadDirectory =servletContext.getRealPath("/upload/file");
				String fileName = FileUtil.resetFileName(uploadFileFileName); 
                File target = new File(uploadDirectory,fileName); 
                FileUtils.copyFile(uploadFile, target);  
                Ldcy ldcy = new Ldcy(); 
                ldcy.setLdcyFileName(uploadFileFileName);
                ldcy.setLdcyFileType(uploadFileContentType);
                ldcy.setLdcyFileUrl("/upload/file/"+fileName);
                int ldcyID =  ldcyService.saveFJ(ldcy);
              	request.getSession().setAttribute("ldcyID", ldcyID);
                }
		return null ;
	}
    
    
}
