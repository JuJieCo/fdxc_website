package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Lxfs extends BaseBean {
	private Integer lxfsID;
	private String lxfsTitle;
	private String lxfsContent;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;

	public Lxfs() {
		this.sysUser = new SysUser();

	}

	public Integer getLxfsID() {
		return lxfsID;
	}

	public void setLxfsID(Integer lxfsID) {
		this.lxfsID = lxfsID;
	}

	public String getLxfsTitle() {
		return lxfsTitle;
	}

	public void setLxfsTitle(String lxfsTitle) {
		this.lxfsTitle = lxfsTitle;
	}

	public String getLxfsContent() {
		return lxfsContent;
	}

	public void setLxfsContent(String lxfsContent) {
		this.lxfsContent = lxfsContent;
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
	public Lxfs mapRow(ResultSet rst, int rowNum) throws SQLException {
		Lxfs lxfs = new Lxfs();
		lxfs.setLxfsID(rst.getInt("lxfs_id"));
		lxfs.setLxfsTitle(rst.getString("lxfs_title"));
		lxfs.setLxfsContent(rst.getString("lxfs_content"));
		lxfs.setSubDate(rst.getDate("sub_date"));
		lxfs.setDeptType(rst.getInt("dept_type"));
		lxfs.getSysUser().setUserID(rst.getInt("user_id"));
		lxfs.setHold(rst.getString("hold"));
		return lxfs;
	}
}
