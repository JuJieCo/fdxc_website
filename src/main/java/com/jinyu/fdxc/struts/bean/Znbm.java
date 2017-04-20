package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Znbm extends BaseBean {

	private Integer znbmID;
	private String znbmTitle;
	private String znbmBgs;
	private String znbmYwk;
	private String znbmFwz;
	private Integer deptType;
	private Date subDate;
	private SysUser user;
	private String hold;

	public Znbm() {
		this.user = new SysUser();

	}
	
	public Integer getZnbmID() {
		return znbmID;
	}

	public void setZnbmID(Integer znbmID) {
		this.znbmID = znbmID;
	}

	public String getZnbmTitle() {
		return znbmTitle;
	}

	public void setZnbmTitle(String znbmTitle) {
		this.znbmTitle = znbmTitle;
	}

	public String getZnbmBgs() {
		return znbmBgs;
	}

	public void setZnbmBgs(String znbmBgs) {
		this.znbmBgs = znbmBgs;
	}

	public String getZnbmYwk() {
		return znbmYwk;
	}

	public void setZnbmYwk(String znbmYwk) {
		this.znbmYwk = znbmYwk;
	}

	public String getZnbmFwz() {
		return znbmFwz;
	}

	public void setZnbmFwz(String znbmFwz) {
		this.znbmFwz = znbmFwz;
	}

	public Integer getDeptType() {
		return deptType;
	}

	public void setDeptType(Integer deptType) {
		this.deptType = deptType;
	}

	public Date getSubDate() {
		return subDate;
	}

	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}

	@Override
	public Znbm mapRow(ResultSet rst, int rowNum) throws SQLException {
		Znbm znbm = new Znbm();
		znbm.setZnbmID(rst.getInt("znbm_id"));
		znbm.setZnbmTitle(rst.getString("znbm_title"));
		znbm.setZnbmBgs(rst.getString("znbm_bgs"));
		znbm.setZnbmYwk(rst.getString("znbm_ywk"));
		znbm.setZnbmFwz(rst.getString("znbm_fwz"));
		znbm.setDeptType(rst.getInt("dept_type"));
		znbm.setSubDate(rst.getDate("sub_date"));
		znbm.getUser().setUserID(rst.getInt("user_id"));
		znbm.setHold(rst.getString("hold"));
		return znbm;
	}

}
