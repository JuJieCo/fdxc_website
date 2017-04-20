package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Ndjh extends BaseBean {
	private Integer ndjhID;
	private String ndjhTitle;
	private String ndjhContent;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;

	public Ndjh() {
		this.sysUser = new SysUser();
	}

	public Integer getNdjhID() {
		return ndjhID;
	}

	public void setNdjhID(Integer ndjhID) {
		this.ndjhID = ndjhID;
	}

	public String getNdjhTitle() {
		return ndjhTitle;
	}

	public void setNdjhTitle(String ndjhTitle) {
		this.ndjhTitle = ndjhTitle;
	}

	public String getNdjhContent() {
		return ndjhContent;
	}

	public void setNdjhContent(String ndjhContent) {
		this.ndjhContent = ndjhContent;
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
	public Ndjh mapRow(ResultSet rst, int rowNum) throws SQLException {
		Ndjh ndjh = new Ndjh();
		ndjh.setNdjhID(rst.getInt("ndjh_id"));
		ndjh.setNdjhTitle(rst.getString("ndjh_title"));
		ndjh.setNdjhContent(rst.getString("ndjh_content"));
		ndjh.setSubDate(rst.getDate("sub_date"));
		ndjh.setDeptType(rst.getInt("dept_type"));
		ndjh.getSysUser().setUserID(rst.getInt("user_id"));
		ndjh.setHold(rst.getString("hold"));
		return ndjh;
	}
}
