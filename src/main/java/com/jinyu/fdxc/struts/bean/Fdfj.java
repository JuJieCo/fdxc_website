package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Fdfj extends BaseBean {

	private Integer fdfjID;
	private String fdfjFileName;
	private String fdfjFileType;
	private String fdfjFileUrl;
	private Integer fdyxID;
	private String hold;

	public Integer getFdfjID() {
		return fdfjID;
	}

	public void setFdfjID(Integer fdfjID) {
		this.fdfjID = fdfjID;
	}

	public String getFdfjFileName() {
		return fdfjFileName;
	}

	public void setFdfjFileName(String fdfjFileName) {
		this.fdfjFileName = fdfjFileName;
	}

	public String getFdfjFileType() {
		return fdfjFileType;
	}

	public void setFdfjFileType(String fdfjFileType) {
		this.fdfjFileType = fdfjFileType;
	}

	public String getFdfjFileUrl() {
		return fdfjFileUrl;
	}

	public void setFdfjFileUrl(String fdfjFileUrl) {
		this.fdfjFileUrl = fdfjFileUrl;
	}

	public Integer getFdyxID() {
		return fdyxID;
	}

	public void setFdyxID(Integer fdyxID) {
		this.fdyxID = fdyxID;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}

	@Override
	public Fdfj mapRow(ResultSet rst, int rowNum) throws SQLException {
		Fdfj fdfj = new Fdfj();
		fdfj.setFdfjID(rst.getInt("fdfj_id"));
		fdfj.setFdfjFileName(rst.getString("fdfj_file_name"));
		fdfj.setFdfjFileType(rst.getString("fdfj_file_type"));
		fdfj.setFdfjFileUrl(rst.getString("fdfj_file_url"));
		fdfj.setFdyxID(rst.getInt("fdyx_id"));
		fdfj.setHold(rst.getString("hold"));
		return fdfj;
	}
}
