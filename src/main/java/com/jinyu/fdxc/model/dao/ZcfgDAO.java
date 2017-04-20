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
import com.jinyu.fdxc.struts.bean.Zcfg;

public class ZcfgDAO extends SpringJDBCTemplate {
	
	/**
	 *查询所有的
	 */
	@SuppressWarnings("unchecked")
	public List<Zcfg> queryZcfgList(Object[] objs , Page page ,String type  ,Integer deptType ) throws Exception {
		 String sql  = " select *  from zcfg where 1=1 ";
		 List<Object> list = new ArrayList<Object>();
			if(objs!=null&&objs.length>0){
				if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
					sql +=" and zcfg_id=? ";
					list.add(objs[0]);	
				}
				if(objs.length>=2&&objs[1]!=null&&!"".equals(objs[1])){
					sql +=" and zcfg_title like  ? ";
					list.add("%"+objs[1]+"%");	
				}
			}
				if(null!=type&&!"".equals(type)){
					sql += " and zcfg_type = " +type; 
				}
				if(deptType!=null){
					sql +="  and dept_type = "+deptType;
				}
			  sql += " and zcfg_title <> ''  order by zcfg_id desc";
			  return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Zcfg());
	}
	
	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public Zcfg findZcfgByID(int id) throws Exception {
		String sql = "  select *  from zcfg where zcfg_id="+id;
		List<Zcfg> zcfgList = this.getJdbcTemplate().query(sql,new Zcfg());
		if(zcfgList!=null&&zcfgList.size()>0){
			return zcfgList.get(0);
		}
		return null;
	}
	
	/**
	 *查询发布人
	 */
	@SuppressWarnings("unchecked")
	public SysUser findUserByID(int id) throws Exception {
		String sql = " select t2.* from zcfg t1 , sys_user t2 where t1.user_id = t2.user_id and t1.zcfg_id="+id;
		List<SysUser> userList = this.getJdbcTemplate().query(sql,new SysUser());
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}
		return null;
	}
	
	
	/**
	 *保存  没有附件直接保存 
	 */
	public int saveZcfg(Zcfg zcfg) throws Exception {
		final String sql = "insert into zcfg (zcfg_title,zcfg_type,zcfg_content,sub_date,dept_type,user_id,hold) values (?,?,?,?,?,?,?)";
		final Object[] objs = {zcfg.getZcfgTitle(),zcfg.getZcfgType(),zcfg.getZcfgContent(),zcfg.getSubDate(),zcfg.getDeptType(),zcfg.getSysUser().getUserID(),zcfg.getHold()};
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					pst.setString(++i, DataUtil.toString(objs[n++])); 
					pst.setInt(++i, DataUtil.toInt(objs[n++]));
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
	public void editZcfg(Zcfg zcfg) throws Exception {
		String sql = "update zcfg set zcfg_title=?,zcfg_type=?,zcfg_content=?,sub_date=?,dept_type=?,user_id=?,hold=? where zcfg_id=?";
		Object[] objs = {zcfg.getZcfgTitle(),zcfg.getZcfgType(),zcfg.getZcfgContent(),zcfg.getSubDate(),zcfg.getDeptType(),zcfg.getSysUser().getUserID(),zcfg.getHold(),zcfg.getZcfgID()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	

	/**
	 *删除
	 */
	public void deleteZcfgByID(int id) throws Exception {
		String sql = " delete from zcfg where zcfg_id="+id;
		this.getJdbcTemplate().update(sql);
	}

}
