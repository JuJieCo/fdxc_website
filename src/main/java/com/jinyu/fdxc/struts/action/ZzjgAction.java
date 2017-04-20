package com.jinyu.fdxc.struts.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.jinyu.fdxc.model.service.ZzjgService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.FileUtil;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Zzjg;


public class ZzjgAction  extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Zzjg zzjg;
	private List<Zzjg> zzjgList;
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
	public Zzjg getZzjg() {
		return zzjg;
	}
	public void setZzjg(Zzjg zzjg) {
		this.zzjg = zzjg;
	}
	public List<Zzjg> getZzjgList() {
		return zzjgList;
	}
	public void setZzjgList(List<Zzjg> zzjgList) {
		this.zzjgList = zzjgList;
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
	public String queryDefaultZzjgList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		ZzjgService zzjgService = (ZzjgService)this.getService("zzjgService");
		zzjgList = zzjgService.queryDefaultZzjgList(zzjg, page);
		return "list";
	}
	
	/**
	 *条件查询 
	 */
	public String queryZzjgList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		ZzjgService zzjgService = (ZzjgService)this.getService("zzjgService");
		zzjgList = zzjgService.queryZzjgList(zzjg, page);
		return "list";
	}
	
	
	/**
	 *跳转到 新增&修改 页面
	 */
	public String findZzjgForModify() throws Exception {
		ZzjgService zzjgService = (ZzjgService)this.getService("zzjgService");
		String modify = request.getParameter("modify"); 
		if(null!=modify&&"save".equals(modify)){
			zzjg = new Zzjg();
			//设置发布时间
			zzjg.setSubDate(new Date());
			//设置当前登录人即发布人信息
			SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
			zzjg.setSysUser(user);
		}else if(null!=modify&&"update".equals(modify)){
			String zzjgID = request.getParameter("zzjgID");
			zzjg = zzjgService.findZzjgByID(zzjgID);
		}
		return "modify";
	}
    
	
	public String findZzjgForShow() throws Exception {
		ZzjgService zzjgService = (ZzjgService)this.getService("zzjgService");
		String zzjgID = request.getParameter("zzjgID");
		zzjg = zzjgService.findZzjgByID(zzjgID);
		return "show";
	}
	
	
	public String modifyZzjg() throws Exception {
		ZzjgService zzjgService = (ZzjgService)this.getService("zzjgService");
		//设置当前登录人即发布人信息
		SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
		if(null!=zzjg){
			Integer zzjgID = (Integer)request.getSession().getAttribute("zzjgID");
			zzjg.setSysUser(user);
			zzjgService.modifyZzjg(zzjg,zzjgID);
			request.getSession().removeAttribute("zzjgID");
		}
		return this.queryZzjgList();
	}
	
	
	public String deleteZzjgByID() throws Exception {
		ZzjgService zzjgService = (ZzjgService)this.getService("zzjgService");
		String zzjgID = request.getParameter("zzjgID");
		zzjgService.deleteZzjgByID(zzjgID);
		return this.queryZzjgList();
	}
	
	
	public String fileUpload() throws Exception{
		ZzjgService zzjgService = (ZzjgService)this.getService("zzjgService");
		
			if(null!=uploadFile){
				String uploadDirectory =servletContext.getRealPath("/upload/file");
				String fileName = FileUtil.resetFileName(uploadFileFileName); 
                File target = new File(uploadDirectory,fileName); 
                FileUtils.copyFile(uploadFile, target);  
                Zzjg zzjg = new Zzjg(); 
                zzjg.setZzjgFileName(uploadFileFileName);
                zzjg.setZzjgFileType(uploadFileContentType);
                zzjg.setZzjgFileUrl("/upload/file/"+fileName);
                int zzjgID =  zzjgService.saveFJ(zzjg);
              	request.getSession().setAttribute("zzjgID", zzjgID);
                }
		return null ;
	}
    
    
}
