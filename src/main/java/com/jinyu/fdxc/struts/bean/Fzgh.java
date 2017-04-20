package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Fzgh extends BaseBean {
	private Integer fzghID;
	private String fzghTitle;
	private String fzghContent;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;

	public Fzgh() {
		this.sysUser = new SysUser();
	}

	public Integer getFzghID() {
		return fzghID;
	}

	public void setFzghID(Integer fzghID) {
		this.fzghID = fzghID;
	}

	public String getFzghTitle() {
		return fzghTitle;
	}

	public void setFzghTitle(String fzghTitle) {
		this.fzghTitle = fzghTitle;
	}

	public String getFzghContent() {
		return fzghContent;
	}

	public void setFzghContent(String fzghContent) {
		this.fzghContent = fzghContent;
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
	public Fzgh mapRow(ResultSet rst, int rowNum) throws SQLException {
		Fzgh fzgh = new Fzgh();
		fzgh.setFzghID(rst.getInt("fzgh_id"));
		fzgh.setFzghTitle(rst.getString("fzgh_title"));
		fzgh.setFzghContent(rst.getString("fzgh_content"));
		fzgh.setSubDate(rst.getDate("sub_date"));
		fzgh.setDeptType(rst.getInt("dept_type"));
		fzgh.getSysUser().setUserID(rst.getInt("user_id"));
		fzgh.setHold(rst.getString("hold"));
		return fzgh;
	}
}
