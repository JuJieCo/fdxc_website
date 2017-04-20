package com.jinyu.fdxc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.jinyu.fdxc.model.utils.DataUtil;
import com.jinyu.fdxc.model.utils.Page;
import com.jinyu.fdxc.model.utils.PageUtil;
import com.jinyu.fdxc.model.utils.SpringJDBCTemplate;
import com.jinyu.fdxc.struts.bean.SysUser;

public class SysUserDAO extends SpringJDBCTemplate {
	


	@SuppressWarnings("unchecked")
	public List<SysUser> queryUserList(Object[] objs , Page page) throws Exception {
		 String sql  = " select *  from sys_user where 1=1 ";
		 List<Object> list = new ArrayList<Object>();
			if(objs!=null&&objs.length>0){
				if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
					sql +=" and user_id=? ";
					list.add(objs[0]);	
				}
				if(objs.length>=2&&objs[1]!=null&&!"".equals(objs[1])){
					sql +=" and login_name=? ";
					list.add(objs[1]);	
				}
			}
			  sql += " and  user_id <> 1  order by user_id desc";
			return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new SysUser());
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
	

	public int saveUser(SysUser sysUser) throws Exception {
		final String sql = "insert into sys_user (login_name,password,user_name,user_sex,user_age,user_dept,user_type,hold) values (?,?,?,?,?,?,?,?)";
		final Object[] objs = {sysUser.getLoginName(),sysUser.getPassword(),sysUser.getUserName(),sysUser.getUserSex()
				,sysUser.getUserAge(),sysUser.getUserDept(),sysUser.getUserType(),sysUser.getHold()};
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++]));    
					pst.setString(++i, DataUtil.toString(objs[n++]));    
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					pst.setString(++i, DataUtil.toString(objs[n++]));  
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					pst.setString(++i, DataUtil.toString(objs[n++]));  
					return pst;
				}}, keyHolder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}


	public void editUser(SysUser sysUser) throws Exception {
		String sql = "update sys_user set login_name=?,password=?,user_name=?,user_sex=?,user_age=?,user_dept=?,user_type=?  where user_id=?";
		Object[] objs = {sysUser.getLoginName(),sysUser.getPassword(),sysUser.getUserName(),sysUser.getUserSex(),sysUser.getUserAge(),sysUser.getUserDept()
				,sysUser.getUserType(),sysUser.getUserID()};
		this.getJdbcTemplate().update(sql,objs);   
	}


	public void deleteUserByID(int id) throws Exception {
		String sql = "update sys_user set hold=1  where user_id=?";
		Object[] objs = {id};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	public void resetUserByID(int id) throws Exception {
		String sql = "update sys_user set hold=0  where user_id=?";
		Object[] objs = {id};
		this.getJdbcTemplate().update(sql,objs);   
	}

	
}
