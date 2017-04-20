package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Gkfw extends BaseBean {
	private Integer gkfwID;
	private String gkfwTitle;
	private String gkfwContent;
	private Date subDate;
	private SysUser sysUser;
	private String hold;

	public Gkfw(){
		this.sysUser = new SysUser();
	}
	public Integer getGkfwID() {
		return gkfwID;
	}

	public void setGkfwID(Integer gkfwID) {
		this.gkfwID = gkfwID;
	}

	public String getGkfwTitle() {
		return gkfwTitle;
	}

	public void setGkfwTitle(String gkfwTitle) {
		this.gkfwTitle = gkfwTitle;
	}

	public String getGkfwContent() {
		return gkfwContent;
	}

	public void setGkfwContent(String gkfwContent) {
		this.gkfwContent = gkfwContent;
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
	public Gkfw mapRow(ResultSet rst, int rowNum) throws SQLException {
		Gkfw gkfw = new Gkfw();
		gkfw.setGkfwID(rst.getInt("gkfw_id"));
		gkfw.setGkfwTitle(rst.getString("gkfw_title"));
		gkfw.setGkfwContent(rst.getString("gkfw_content"));
		gkfw.setSubDate(rst.getDate("sub_date"));
		gkfw.getSysUser().setUserID(rst.getInt("user_id"));
		gkfw.setHold(rst.getString("hold"));
		return gkfw;
	}
}
