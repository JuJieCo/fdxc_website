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
import com.jinyu.fdxc.struts.bean.Ldcy;
import com.jinyu.fdxc.struts.bean.SysUser;

public class LdcyDAO extends SpringJDBCTemplate {
	
	/**
	 *查询所有的
	 */
	@SuppressWarnings("unchecked")
	public List<Ldcy> queryLdcyList(Object[] objs , Page page ) throws Exception {
		 String sql  = " select *  from ldcy where 1=1 ";
		 List<Object> list = new ArrayList<Object>();
			if(objs!=null&&objs.length>0){
				if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
					sql +=" and ldcy_id=? ";
					list.add(objs[0]);	
				}
				if(objs.length>=2&&objs[1]!=null&&!"".equals(objs[1])){
					sql +=" and ldcy_title like  ? ";
					list.add("%"+objs[1]+"%");	
				}
			}
				
			  sql += " and ldcy_title <> '' order by ldcy_id desc";
			  return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Ldcy());
	}
	
	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public Ldcy findLdcyByID(int id) throws Exception {
		String sql = "  select *  from ldcy where ldcy_id="+id;
		List<Ldcy> ldcyList = this.getJdbcTemplate().query(sql,new Ldcy());
		if(ldcyList!=null&&ldcyList.size()>0){
			return ldcyList.get(0);
		}
		return null;
	}
	
	/**
	 *查询发布人
	 */
	@SuppressWarnings("unchecked")
	public SysUser findUserByID(int id) throws Exception {
		String sql = " select t2.* from ldcy t1 , sys_user t2 where t1.user_id = t2.user_id and t1.ldcy_id="+id;
		List<SysUser> userList = this.getJdbcTemplate().query(sql,new SysUser());
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}
		return null;
	}
	
	
	/**
	 *保存  没有附件直接保存 
	 */
	public int saveLdcy(Ldcy ldcy) throws Exception {
		final String sql = "insert into ldcy (ldcy_title,ldcy_content,sub_date,dept_type,user_id,hold) values (?,?,?,?,?,?)";
		final Object[] objs = {ldcy.getLdcyTitle(),ldcy.getLdcyContent(),ldcy.getSubDate(),ldcy.getDeptType(), ldcy.getSysUser().getUserID(), ldcy.getHold()};
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setTimestamp(++i, DataUtil.toTimestamp(objs[n++]));
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					pst.setString(++i, DataUtil.toString(objs[n++]));    
					return pst;
				}}, keyHolder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}
	
	
	/**
	 *修改
	 */
	public void editLdcy(Ldcy ldcy) throws Exception {
		String sql = "update ldcy set ldcy_title=?,ldcy_content=?,sub_date=?,dept_type=?,user_id=?,hold=?  where ldcy_id=?";
		Object[] objs = {ldcy.getLdcyTitle(),ldcy.getLdcyContent(),ldcy.getSubDate(),ldcy.getDeptType(), ldcy.getSysUser().getUserID(), ldcy.getHold(),ldcy.getLdcyID()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	/**
	 *保存 有附件的话先要保存附件 
	 */
	public int saveFJ(Ldcy ldcy) throws Exception {
		final String sql = "insert into ldcy (ldcy_file_name,ldcy_file_type,ldcy_file_url) values (?,?,?)";
		final Object[] objs = {ldcy.getLdcyFileName(),ldcy.getLdcyFileType(),ldcy.getLdcyFileUrl()};
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
					return pst;
				}}, keyHolder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}
	/**
	 *再保存已经有附件的 
	 */
	public void editAsFJ(Ldcy ldcy) throws Exception {
		String sql = "update ldcy set ldcy_title=?,ldcy_content=?,sub_date=?,dept_type=?,user_id=?,hold=?  where ldcy_id=?";
		Object[] objs = {ldcy.getLdcyTitle(),ldcy.getLdcyContent(),ldcy.getSubDate(),ldcy.getDeptType(), ldcy.getSysUser().getUserID(), ldcy.getHold(),ldcy.getLdcyID()};
		this.getJdbcTemplate().update(sql,objs);   
	}

	
	
	/**
	 *删除
	 */
	public void deleteLdcyByID(int id) throws Exception {
		String sql = " delete from ldcy where ldcy_id="+id;
		this.getJdbcTemplate().update(sql);
	}
	
	

}
