package com.jinyu.fdxc.model.dao;

import java.util.List;

import com.jinyu.fdxc.model.utils.SpringJDBCTemplate;
import com.jinyu.fdxc.struts.bean.SysUser;

public class LoginDAO extends SpringJDBCTemplate {

	@SuppressWarnings("unchecked")
	public SysUser findSysUserByNameAndPassword(String name, String password) throws Exception{
		String sql = "select * from sys_user  where login_name=? and password= ? and hold='0' ";
		Object[] objs = { name, password };
		List<SysUser> list = this.getJdbcTemplate().query(sql, objs, new SysUser());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public SysUser findUserByID(int id) throws Exception {
		String sql = "  select *  from sys_user where user_id="+id;
		List<SysUser> sysUserList = this.getJdbcTemplate().query(sql,new SysUser());
		if(sysUserList!=null&&sysUserList.size()>0){
			return sysUserList.get(0);
		}
		return null;
	}
}
