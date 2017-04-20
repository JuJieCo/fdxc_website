package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Xwfj extends BaseBean {
	private Integer xwfjID;
	private String xwfjFileName;
	private String xwfjFileType;
	private String xwfjFileUrl;
	private Integer xinWenID;
	private String hold;

	public Integer getXwfjID() {
		return xwfjID;
	}

	public void setXwfjID(Integer xwfjID) {
		this.xwfjID = xwfjID;
	}

	public String getXwfjFileName() {
		return xwfjFileName;
	}

	public void setXwfjFileName(String xwfjFileName) {
		this.xwfjFileName = xwfjFileName;
	}

	public String getXwfjFileType() {
		return xwfjFileType;
	}

	public void setXwfjFileType(String xwfjFileType) {
		this.xwfjFileType = xwfjFileType;
	}

	public String getXwfjFileUrl() {
		return xwfjFileUrl;
	}

	public void setXwfjFileUrl(String xwfjFileUrl) {
		this.xwfjFileUrl = xwfjFileUrl;
	}

	public Integer getXinWenID() {
		return xinWenID;
	}

	public void setXinWenID(Integer xinWenID) {
		this.xinWenID = xinWenID;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}

	@Override
	public Xwfj mapRow(ResultSet rst, int rowNum) throws SQLException {
		Xwfj xwfj = new Xwfj();
		xwfj.setXwfjID(rst.getInt("xwfj_id"));
		xwfj.setXwfjFileName(rst.getString("xwfj_file_name"));
		xwfj.setXwfjFileType(rst.getString("xwfj_file_type"));
		xwfj.setXwfjFileUrl(rst.getString("xwfj_file_url"));
		xwfj.setXinWenID(rst.getInt("xinwen_id"));
		xwfj.setHold(rst.getString("hold"));
		return xwfj;
	}

}
