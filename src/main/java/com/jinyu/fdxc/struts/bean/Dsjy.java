package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Dsjy extends BaseBean {
	private Integer dsjyID;
	private String dsjyTitle;
	private String dsjyContent;
	private Date subDate;
	private SysUser sysUser;
	private String hold;

	
	
	public Dsjy() {
		this.sysUser = new SysUser();

	}



	public Integer getDsjyID() {
		return dsjyID;
	}



	public void setDsjyID(Integer dsjyID) {
		this.dsjyID = dsjyID;
	}



	public String getDsjyTitle() {
		return dsjyTitle;
	}



	public void setDsjyTitle(String dsjyTitle) {
		this.dsjyTitle = dsjyTitle;
	}



	public String getDsjyContent() {
		return dsjyContent;
	}



	public void setDsjyContent(String dsjyContent) {
		this.dsjyContent = dsjyContent;
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
	public Dsjy mapRow(ResultSet rst, int rowNum) throws SQLException {
		  Dsjy dsjy = new Dsjy();
		  dsjy.setDsjyID(rst.getInt("dsjy_id"));
		  dsjy.setDsjyTitle(rst.getString("dsjy_title"));
		  dsjy.setDsjyContent(rst.getString("dsjy_content"));
		  dsjy.setSubDate(rst.getDate("sub_date"));
		  dsjy.getSysUser().setUserID(rst.getInt("user_id"));
		  dsjy.setHold(rst.getString("hold"));
		return dsjy;
	}}
