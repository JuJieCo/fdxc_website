package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Wjfb extends BaseBean {
	private Integer wjfbID;
	private String wjfbTitle;
	private String wjfbContent;
	private String wjfbFileName;
	private String wjfbFileType;
	private String wjfbFileUrl;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;

	public Wjfb() {
		this.sysUser = new SysUser();

	}

	public Integer getWjfbID() {
		return wjfbID;
	}

	public void setWjfbID(Integer wjfbID) {
		this.wjfbID = wjfbID;
	}

	public String getWjfbTitle() {
		return wjfbTitle;
	}

	public void setWjfbTitle(String wjfbTitle) {
		this.wjfbTitle = wjfbTitle;
	}

	public String getWjfbContent() {
		return wjfbContent;
	}

	public void setWjfbContent(String wjfbContent) {
		this.wjfbContent = wjfbContent;
	}

	public String getWjfbFileName() {
		return wjfbFileName;
	}

	public void setWjfbFileName(String wjfbFileName) {
		this.wjfbFileName = wjfbFileName;
	}

	public String getWjfbFileType() {
		return wjfbFileType;
	}

	public void setWjfbFileType(String wjfbFileType) {
		this.wjfbFileType = wjfbFileType;
	}

	public String getWjfbFileUrl() {
		return wjfbFileUrl;
	}

	public void setWjfbFileUrl(String wjfbFileUrl) {
		this.wjfbFileUrl = wjfbFileUrl;
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
	public Wjfb mapRow(ResultSet rst, int rowNum) throws SQLException {
		Wjfb wjfb = new Wjfb();
		wjfb.setWjfbID(rst.getInt("wjfb_id"));
		wjfb.setWjfbTitle(rst.getString("wjfb_title"));
		wjfb.setWjfbContent(rst.getString("wjfb_content"));
		wjfb.setWjfbFileName(rst.getString("wjfb_file_name"));
		wjfb.setWjfbFileType(rst.getString("wjfb_file_type"));
		wjfb.setWjfbFileUrl(rst.getString("wjfb_file_url"));
		wjfb.setSubDate(rst.getDate("sub_date"));
		wjfb.setDeptType(rst.getInt("dept_type"));
		wjfb.getSysUser().setUserID(rst.getInt("user_id"));
		wjfb.setHold(rst.getString("hold"));
		return wjfb;
	}

}
