package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Bjzn extends BaseBean {
	private Integer bjznID;
	private String bjznTitle;
	private String bjznContent;
	private Date subDate;
	private SysUser sysUser;
	private String hold;

	
	
	public Bjzn() {
		this.sysUser = new SysUser();

	}
	public Integer getBjznID() {
		return bjznID;
	}

	public void setBjznID(Integer bjznID) {
		this.bjznID = bjznID;
	}

	public String getBjznTitle() {
		return bjznTitle;
	}

	public void setBjznTitle(String bjznTitle) {
		this.bjznTitle = bjznTitle;
	}

	public String getBjznContent() {
		return bjznContent;
	}

	public void setBjznContent(String bjznContent) {
		this.bjznContent = bjznContent;
	}

	public Date getSubDate() {
		return subDate;
	}

	public void setSubDate(Date subDate) {
		this.subDate = subDate;
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
	public Bjzn mapRow(ResultSet rst, int rowNum) throws SQLException {
		  Bjzn bjzn = new Bjzn();
		  bjzn.setBjznID(rst.getInt("bjzn_id"));
		  bjzn.setBjznTitle(rst.getString("bjzn_title"));
		  bjzn.setBjznContent(rst.getString("bjzn_content"));
		  bjzn.setSubDate(rst.getDate("sub_date"));
		  bjzn.getSysUser().setUserID(rst.getInt("user_id"));
		  bjzn.setHold(rst.getString("hold"));
		return bjzn;
	}}
