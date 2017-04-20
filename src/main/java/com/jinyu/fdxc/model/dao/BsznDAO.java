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
import com.jinyu.fdxc.struts.bean.Bszn;
import com.jinyu.fdxc.struts.bean.SysUser;

public class BsznDAO extends SpringJDBCTemplate {
	
	/**
	 *查询所有的
	 */
	@SuppressWarnings("unchecked")
	public List<Bszn> queryBsznList(Object[] objs , Page page , Integer deptType) throws Exception {
		 String sql  = " select *  from bszn where 1=1 ";
		 List<Object> list = new ArrayList<Object>();
			if(objs!=null&&objs.length>0){
				if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
					sql +=" and bszn_id=? ";
					list.add(objs[0]);	
				}
				if(objs.length>=2&&objs[1]!=null&&!"".equals(objs[1])){
					sql +=" and bszn_title like  ? ";
					list.add("%"+objs[1]+"%");	
				}
			}
			if(deptType!=null){
				sql +="  and dept_type = "+deptType;
			}
			  sql += " and bszn_title <> '' order by bszn_id desc";
			  return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Bszn());
	}
	
	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public Bszn findBsznByID(int id) throws Exception {
		String sql = "  select *  from bszn where bszn_id="+id;
		List<Bszn> bsznList = this.getJdbcTemplate().query(sql,new Bszn());
		if(bsznList!=null&&bsznList.size()>0){
			return bsznList.get(0);
		}
		return null;
	}
	
	/**
	 *查询发布人
	 */
	@SuppressWarnings("unchecked")
	public SysUser findUserByID(int id) throws Exception {
		String sql = " select t2.* from bszn t1 , sys_user t2 where t1.user_id = t2.user_id and t1.bszn_id="+id;
		List<SysUser> userList = this.getJdbcTemplate().query(sql,new SysUser());
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}
		return null;
	}
	
	
	/**
	 *保存  没有附件直接保存 
	 */
	public int saveBszn(Bszn bszn) throws Exception {
		final String sql = "insert into bszn (bszn_title,bszn_content,sub_date,dept_type,user_id,hold) values (?,?,?,?,?,?)";
		final Object[] objs = {bszn.getBsznTitle(),bszn.getBsznContent(),bszn.getSubDate(),bszn.getDeptType(),bszn.getSysUser().getUserID(),bszn.getHold()};
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
	public void editBszn(Bszn bszn) throws Exception {
		String sql = "update bszn set bszn_title=?,bszn_content=?,sub_date=?,dept_type=?,user_id=?,hold=? where bszn_id=?";
		Object[] objs = {bszn.getBsznTitle(),bszn.getBsznContent(),bszn.getSubDate(),bszn.getDeptType(),bszn.getSysUser().getUserID(),bszn.getHold(),bszn.getBsznID()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	

	/**
	 *删除
	 */
	public void deleteBsznByID(int id) throws Exception {
		String sql = " delete from bszn where bszn_id="+id;
		this.getJdbcTemplate().update(sql);
	}

}
