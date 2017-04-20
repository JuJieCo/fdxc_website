package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Whmb extends BaseBean {
	private Integer whmbID;
	private String whmbTitle;
	private String whmbContent;
	private Date subDate;
	private SysUser sysUser;
	private String hold;
	
	public Whmb() {
		this.sysUser = new SysUser();
	}

	public Integer getWhmbID() {
		return whmbID;
	}

	public void setWhmbID(Integer whmbID) {
		this.whmbID = whmbID;
	}

	public String getWhmbTitle() {
		return whmbTitle;
	}

	public void setWhmbTitle(String whmbTitle) {
		this.whmbTitle = whmbTitle;
	}

	public String getWhmbContent() {
		return whmbContent;
	}

	public void setWhmbContent(String whmbContent) {
		this.whmbContent = whmbContent;
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
	public Whmb mapRow(ResultSet rst, int rowNum) throws SQLException {
		Whmb whmb = new Whmb();
		whmb.setWhmbID(rst.getInt("whmb_id"));
		whmb.setWhmbTitle(rst.getString("whmb_title"));
		whmb.setWhmbContent(rst.getString("whmb_content"));
		whmb.setSubDate(rst.getDate("sub_date"));
		whmb.getSysUser().setUserID(rst.getInt("user_id"));
		whmb.setHold(rst.getString("hold"));
		return whmb;
	}

}
