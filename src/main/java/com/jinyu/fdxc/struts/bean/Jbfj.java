package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Jbfj extends BaseBean {

	private Integer jbfjID;
	private String jbfjFileName;
	private String jbfjFileType;
	private String jbfjFileUrl;
	private Integer jbfcID;
	private String hold;

	
	public Integer getJbfjID() {
		return jbfjID;
	}

	public void setJbfjID(Integer jbfjID) {
		this.jbfjID = jbfjID;
	}

	public String getJbfjFileName() {
		return jbfjFileName;
	}

	public void setJbfjFileName(String jbfjFileName) {
		this.jbfjFileName = jbfjFileName;
	}

	public String getJbfjFileType() {
		return jbfjFileType;
	}

	public void setJbfjFileType(String jbfjFileType) {
		this.jbfjFileType = jbfjFileType;
	}

	public String getJbfjFileUrl() {
		return jbfjFileUrl;
	}

	public void setJbfjFileUrl(String jbfjFileUrl) {
		this.jbfjFileUrl = jbfjFileUrl;
	}

	public Integer getJbfcID() {
		return jbfcID;
	}

	public void setJbfcID(Integer jbfcID) {
		this.jbfcID = jbfcID;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}

	@Override
	public Jbfj mapRow(ResultSet rst, int rowNum) throws SQLException {
		Jbfj jbfj = new Jbfj();
		jbfj.setJbfjID(rst.getInt("jbfj_id"));
		jbfj.setJbfjFileName(rst.getString("jbfj_file_name"));
		jbfj.setJbfjFileType(rst.getString("jbfj_file_type"));
		jbfj.setJbfjFileUrl(rst.getString("jbfj_file_url"));
		jbfj.setJbfcID(rst.getInt("jbfc_id"));
		jbfj.setHold(rst.getString("hold"));
		return jbfj;
	}
}
