package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Jbfc extends BaseBean {
	private Integer jbfcID;
	private String jbfcTitle;
	private String jbfcContent;
	private Date subDate;
	private Integer jbType;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;
	private List<Jbfj> jbfjList;

	public Jbfc(){
		this.sysUser = new SysUser();
		this.jbfjList = new ArrayList<Jbfj>();
	}
	public Integer getJbfcID() {
		return jbfcID;
	}

	public void setJbfcID(Integer jbfcID) {
		this.jbfcID = jbfcID;
	}

	public String getJbfcTitle() {
		return jbfcTitle;
	}

	public void setJbfcTitle(String jbfcTitle) {
		this.jbfcTitle = jbfcTitle;
	}

	public String getJbfcContent() {
		return jbfcContent;
	}

	public void setJbfcContent(String jbfcContent) {
		this.jbfcContent = jbfcContent;
	}

	public Date getSubDate() {
		return subDate;
	}

	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}

	public Integer getJbType() {
		return jbType;
	}

	public void setJbType(Integer jbType) {
		this.jbType = jbType;
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

	public List<Jbfj> getJbfjList() {
		return jbfjList;
	}
	public void setJbfjList(List<Jbfj> jbfjList) {
		this.jbfjList = jbfjList;
	}
	@Override
	public Jbfc mapRow(ResultSet rst, int rowNum) throws SQLException {
		Jbfc jbfc = new Jbfc();
		jbfc.setJbfcID(rst.getInt("jbfc_id"));
		jbfc.setJbfcTitle(rst.getString("jbfc_title"));
		jbfc.setJbfcContent(rst.getString("jbfc_content"));
		jbfc.setSubDate(rst.getDate("sub_date"));
		jbfc.setJbType(rst.getInt("jb_type"));
		jbfc.setDeptType(rst.getInt("dept_type"));
		jbfc.getSysUser().setUserID(rst.getInt("user_id"));
		jbfc.setHold(rst.getString("hold"));
		return jbfc;
	}
}
