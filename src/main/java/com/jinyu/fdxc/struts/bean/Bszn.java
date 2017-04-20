package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Bszn extends BaseBean {
	private Integer bsznID;
	private String bsznTitle;
	private String bsznContent;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;

	public Bszn() {
		this.sysUser = new SysUser();
	}

	public Integer getBsznID() {
		return bsznID;
	}

	public void setBsznID(Integer bsznID) {
		this.bsznID = bsznID;
	}

	public String getBsznTitle() {
		return bsznTitle;
	}

	public void setBsznTitle(String bsznTitle) {
		this.bsznTitle = bsznTitle;
	}

	public String getBsznContent() {
		return bsznContent;
	}

	public void setBsznContent(String bsznContent) {
		this.bsznContent = bsznContent;
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
	public Bszn mapRow(ResultSet rst, int rowNum) throws SQLException {
		Bszn bszn = new Bszn();
		bszn.setBsznID(rst.getInt("bszn_id"));
		bszn.setBsznTitle(rst.getString("bszn_title"));
		bszn.setBsznContent(rst.getString("bszn_content"));
		bszn.setSubDate(rst.getDate("sub_date"));
		bszn.setDeptType(rst.getInt("dept_type"));
		bszn.getSysUser().setUserID(rst.getInt("user_id"));
		bszn.setHold(rst.getString("hold"));
		return bszn;
	}
}
