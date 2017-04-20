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
import com.jinyu.fdxc.struts.bean.Znbm;
import com.jinyu.fdxc.struts.bean.SysUser;

public class ZnbmDAO extends SpringJDBCTemplate {
	
	/**
	 *查询所有的
	 */
	@SuppressWarnings("unchecked")
	public List<Znbm> queryZnbmList(Object[] objs , Page page,Integer deptType ) throws Exception {
		 String sql  = " select *  from znbm where 1=1 ";
		 List<Object> list = new ArrayList<Object>();
			if(objs!=null&&objs.length>0){
				if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
					sql +=" and znbm_id=? ";
					list.add(objs[0]);	
				}
				if(objs.length>=2&&objs[1]!=null&&!"".equals(objs[1])){
					sql +=" and znbm_title like  ? ";
					list.add("%"+objs[1]+"%");	
				}
			}
			if(deptType!=null){
				sql +="  and dept_type = "+deptType;
			}
			  sql += " and znbm_title <> ''  order by znbm_id desc";
			  return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Znbm());
	}
	
	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public Znbm findZnbmByID(int id) throws Exception {
		String sql = "  select *  from znbm where znbm_id="+id;
		List<Znbm> znbmList = this.getJdbcTemplate().query(sql,new Znbm());
		if(znbmList!=null&&znbmList.size()>0){
			return znbmList.get(0);
		}
		return null;
	}
	
	/**
	 *查询发布人
	 */
	@SuppressWarnings("unchecked")
	public SysUser findUserByID(int id) throws Exception {
		String sql = " select t2.* from znbm  t1 , sys_user t2 where t1.user_id = t2.user_id and t1.znbm_id="+id;
		List<SysUser> userList = this.getJdbcTemplate().query(sql,new SysUser());
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}
		return null;
	}
	
	
	/**
	 *保存  没有附件直接保存 
	 */
	public int saveZnbm(Znbm znbm) throws Exception {
		final String sql = "insert into znbm (znbm_title,znbm_bgs,znbm_ywk,znbm_fwz,dept_type,sub_date,user_id,hold) values (?,?,?,?,?,?,?,?)";
		final Object[] objs = {znbm.getZnbmTitle(),znbm.getZnbmBgs(),znbm.getZnbmYwk(),znbm.getZnbmFwz(),znbm.getDeptType()
				,znbm.getSubDate(),znbm.getUser().getUserID(),znbm.getHold()};
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
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
					pst.setTimestamp(++i, DataUtil.toTimestamp(objs[n++]));
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
	public void editZnbm(Znbm znbm) throws Exception {
		String sql = "update znbm set znbm_title=?,znbm_bgs=?,znbm_ywk=?,znbm_fwz=?,sub_date=?,hold=? where znbm_id=?";
		Object[] objs = {znbm.getZnbmTitle(),znbm.getZnbmBgs(),znbm.getZnbmYwk(),znbm.getZnbmFwz()
				,znbm.getSubDate(),znbm.getHold(),znbm.getZnbmID()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	

	/**
	 *删除
	 */
	public void deleteZnbmByID(int id) throws Exception {
		String sql = " delete from znbm where znbm_id="+id;
		this.getJdbcTemplate().update(sql);
	}

}
