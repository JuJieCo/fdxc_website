package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jinyu.fdxc.model.utils.BaseBean;

public class TouPiao extends BaseBean {

	private Integer tpID;
	private Integer tiyan;
	private Integer shezhi;
	private Date subDate;
	private String hold;

	public Integer getTpID() {
		return tpID;
	}

	public void setTpID(Integer tpID) {
		this.tpID = tpID;
	}

	public Integer getTiyan() {
		return tiyan;
	}

	public void setTiyan(Integer tiyan) {
		this.tiyan = tiyan;
	}

	public Integer getShezhi() {
		return shezhi;
	}

	public void setShezhi(Integer shezhi) {
		this.shezhi = shezhi;
	}

	public Date getSubDate() {
		return subDate;
	}

	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}

	@Override
	public TouPiao mapRow(ResultSet rst, int rowNum) throws SQLException {
		TouPiao touPiao = new TouPiao();
		touPiao.setTpID(rst.getInt("tp_id"));
		touPiao.setTiyan(rst.getInt("tiyan"));
		touPiao.setShezhi(rst.getInt("shezhi"));
		touPiao.setSubDate(rst.getDate("sub_date"));
		touPiao.setHold(rst.getString("hold"));
		return touPiao;
	}

}
