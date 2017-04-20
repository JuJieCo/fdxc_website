package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Rdgz extends BaseBean {
	private Integer rdgzID;
	private String rdgzTitle;
	private String rdgzContent;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;

	public Rdgz() {
		this.sysUser = new SysUser();
	}

	public Integer getRdgzID() {
		return rdgzID;
	}

	public void setRdgzID(Integer rdgzID) {
		this.rdgzID = rdgzID;
	}

	public String getRdgzTitle() {
		return rdgzTitle;
	}

	public void setRdgzTitle(String rdgzTitle) {
		this.rdgzTitle = rdgzTitle;
	}

	public String getRdgzContent() {
		return rdgzContent;
	}

	public void setRdgzContent(String rdgzContent) {
		this.rdgzContent = rdgzContent;
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
	public Rdgz mapRow(ResultSet rst, int rowNum) throws SQLException {
		Rdgz rdgz = new Rdgz();
		rdgz.setRdgzID(rst.getInt("rdgz_id"));
		rdgz.setRdgzTitle(rst.getString("rdgz_title"));
		rdgz.setRdgzContent(rst.getString("rdgz_content"));
		rdgz.setSubDate(rst.getDate("sub_date"));
		rdgz.setDeptType(rst.getInt("dept_type"));
		rdgz.getSysUser().setUserID(rst.getInt("user_id"));
		rdgz.setHold(rst.getString("hold"));
		return rdgz;
	}
}
