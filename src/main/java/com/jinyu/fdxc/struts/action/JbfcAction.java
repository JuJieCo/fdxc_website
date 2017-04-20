package com.jinyu.fdxc.struts.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.jinyu.fdxc.model.service.JbfcService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.FileUtil;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.Jbfc;
import com.jinyu.fdxc.struts.bean.Jbfj;
import com.jinyu.fdxc.struts.bean.SysUser;

public class JbfcAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private Jbfc jbfc;
	private List<Jbfc> jbfcList;
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
	 * 0:建章路街道办
	 * 1:三桥街道办
	 * 2:王寺街道办
	 * 3:高桥街道办
	 * 4:斗门街道办
	 */
	/**
	 *跳转到 list 页面 
	 */
	public String queryDefaultJbfcList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		JbfcService jbfcService = (JbfcService)this.getService("jbfcService");
		jbfcList = jbfcService.queryDefaultJbfcList(jbfc, page);
		return "list";
	}
	
	
	/**
	 *条件查询 
	 */
	public String queryJbfcList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		JbfcService jbfcService = (JbfcService)this.getService("jbfcService");
		jbfcList = jbfcService.queryJbfcList(jbfc , page );
		return "list";
	}
	
	/**
	 *跳转到 新增&修改 页面
	 */
	public String findJbfcForModify() throws Exception {
		JbfcService jbfcService = (JbfcService)this.getService("jbfcService");
		String modify = request.getParameter("modify"); 
		if(null!=modify&&"save".equals(modify)){
			 jbfc = new Jbfc();
			//设置发布时间
			jbfc.setSubDate(new Date());
			//设置当前登录人即发布人信息
			SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
			jbfc.setSysUser(user);
		}else if(null!=modify&&"update".equals(modify)){
			String jbfcID = request.getParameter("jbfcID");
			jbfc = jbfcService.findJbfcByID(jbfcID);
		}
		return "modify";
	}
	
	
	public String findJbfcForShow() throws Exception {
		JbfcService jbfcService = (JbfcService)this.getService("jbfcService");
		String jbfcID = request.getParameter("jbfcID");
		jbfc = jbfcService.findJbfcByID(jbfcID);
		return "show";
	}
	
	
	
	


	
	public String modifyJbfc() throws Exception {
		JbfcService jbfcService = (JbfcService)this.getService("jbfcService");
		//设置当前登录人即发布人信息
		SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
		
		if(null!=jbfc){
			jbfc.setSysUser(user);
			Integer jbfjID = (Integer)request.getSession().getAttribute("jbfjID");
			jbfcService.modifyJbfc(jbfc , jbfjID);
			request.getSession().removeAttribute("jbfjID");
		}
		return this.queryJbfcList();
	}
	
	

	
	
	public String deleteJbfcByID() throws Exception {
		JbfcService jbfcService = (JbfcService)this.getService("jbfcService");
		String jbfcID = request.getParameter("jbfcID");
		jbfcService.deleteJbfcByID(jbfcID);
		return this.queryJbfcList();
	}
	
	
	
	

	public String fileUpload() throws Exception{
		JbfcService jbfcService = (JbfcService)this.getService("jbfcService");
		
			if(null!=uploadFile){
				String uploadDirectory =servletContext.getRealPath("/upload/file");
				String fileName = FileUtil.resetFileName(uploadFileFileName); 
                File target = new File(uploadDirectory,fileName); 
                FileUtils.copyFile(uploadFile, target);  
                Jbfj jbfj = new Jbfj(); 
                jbfj.setJbfjFileName(uploadFileFileName);
                jbfj.setJbfjFileType(uploadFileContentType);
                jbfj.setJbfjFileUrl("/upload/file/"+fileName);
                int jbfjID =  jbfcService.saveJbfj(jbfj);
              	request.getSession().setAttribute("jbfjID", jbfjID);
                }
		return null ;
		
	}



}
