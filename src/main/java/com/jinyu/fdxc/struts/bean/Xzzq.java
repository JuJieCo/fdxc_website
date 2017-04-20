package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Xzzq extends BaseBean {

	private Integer xzzqID;
	private String xzzqTitle;
	private String xzzqContent;
	private String xzzqFileName;
	private String xzzqFileType;
	private String xzzqFileUrl;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;

	
	public Xzzq() {
		this.sysUser = new SysUser();

	}
	
	
	public Integer getXzzqID() {
		return xzzqID;
	}



	public void setXzzqID(Integer xzzqID) {
		this.xzzqID = xzzqID;
	}



	public String getXzzqTitle() {
		return xzzqTitle;
	}



	public void setXzzqTitle(String xzzqTitle) {
		this.xzzqTitle = xzzqTitle;
	}



	public String getXzzqContent() {
		return xzzqContent;
	}



	public void setXzzqContent(String xzzqContent) {
		this.xzzqContent = xzzqContent;
	}



	public String getXzzqFileName() {
		return xzzqFileName;
	}



	public void setXzzqFileName(String xzzqFileName) {
		this.xzzqFileName = xzzqFileName;
	}



	public String getXzzqFileType() {
		return xzzqFileType;
	}



	public void setXzzqFileType(String xzzqFileType) {
		this.xzzqFileType = xzzqFileType;
	}



	public String getXzzqFileUrl() {
		return xzzqFileUrl;
	}



	public void setXzzqFileUrl(String xzzqFileUrl) {
		this.xzzqFileUrl = xzzqFileUrl;
	}



	public Date getSubDate() {
		return subDate;
	}



	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}



	public Integer getDeptType() {
		return deptType;
	}



	public void setDeptType(Integer deptType) {
		this.deptType = deptType;
	}



	public SysUser getSysUser() {
		return sysUser;
	}



	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}



	public String getHold() {
		return hold;
	}



	public void setHold(String hold) {
		this.hold = hold;
	}



	@Override
	public Xzzq mapRow(ResultSet rst, int rowNum) throws SQLException {
		Xzzq xzzq = new Xzzq();
		xzzq.setXzzqID(rst.getInt("xzzq_id"));
		xzzq.setXzzqTitle(rst.getString("xzzq_title"));
		xzzq.setXzzqContent(rst.getString("xzzq_content"));
		xzzq.setXzzqFileName(rst.getString("xzzq_file_name"));
		xzzq.setXzzqFileType(rst.getString("xzzq_file_type"));
		xzzq.setXzzqFileUrl(rst.getString("xzzq_file_url"));
		xzzq.setSubDate(rst.getDate("sub_date"));
		xzzq.setDeptType(rst.getInt("dept_type"));
		xzzq.getSysUser().setUserID(rst.getInt("user_id"));
		xzzq.setHold(rst.getString("hold"));
		return xzzq;
	}

}
