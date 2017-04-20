package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Tzgg extends BaseBean {
	private Integer tzggID;
	private String tzggTitle;
	private String tzggContent;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;

	public Tzgg() {
		this.sysUser = new SysUser();
	}

	public Integer getTzggID() {
		return tzggID;
	}

	public void setTzggID(Integer tzggID) {
		this.tzggID = tzggID;
	}

	public String getTzggTitle() {
		return tzggTitle;
	}

	public void setTzggTitle(String tzggTitle) {
		this.tzggTitle = tzggTitle;
	}

	public String getTzggContent() {
		return tzggContent;
	}

	public void setTzggContent(String tzggContent) {
		this.tzggContent = tzggContent;
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
	public Tzgg mapRow(ResultSet rst, int rowNum) throws SQLException {
		Tzgg tzgg = new Tzgg();
		tzgg.setTzggID(rst.getInt("tzgg_id"));
		tzgg.setTzggTitle(rst.getString("tzgg_title"));
		tzgg.setTzggContent(rst.getString("tzgg_content"));
		tzgg.setSubDate(rst.getDate("sub_date"));
		tzgg.setDeptType(rst.getInt("dept_type"));
		tzgg.getSysUser().setUserID(rst.getInt("user_id"));
		tzgg.setHold(rst.getString("hold"));
		return tzgg;
	}
}
