package com.jinyu.fdxc.struts.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.jinyu.fdxc.model.service.FdyxService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.FileUtil;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Fdfj;
import com.jinyu.fdxc.struts.bean.Fdyx;
import com.jinyu.fdxc.struts.bean.SysUser;

public class FdyxAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Fdyx fdyx;
	private List<Fdyx> fdyxList;
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
	public String queryDefaultFdyxList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		FdyxService fdyxService = (FdyxService)this.getService("fdyxService");
		fdyxList = fdyxService.queryDefaultFdyxList(fdyx , page);
		return "list";
	}
	
	
	/**
	 *条件查询 
	 */
	public String queryFdyxList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		FdyxService fdyxService = (FdyxService)this.getService("fdyxService");
		fdyxList = fdyxService.queryFdyxList(fdyx , page );
		return "list";
	}
	
	/**
	 *跳转到 新增&修改 页面
	 */
	public String findFdyxForModify() throws Exception {
		FdyxService fdyxService = (FdyxService)this.getService("fdyxService");
		String modify = request.getParameter("modify"); 
		if(null!=modify&&"save".equals(modify)){
			 fdyx = new Fdyx();
			//设置发布时间
			fdyx.setSubDate(new Date());
			//设置当前登录人即发布人信息
			SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
			fdyx.setSysUser(user);
		}else if(null!=modify&&"update".equals(modify)){
			String fdyxID = request.getParameter("fdyxID");
			fdyx = fdyxService.findFdyxByID(fdyxID);
		}
		return "modify";
	}
	
	
	public String findFdyxForShow() throws Exception {
		FdyxService fdyxService = (FdyxService)this.getService("fdyxService");
		String fdyxID = request.getParameter("fdyxID");
		fdyx = fdyxService.findFdyxByID(fdyxID);
		return "show";
	}
	
	
	
	


	
	public String modifyFdyx() throws Exception {
		FdyxService fdyxService = (FdyxService)this.getService("fdyxService");
		//设置当前登录人即发布人信息
		SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
		
		if(null!=fdyx){
			fdyx.setSysUser(user);
			Integer fdfjID = (Integer)request.getSession().getAttribute("fdfjID");
			fdyxService.modifyFdyx(fdyx , fdfjID);
			request.getSession().removeAttribute("fdfjID");
		}
		return this.queryFdyxList();
	}
	
	

	
	
	public String deleteFdyxByID() throws Exception {
		FdyxService fdyxService = (FdyxService)this.getService("fdyxService");
		String fdyxID = request.getParameter("fdyxID");
		fdyxService.deleteFdyxByID(fdyxID);
		return this.queryFdyxList();
	}
	
	
	
	

	public String fileUpload() throws Exception{
		FdyxService fdyxService = (FdyxService)this.getService("fdyxService");
		
			if(null!=uploadFile){
				String uploadDirectory =servletContext.getRealPath("/upload/file");
				String fileName = FileUtil.resetFileName(uploadFileFileName); 
                File target = new File(uploadDirectory,fileName); 
                FileUtils.copyFile(uploadFile, target);  
                Fdfj fdfj = new Fdfj(); 
                fdfj.setFdfjFileName(uploadFileFileName);
                fdfj.setFdfjFileType(uploadFileContentType);
                fdfj.setFdfjFileUrl("/upload/file/"+fileName);
                int fdfjID =  fdyxService.saveFdfj(fdfj);
              	request.getSession().setAttribute("fdfjID", fdfjID);
                }
		return null ;
		
	}



}
