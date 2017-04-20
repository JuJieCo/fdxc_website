package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Hdry extends BaseBean {

	private Integer hdryID;
	private String hdryTitle;
	private String hdryContent;
	private String hdryFileName;
	private String hdryFileType;
	private String hdryFileUrl;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;

	public Integer getHdryID() {
		return hdryID;
	}

	public void setHdryID(Integer hdryID) {
		this.hdryID = hdryID;
	}

	public String getHdryTitle() {
		return hdryTitle;
	}

	public void setHdryTitle(String hdryTitle) {
		this.hdryTitle = hdryTitle;
	}

	public String getHdryContent() {
		return hdryContent;
	}

	public void setHdryContent(String hdryContent) {
		this.hdryContent = hdryContent;
	}

	public String getHdryFileName() {
		return hdryFileName;
	}

	public void setHdryFileName(String hdryFileName) {
		this.hdryFileName = hdryFileName;
	}

	public String getHdryFileType() {
		return hdryFileType;
	}

	public void setHdryFileType(String hdryFileType) {
		this.hdryFileType = hdryFileType;
	}

	public String getHdryFileUrl() {
		return hdryFileUrl;
	}

	public void setHdryFileUrl(String hdryFileUrl) {
		this.hdryFileUrl = hdryFileUrl;
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

	public Hdry() {
		this.sysUser = new SysUser();

	}

	@Override
	public Hdry mapRow(ResultSet rst, int rowNum) throws SQLException {
		Hdry hdry = new Hdry();
		hdry.setHdryID(rst.getInt("hdry_id"));
		hdry.setHdryTitle(rst.getString("hdry_title"));
		hdry.setHdryContent(rst.getString("hdry_content"));
		hdry.setHdryFileName(rst.getString("hdry_file_name"));
		hdry.setHdryFileType(rst.getString("hdry_file_type"));
		hdry.setHdryFileUrl(rst.getString("hdry_file_url"));
		hdry.setSubDate(rst.getDate("sub_date"));
		hdry.setDeptType(rst.getInt("dept_type"));
		hdry.getSysUser().setUserID(rst.getInt("user_id"));
		hdry.setHold(rst.getString("hold"));
		return hdry;
	}

}
