package com.jinyu.fdxc.struts.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.jinyu.fdxc.model.service.XzzqService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.FileUtil;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.Xzzq;

public class XzzqAction  extends BaseActionSupper{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Page page;
	private String s_token;
	private Xzzq xzzq;
	private List<Xzzq> xzzqList;
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
	public String queryDefaultXzzqList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		XzzqService xzzqService = (XzzqService)this.getService("xzzqService");
		xzzqList = xzzqService.queryDefaultXzzqList(xzzq, page);
		return "list";
	}
	
	/**
	 *条件查询 
	 */
	public String queryXzzqList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		XzzqService xzzqService = (XzzqService)this.getService("xzzqService");
		xzzqList = xzzqService.queryXzzqList(xzzq, page);
		return "list";
	}
	
	
	/**
	 *跳转到 新增&修改 页面
	 */
	public String findXzzqForModify() throws Exception {
		XzzqService xzzqService = (XzzqService)this.getService("xzzqService");
		String modify = request.getParameter("modify"); 
		if(null!=modify&&"save".equals(modify)){
			xzzq = new Xzzq();
			//设置发布时间
			xzzq.setSubDate(new Date());
			//设置当前登录人即发布人信息
			SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
			xzzq.setSysUser(user);
		}else if(null!=modify&&"update".equals(modify)){
			String xzzqID = request.getParameter("xzzqID");
			xzzq = xzzqService.findXzzqByID(xzzqID);
		}
		return "modify";
	}
    
	
	public String findXzzqForShow() throws Exception {
		XzzqService xzzqService = (XzzqService)this.getService("xzzqService");
		String xzzqID = request.getParameter("xzzqID");
		xzzq = xzzqService.findXzzqByID(xzzqID);
		return "show";
	}
	
	
	public String modifyXzzq() throws Exception {
		XzzqService xzzqService = (XzzqService)this.getService("xzzqService");
		//设置当前登录人即发布人信息
		SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
		if(null!=xzzq){
			Integer xzzqID = (Integer)request.getSession().getAttribute("xzzqID");
			xzzq.setSysUser(user);
			xzzqService.modifyXzzq(xzzq,xzzqID);
			request.getSession().removeAttribute("xzzqID");
		}
		return this.queryXzzqList();
	}
	
	
	public String deleteXzzqByID() throws Exception {
		XzzqService xzzqService = (XzzqService)this.getService("xzzqService");
		String xzzqID = request.getParameter("xzzqID");
		xzzqService.deleteXzzqByID(xzzqID);
		return this.queryXzzqList();
	}
	
	
	public String fileUpload() throws Exception{
		XzzqService xzzqService = (XzzqService)this.getService("xzzqService");
		
			if(null!=uploadFile){
				String uploadDirectory =servletContext.getRealPath("/upload/file");
				String fileName = FileUtil.resetFileName(uploadFileFileName); 
                File target = new File(uploadDirectory,fileName); 
                FileUtils.copyFile(uploadFile, target);  
                Xzzq xzzq = new Xzzq(); 
                xzzq.setXzzqFileName(uploadFileFileName);
                xzzq.setXzzqFileType(uploadFileContentType);
                xzzq.setXzzqFileUrl("/upload/file/"+fileName);
                int xzzqID =  xzzqService.saveFJ(xzzq);
              	request.getSession().setAttribute("xzzqID", xzzqID);
                }
		return null ;
	}
    

}
