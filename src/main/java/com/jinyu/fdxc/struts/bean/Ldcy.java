package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Ldcy extends BaseBean {
	private Integer ldcyID;
	private String ldcyTitle;
	private String ldcyContent;
	private String ldcyFileName;
	private String ldcyFileType;
	private String ldcyFileUrl;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;

	public Ldcy() {
		this.sysUser = new SysUser();

	}

	public Integer getLdcyID() {
		return ldcyID;
	}

	public void setLdcyID(Integer ldcyID) {
		this.ldcyID = ldcyID;
	}

	public String getLdcyTitle() {
		return ldcyTitle;
	}

	public void setLdcyTitle(String ldcyTitle) {
		this.ldcyTitle = ldcyTitle;
	}

	public String getLdcyContent() {
		return ldcyContent;
	}

	public void setLdcyContent(String ldcyContent) {
		this.ldcyContent = ldcyContent;
	}

	public String getLdcyFileName() {
		return ldcyFileName;
	}

	public void setLdcyFileName(String ldcyFileName) {
		this.ldcyFileName = ldcyFileName;
	}

	public String getLdcyFileType() {
		return ldcyFileType;
	}

	public void setLdcyFileType(String ldcyFileType) {
		this.ldcyFileType = ldcyFileType;
	}

	public String getLdcyFileUrl() {
		return ldcyFileUrl;
	}

	public void setLdcyFileUrl(String ldcyFileUrl) {
		this.ldcyFileUrl = ldcyFileUrl;
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
	public Ldcy mapRow(ResultSet rst, int rowNum) throws SQLException {
		Ldcy ldcy = new Ldcy();
		ldcy.setLdcyID(rst.getInt("ldcy_id"));
		ldcy.setLdcyTitle(rst.getString("ldcy_title"));
		ldcy.setLdcyContent(rst.getString("ldcy_content"));
		ldcy.setLdcyFileName(rst.getString("ldcy_file_name"));
		ldcy.setLdcyFileType(rst.getString("ldcy_file_type"));
		ldcy.setLdcyFileUrl(rst.getString("ldcy_file_url"));
		ldcy.setSubDate(rst.getDate("sub_date"));
		ldcy.setDeptType(rst.getInt("dept_type"));
		ldcy.getSysUser().setUserID(rst.getInt("user_id"));
		ldcy.setHold(rst.getString("hold"));
		return ldcy;
	}

}
