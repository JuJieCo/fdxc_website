package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.utils.BaseBean;

public class XinWen extends BaseBean {
	private Integer xinwenID;
	private String xinwenTitle;
	private Integer xinwenType;
	private String xinwenContent;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;
	private List<Xwfj> xwfjList;

	public XinWen() {
		this.sysUser = new SysUser();
		this.xwfjList = new ArrayList<Xwfj>();
	}

	public Integer getXinwenID() {
		return xinwenID;
	}

	public void setXinwenID(Integer xinwenID) {
		this.xinwenID = xinwenID;
	}

	public String getXinwenTitle() {
		return xinwenTitle;
	}

	public void setXinwenTitle(String xinwenTitle) {
		this.xinwenTitle = xinwenTitle;
	}

	public Integer getXinwenType() {
		return xinwenType;
	}

	public void setXinwenType(Integer xinwenType) {
		this.xinwenType = xinwenType;
	}

	public String getXinwenContent() {
		return xinwenContent;
	}

	public void setXinwenContent(String xinwenContent) {
		this.xinwenContent = xinwenContent;
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

	public List<Xwfj> getXwfjList() {
		return xwfjList;
	}

	public void setXwfjList(List<Xwfj> xwfjList) {
		this.xwfjList = xwfjList;
	}

	@Override
	public XinWen mapRow(ResultSet rst, int rowNum) throws SQLException {
		XinWen xinWen = new XinWen();
		xinWen.setXinwenID(rst.getInt("xinwen_id"));
		xinWen.setXinwenTitle(rst.getString("xinwen_title"));
		xinWen.setXinwenType(rst.getInt("xinwen_type"));
		xinWen.setXinwenContent(rst.getString("xinwen_content"));
		xinWen.setSubDate(rst.getDate("sub_date"));
		xinWen.setDeptType(rst.getInt("dept_type"));
		xinWen.getSysUser().setUserID(rst.getInt("user_id"));
		xinWen.setHold(rst.getString("hold"));
		return xinWen;
	}

}
