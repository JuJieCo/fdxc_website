package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Zzjg extends BaseBean {
	private Integer zzjgID;
	private String zzjgTitle;
	private String zzjgContent;
	private String zzjgFileName;
	private String zzjgFileType;
	private String zzjgFileUrl;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;
	
	public Zzjg() {
		this.sysUser = new SysUser();

	}

	public Integer getZzjgID() {
		return zzjgID;
	}

	public void setZzjgID(Integer zzjgID) {
		this.zzjgID = zzjgID;
	}

	public String getZzjgTitle() {
		return zzjgTitle;
	}

	public void setZzjgTitle(String zzjgTitle) {
		this.zzjgTitle = zzjgTitle;
	}

	public String getZzjgContent() {
		return zzjgContent;
	}

	public void setZzjgContent(String zzjgContent) {
		this.zzjgContent = zzjgContent;
	}

	public String getZzjgFileName() {
		return zzjgFileName;
	}

	public void setZzjgFileName(String zzjgFileName) {
		this.zzjgFileName = zzjgFileName;
	}

	public String getZzjgFileType() {
		return zzjgFileType;
	}

	public void setZzjgFileType(String zzjgFileType) {
		this.zzjgFileType = zzjgFileType;
	}

	public String getZzjgFileUrl() {
		return zzjgFileUrl;
	}

	public void setZzjgFileUrl(String zzjgFileUrl) {
		this.zzjgFileUrl = zzjgFileUrl;
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
	public Zzjg mapRow(ResultSet rst, int rowNum) throws SQLException {
		Zzjg zzjg = new Zzjg();
		zzjg.setZzjgID(rst.getInt("zzjg_id"));
		zzjg.setZzjgTitle(rst.getString("zzjg_title"));
		zzjg.setZzjgContent(rst.getString("zzjg_content"));
		zzjg.setZzjgFileName(rst.getString("zzjg_file_name"));
		zzjg.setZzjgFileType(rst.getString("zzjg_file_type"));
		zzjg.setZzjgFileUrl(rst.getString("zzjg_file_url"));
		zzjg.setSubDate(rst.getDate("sub_date"));
		zzjg.setDeptType(rst.getInt("dept_type"));
		zzjg.getSysUser().setUserID(rst.getInt("user_id"));
		zzjg.setHold(rst.getString("hold"));
		return zzjg;
	}

}
