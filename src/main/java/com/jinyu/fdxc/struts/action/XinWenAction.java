package com.jinyu.fdxc.struts.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.jinyu.fdxc.model.service.XinWenService;
import com.jinyu.fdxc.model.utils.BaseActionSupper;
import com.jinyu.fdxc.model.utils.FileUtil;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.struts.bean.SysUser;
import com.jinyu.fdxc.struts.bean.XinWen;
import com.jinyu.fdxc.struts.bean.Xwfj;

public class XinWenAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private String s_token;
	private XinWen xinWen;
	private List<XinWen> xinWenList;
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
	public XinWen getXinWen() {
		return xinWen;
	}
	public void setXinWen(XinWen xinWen) {
		this.xinWen = xinWen;
	}
	public List<XinWen> getXinWenList() {
		return xinWenList;
	}
	public void setXinWenList(List<XinWen> xinWenList) {
		this.xinWenList = xinWenList;
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
	 *参数 type 的类别
	 * 0 要闻简报
	 * 1 政务新闻
	 * 2 图片新闻
	 * 3 处室动态
	 * 4 党建工作
	 * 5 领导讲话
	 */
	
	
	/**
	 *跳转到 list 页面 
	 */
	public String queryDefaultXinWenList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		String type = request.getParameter("type");
		XinWenService xinWenService = (XinWenService)this.getService("xinWenService");
		xinWenList = xinWenService.queryDefaultXinWenrList(xinWen , page ,type);
		request.setAttribute("type", type);
		return "list";
	}
	
	
	/**
	 *条件查询 
	 */
	public String queryXinWenList() throws Exception {
		if(page==null){
			page = new Page(1);
		}
		String type = request.getParameter("type");
		XinWenService xinWenService = (XinWenService)this.getService("xinWenService");
		xinWenList = xinWenService.queryXinWenList(xinWen , page ,type);
		request.setAttribute("type", type);
		return "list";
	}
	
	/**
	 *跳转到 新增&修改 页面
	 */
	public String findXinWenForModify() throws Exception {
		XinWenService xinWenService = (XinWenService)this.getService("xinWenService");
		String modify = request.getParameter("modify"); 
		String type = request.getParameter("type");
		
		if(null!=modify&&"save".equals(modify)){
			 xinWen = new XinWen();
			//设置新闻类别
			xinWen.setXinwenType(Integer.valueOf(type));
			//设置发布时间
			xinWen.setSubDate(new Date());
			//设置当前登录人即发布人信息
			SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
			xinWen.setSysUser(user);
			request.setAttribute("type", type);
		}else if(null!=modify&&"update".equals(modify)){
			String xinWenID = request.getParameter("xinwenID");
			xinWen = xinWenService.findXinWenByID(xinWenID);
			type = xinWen.getXinwenType().toString();
			request.setAttribute("type", type);
		}
		
		//页面显示新闻类别
		String xinwenType = "";
		if(null!=xinWen){
			if("0".equals(type)||0==xinWen.getXinwenType()){
				xinwenType = "要闻简报";  
			}
			if("1".equals(type)||1==xinWen.getXinwenType()){
				xinwenType = "政务新闻";  
			}
			if("2".equals(type)||2==xinWen.getXinwenType()){
				xinwenType = "图片新闻"; 
			}
			if("3".equals(type)||3==xinWen.getXinwenType()){
				xinwenType = "处室动态";  
			}
			if("4".equals(type)||4==xinWen.getXinwenType()){
				xinwenType = "党建工作";  
			}
			if("5".equals(type)||5==xinWen.getXinwenType()){
				xinwenType = "领导讲话";  
			}
			request.setAttribute("xinwenType", xinwenType);
		}
		return "modify";
	}
	
	
	public String findXinWenForShow() throws Exception {
		XinWenService xinWenService = (XinWenService)this.getService("xinWenService");
		String xinWenID = request.getParameter("xinwenID");
		xinWen = xinWenService.findXinWenByID(xinWenID);
		
		//页面显示新闻类别
			String xinwenType = "";
			if(null!=xinWen){
				if(0==xinWen.getXinwenType()){
					xinwenType = "要闻简报";  
				}
				if(1==xinWen.getXinwenType()){
					xinwenType = "政务新闻";  
				}
				if(2==xinWen.getXinwenType()){
					xinwenType = "图片新闻"; 
				}
				if(3==xinWen.getXinwenType()){
					xinwenType = "处室动态";  
				}
				if(4==xinWen.getXinwenType()){
					xinwenType = "党建工作";  
				}
				if(5==xinWen.getXinwenType()){
					xinwenType = "领导讲话";  
				}
				request.setAttribute("xinwenType", xinwenType);
			}
		return "show";
	}
	
	
	
	


	
	public String modifyXinWen() throws Exception {
		XinWenService xinWenService = (XinWenService)this.getService("xinWenService");
		//设置当前登录人即发布人信息
		SysUser user = (SysUser)request.getSession().getAttribute("sessionLoginUser"); 
		
		if(null!=xinWen){
			xinWen.setSysUser(user);
/***************************这个地方传String会报一个Integer不能转换成String的错*/
/**************************** ,这个地方是不是不用传附件ID service里就可以得到 附件ID了吧?*/Integer xwfjID = (Integer)request.getSession().getAttribute("xwfjID");
			xinWenService.modifyXinWen(xinWen , xwfjID);
			request.getSession().removeAttribute("xwfjID");
		}

		String type = request.getParameter("type");
		request.setAttribute("type", type);
		return this.queryXinWenList();
	}
	
	

	
	
	public String deleteXinWenByID() throws Exception {
		XinWenService xinWenService = (XinWenService)this.getService("xinWenService");
		String xinWenID = request.getParameter("xinwenID");
		xinWenService.deleteXinWenByID(xinWenID);
		
		String type = request.getParameter("type");
		request.setAttribute("type", type);
		return this.queryXinWenList();
	}
	
	
	
	

	public String fileUpload() throws Exception{
		XinWenService xinWenService = (XinWenService)this.getService("xinWenService");
		
			if(null!=uploadFile){
				String uploadDirectory =servletContext.getRealPath("/upload/file");
				String fileName = FileUtil.resetFileName(uploadFileFileName); 
                File target = new File(uploadDirectory,fileName); 
                FileUtils.copyFile(uploadFile, target);  
                Xwfj xwfj = new Xwfj(); 
                xwfj.setXwfjFileName(uploadFileFileName);
                xwfj.setXwfjFileType(uploadFileContentType);
                xwfj.setXwfjFileUrl("/upload/file/"+fileName);
                int xwfjID =  xinWenService.saveXwfj(xwfj);
              	request.getSession().setAttribute("xwfjID", xwfjID);
                }
		return null ;
		
	}



}
