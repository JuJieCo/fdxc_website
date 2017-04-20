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
import com.jinyu.fdxc.struts.bean.Zzjg;

public class ZzjgDAO extends SpringJDBCTemplate {
	
	/**
	 *查询所有的
	 */
	@SuppressWarnings("unchecked")
	public List<Zzjg> queryZzjgList(Object[] objs , Page page ) throws Exception {
		 String sql  = " select *  from zzjg where 1=1 ";
		 List<Object> list = new ArrayList<Object>();
			if(objs!=null&&objs.length>0){
				if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
					sql +=" and zzjg_id=? ";
					list.add(objs[0]);	
				}
				if(objs.length>=2&&objs[1]!=null&&!"".equals(objs[1])){
					sql +=" and zzjg_title like  ? ";
					list.add("%"+objs[1]+"%");	
				}
			}
				
			  sql += " and zzjg_title <> ''  order by zzjg_id desc";
			  return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Zzjg());
	}
	
	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public Zzjg findZzjgByID(int id) throws Exception {
		String sql = "  select *  from zzjg where zzjg_id="+id;
		List<Zzjg> zzjgList = this.getJdbcTemplate().query(sql,new Zzjg());
		if(zzjgList!=null&&zzjgList.size()>0){
			return zzjgList.get(0);
		}
		return null;
	}
	
	/**
	 *查询发布人
	 */
	@SuppressWarnings("unchecked")
	public SysUser findUserByID(int id) throws Exception {
		String sql = " select t2.* from zzjg t1 , sys_user t2 where t1.user_id = t2.user_id and t1.zzjg_id="+id;
		List<SysUser> userList = this.getJdbcTemplate().query(sql,new SysUser());
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}
		return null;
	}
	
	
	/**
	 *保存  没有附件直接保存 
	 */
	public int saveZzjg(Zzjg zzjg) throws Exception {
		final String sql = "insert into zzjg (zzjg_title,zzjg_content,sub_date,dept_type,user_id,hold) values (?,?,?,?,?,?)";
		final Object[] objs = {zzjg.getZzjgTitle(),zzjg.getZzjgContent(),zzjg.getSubDate(),zzjg.getDeptType(), zzjg.getSysUser().getUserID(), zzjg.getHold()};
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
	public void editZzjg(Zzjg zzjg) throws Exception {
		String sql = "update zzjg set zzjg_title=?,zzjg_content=?,sub_date=?,dept_type=?,user_id=?,hold=?  where zzjg_id=?";
		Object[] objs = {zzjg.getZzjgTitle(),zzjg.getZzjgContent(),zzjg.getSubDate(),zzjg.getDeptType(), zzjg.getSysUser().getUserID(), zzjg.getHold(),zzjg.getZzjgID()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	/**
	 *保存 有附件的话先要保存附件 
	 */
	public int saveFJ(Zzjg zzjg) throws Exception {
		final String sql = "insert into zzjg (zzjg_file_name,zzjg_file_type,zzjg_file_url) values (?,?,?)";
		final Object[] objs = {zzjg.getZzjgFileName(),zzjg.getZzjgFileType(),zzjg.getZzjgFileUrl()};
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
	public void editAsFJ(Zzjg zzjg) throws Exception {
		String sql = "update zzjg set zzjg_title=?,zzjg_content=?,sub_date=?,dept_type=?,user_id=?,hold=?  where zzjg_id=?";
		Object[] objs = {zzjg.getZzjgTitle(),zzjg.getZzjgContent(),zzjg.getSubDate(),zzjg.getDeptType(), zzjg.getSysUser().getUserID(), zzjg.getHold(),zzjg.getZzjgID()};
		this.getJdbcTemplate().update(sql,objs);   
	}

	
	
	/**
	 *删除
	 */
	public void deleteZzjgByID(int id) throws Exception {
		String sql = " delete from zzjg where zzjg_id="+id;
		this.getJdbcTemplate().update(sql);
	}
	
	

}
