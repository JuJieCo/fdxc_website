package com.jinyu.fdxc.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jinyu.fdxc.model.utils.BaseBean;

public class SysUser extends BaseBean{

	private Integer userID;
	private String loginName;
	private String password;
	private String userName;
	private Integer userSex; //0 男 1 女
	private Integer userAge;
	private String userDept;
	private Integer userType;//0 管理员 1 普通用户
	private String hold;
	
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserDept() {
		return userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}




	@Override
	public SysUser mapRow(ResultSet rst, int rowNum) throws SQLException {
		SysUser sysUser = new SysUser();
		sysUser.setUserID(rst.getInt("user_id"));
		sysUser.setLoginName(rst.getString("login_name"));
		sysUser.setPassword(rst.getString("password"));
		sysUser.setUserName(rst.getString("user_name"));
		sysUser.setUserSex(rst.getInt("user_sex"));
		sysUser.setUserAge(rst.getInt("user_age"));
		sysUser.setUserDept(rst.getString("user_dept"));
		sysUser.setUserType(rst.getInt("user_type"));
		sysUser.setHold(rst.getString("hold"));
		return sysUser;
	}

}
