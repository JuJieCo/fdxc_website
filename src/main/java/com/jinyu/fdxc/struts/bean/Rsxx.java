package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Rsxx extends BaseBean {
	private Integer rsxxID;
	private String rsxxTitle;
	private String rsxxContent;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;

	public Rsxx(){
		this.sysUser = new SysUser();
	}
	
	public Integer getRsxxID() {
		return rsxxID;
	}

	public void setRsxxID(Integer rsxxID) {
		this.rsxxID = rsxxID;
	}

	public String getRsxxTitle() {
		return rsxxTitle;
	}

	public void setRsxxTitle(String rsxxTitle) {
		this.rsxxTitle = rsxxTitle;
	}

	public String getRsxxContent() {
		return rsxxContent;
	}

	public void setRsxxContent(String rsxxContent) {
		this.rsxxContent = rsxxContent;
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
	public Rsxx mapRow(ResultSet rst, int rowNum) throws SQLException {
		Rsxx rsxx = new Rsxx();
		rsxx.setRsxxID(rst.getInt("rsxx_id"));
		rsxx.setRsxxTitle(rst.getString("rsxx_title"));
		rsxx.setRsxxContent(rst.getString("rsxx_content"));
		rsxx.setSubDate(rst.getDate("sub_date"));
		rsxx.setDeptType(rst.getInt("dept_type"));
		rsxx.getSysUser().setUserID(rst.getInt("user_id"));
		rsxx.setHold(rst.getString("hold"));
		return rsxx;
	}
}
