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
import com.jinyu.fdxc.struts.bean.Hdry;
import com.jinyu.fdxc.struts.bean.SysUser;

public class HdryDAO extends SpringJDBCTemplate{
	
	/**
	 *查询所有的
	 */
	@SuppressWarnings("unchecked")
	public List<Hdry> queryHdryList(Object[] objs , Page page ) throws Exception {
		 String sql  = " select *  from hdry where 1=1 ";
		 List<Object> list = new ArrayList<Object>();
			if(objs!=null&&objs.length>0){
				if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
					sql +=" and hdry_id=? ";
					list.add(objs[0]);	
				}
				if(objs.length>=2&&objs[1]!=null&&!"".equals(objs[1])){
					sql +=" and hdry_title like  ? ";
					list.add("%"+objs[1]+"%");	
				}
			}
				
			  sql += " and hdry_title <> '' order by Hdry_id desc";
			  return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Hdry());
	}
	
	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public Hdry findHdryByID(int id) throws Exception {
		String sql = "  select *  from Hdry where Hdry_id="+id;
		List<Hdry> hdryList = this.getJdbcTemplate().query(sql,new Hdry());
		if(hdryList!=null&&hdryList.size()>0){
			return hdryList.get(0);
		}
		return null;
	}
	
	/**
	 *查询发布人
	 */
	@SuppressWarnings("unchecked")
	public SysUser findUserByID(int id) throws Exception {
		String sql = " select t2.* from hdry  t1 , sys_user t2 where t1.user_id = t2.user_id and t1.hdry_id="+id;
		List<SysUser> userList = this.getJdbcTemplate().query(sql,new SysUser());
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}
		return null;
	}
	
	
	/**
	 *保存  没有附件直接保存 
	 */
	public int saveHdry(Hdry hdry) throws Exception {
		final String sql = "insert into hdry (hdry_title,hdry_content,sub_date,dept_type,user_id,hold) values (?,?,?,?,?,?)";
		final Object[] objs = {hdry.getHdryTitle(),hdry.getHdryContent(),hdry.getSubDate(),hdry.getDeptType(), hdry.getSysUser().getUserID(), hdry.getHold()};
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
	public void editHdry(Hdry hdry) throws Exception {
		String sql = "update hdry set hdry_title=?,hdry_content=?,sub_date=?,dept_type=?,user_id=?,hold=?  where hdry_id=?";
		Object[] objs = {hdry.getHdryTitle(),hdry.getHdryContent(),hdry.getSubDate(),hdry.getDeptType(), hdry.getSysUser().getUserID(), hdry.getHold(),hdry.getHdryID()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	/**
	 *保存 有附件的话先要保存附件 
	 */
	public int saveFJ(Hdry hdry) throws Exception {
		final String sql = "insert into hdry (hdry_file_name,hdry_file_type,hdry_file_url) values (?,?,?)";
		final Object[] objs = {hdry.getHdryFileName(),hdry.getHdryFileType(),hdry.getHdryFileUrl()};
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
	public void editAsFJ(Hdry hdry) throws Exception {
		String sql = "update hdry set hdry_title=?,hdry_content=?,sub_date=?,dept_type=?,user_id=?,hold=?  where hdry_id=?";
		Object[] objs = {hdry.getHdryTitle(),hdry.getHdryContent(),hdry.getSubDate(),hdry.getDeptType(), hdry.getSysUser().getUserID(), hdry.getHold(),hdry.getHdryID()};
		this.getJdbcTemplate().update(sql,objs);   
	}

	
	
	/**
	 *删除
	 */
	public void deleteHdryByID(int id) throws Exception {
		String sql = " delete from hdry where hdry_id="+id;
		this.getJdbcTemplate().update(sql);
	}
	
	

}
