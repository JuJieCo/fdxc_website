package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jinyu.fdxc.model.utils.BaseBean;

public class Fdyx extends BaseBean {
	private Integer fdyxID;
	private String fdyxTitle;
	private String fdyxContent;
	private Date subDate;
	private Integer deptType;
	private SysUser sysUser;
	private String hold;
	private List<Fdfj> fdfjList;

	public Fdyx() {
		this.sysUser = new SysUser();
		this.fdfjList = new ArrayList<Fdfj>();
	}

	public Integer getFdyxID() {
		return fdyxID;
	}

	public void setFdyxID(Integer fdyxID) {
		this.fdyxID = fdyxID;
	}

	public String getFdyxTitle() {
		return fdyxTitle;
	}

	public void setFdyxTitle(String fdyxTitle) {
		this.fdyxTitle = fdyxTitle;
	}

	public String getFdyxContent() {
		return fdyxContent;
	}

	public void setFdyxContent(String fdyxContent) {
		this.fdyxContent = fdyxContent;
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

	public List<Fdfj> getFdfjList() {
		return fdfjList;
	}

	public void setFdfjList(List<Fdfj> fdfjList) {
		this.fdfjList = fdfjList;
	}

	@Override
	public Fdyx mapRow(ResultSet rst, int rowNum) throws SQLException {
		Fdyx fdyx = new Fdyx();
		fdyx.setFdyxID(rst.getInt("fdyx_id"));
		fdyx.setFdyxTitle(rst.getString("fdyx_title"));
		fdyx.setFdyxContent(rst.getString("fdyx_content"));
		fdyx.setSubDate(rst.getDate("sub_date"));
		fdyx.setDeptType(rst.getInt("dept_type"));
		fdyx.getSysUser().setUserID(rst.getInt("user_id"));
		fdyx.setHold(rst.getString("hold"));
		return fdyx;
	}

}
