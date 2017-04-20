package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Zcfg extends BaseBean {
	private Integer zcfgID;
	private String zcfgTitle;
	private Integer zcfgType;
	private String zcfgContent;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;
	
	public Zcfg() {
		this.sysUser = new SysUser();

	}
	public Integer getZcfgID() {
		return zcfgID;
	}

	public void setZcfgID(Integer zcfgID) {
		this.zcfgID = zcfgID;
	}

	public String getZcfgTitle() {
		return zcfgTitle;
	}

	public void setZcfgTitle(String zcfgTitle) {
		this.zcfgTitle = zcfgTitle;
	}

	public Integer getZcfgType() {
		return zcfgType;
	}

	public void setZcfgType(Integer zcfgType) {
		this.zcfgType = zcfgType;
	}

	public String getZcfgContent() {
		return zcfgContent;
	}

	public void setZcfgContent(String zcfgContent) {
		this.zcfgContent = zcfgContent;
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
	public Zcfg mapRow(ResultSet rst, int rowNum) throws SQLException {
		Zcfg zcfg = new Zcfg();
		zcfg.setZcfgID(rst.getInt("zcfg_id"));
		zcfg.setZcfgTitle(rst.getString("zcfg_title"));
		zcfg.setZcfgType(rst.getInt("zcfg_type"));
		zcfg.setZcfgContent(rst.getString("zcfg_content"));
		zcfg.setSubDate(rst.getDate("sub_date"));
		zcfg.setDeptType(rst.getInt("dept_type"));
		zcfg.getSysUser().setUserID(rst.getInt("user_id"));
		zcfg.setHold(rst.getString("hold"));
		return zcfg;
	}
}
