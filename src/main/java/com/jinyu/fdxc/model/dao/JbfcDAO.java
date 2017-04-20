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
import com.jinyu.fdxc.struts.bean.Jbfc;
import com.jinyu.fdxc.struts.bean.Jbfj;
import com.jinyu.fdxc.struts.bean.SysUser;

public class JbfcDAO extends SpringJDBCTemplate{
	
	/**
	 *查询所有的街办风采
	 */
	@SuppressWarnings("unchecked")
	public List<Jbfc> queryJbfcList(Object[] objs , Page page) throws Exception {
		 String sql  = " select *  from jbfc where 1=1 ";
		 List<Object> list = new ArrayList<Object>();
			if(objs!=null&&objs.length>0){
				if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
					sql +=" and Jbfc_id=? ";
					list.add(objs[0]);	
				}
				if(objs.length>=2&&objs[1]!=null&&!"".equals(objs[1])){
					sql +=" and jbfc_title like  ? ";
					list.add("%"+objs[1]+"%");	
				}
			}
			  sql += " and jbfc_title <> '' order by Jbfc_id desc";
			return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Jbfc());
	}
	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public Jbfc findJbfcByID(int id) throws Exception {
		String sql = "  select *  from jbfc where jbfc_id="+id;
		List<Jbfc> jbfcList = this.getJdbcTemplate().query(sql,new Jbfc());
		if(jbfcList!=null&&jbfcList.size()>0){
			return jbfcList.get(0);
		}
		return null;
	}
	
	
	/**
	 *查询发布人
	 */
	@SuppressWarnings("unchecked")
	public SysUser findUserByID(int id) throws Exception {
		String sql = " select t2.* from jbfc t1 , sys_user t2 where t1.user_id = t2.user_id and t1.jbfc_id="+id;
		List<SysUser> userList = this.getJdbcTemplate().query(sql,new SysUser());
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}
		return null;
	}
	
	
	/**
	 *保存街办风采
	 */
	public int saveJbfc(Jbfc jbfc) throws Exception {
		final String sql = "insert into jbfc (jbfc_title,jbfc_content,sub_date,jb_type,dept_type,user_id,hold) values (?,?,?,?,?,?,?)";
		final Object[] objs = {jbfc.getJbfcTitle(),jbfc.getJbfcContent(),jbfc.getSubDate(),jbfc.getJbType(),jbfc.getDeptType()
				,jbfc.getSysUser().getUserID(),jbfc.getHold()};
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
	public void editJbfc(Jbfc jbfc) throws Exception {
		String sql = " update jbfc set jbfc_title=?,jbfc_content=?,sub_date=?,jb_type=?,dept_type=?,user_id=?,hold=?  where jbfc_id=? ";
		Object[] objs = {jbfc.getJbfcTitle(),jbfc.getJbfcContent(),jbfc.getSubDate(),jbfc.getJbType(),jbfc.getDeptType()
				,jbfc.getSysUser().getUserID(),jbfc.getHold(),jbfc.getJbfcID()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	/**
	 *删除
	 */
	public void deleteJbfcByID(int id) throws Exception {
		String sql = " delete from jbfc where jbfc_id="+id;
		this.getJdbcTemplate().update(sql);
	}
	
	
	/**
	 *删除附件 
	 */
	public void deleteJbfjByID(int id) throws Exception {
		String sql = " delete from jbfj where jbfc_id="+id;
		this.getJdbcTemplate().update(sql);
	}
	
	
	
	/**
	 *查询附件
	 */
	@SuppressWarnings("unchecked")
	public List<Jbfj> queryJbfjByJbIDList(int id) throws Exception {
		String sql = " select t2.* from jbfc t1 , jbfj t2 where  t1.jbfc_id = t2.jbfc_id and  t2.jbfc_id = "+id;
		return this.getJdbcTemplate().query(sql, new Jbfj());
	}
	
	
	/**
	 *保存 附件
	 */
	public int saveJbfj(Jbfj jbfj) throws Exception {
		final String sql = "insert into jbfj (jbfj_file_name,jbfj_file_type,jbfj_file_url,hold) values (?,?,?,?)";
		final Object[] objs = {jbfj.getJbfjFileName(),jbfj.getJbfjFileType(),jbfj.getJbfjFileUrl(),jbfj.getHold()};
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
					pst.setString(++i, DataUtil.toString(objs[n++]));    
					return pst;
				}}, keyHolder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	} 
	
	
	/**
	 *保存后插入附件中的外键（街办风采的主键） 
	 */
	public void editJbfj(int jbfcID , int jbfjID) throws Exception {
		String sql = "update jbfj set jbfc_id=?  where jbfj_id=?";
		Object[] objs = {jbfcID , jbfjID};
		this.getJdbcTemplate().update(sql,objs);   
	}

}
