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
import com.jinyu.fdxc.struts.bean.XinWen;
import com.jinyu.fdxc.struts.bean.Xwfj;

public class XinWenDAO extends SpringJDBCTemplate{

	
	/**
	 *查询所有的新闻 
	 */
	@SuppressWarnings("unchecked")
	public List<XinWen> queryXinWenList(Object[] objs , Page page ,Integer xinWenType , Integer deptType) throws Exception {
		 String sql  = " select *  from xinwen where 1=1 ";
		 List<Object> list = new ArrayList<Object>();
			if(objs!=null&&objs.length>0){
				if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
					sql +=" and xinwen_id=? ";
					list.add(objs[0]);	
				}
				if(objs.length>=2&&objs[1]!=null&&!"".equals(objs[1])){
					sql +=" and xinwen_title like  ? ";
					list.add("%"+objs[1]+"%");	
				}
			}
				if(xinWenType!=null){
					sql +="  and xinwen_type = "+xinWenType;
				}
				if(deptType!=null){
					sql +="  and dept_type = "+deptType;
				}
			  sql += " and xinwen_title <> ''  order by xinwen_id desc";
			return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new XinWen());
	}
	
	/**
	 *按新闻id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public XinWen findXinWenByID(int id) throws Exception {
		String sql = "  select *  from xinwen where xinwen_id="+id;
		List<XinWen> xinWenList = this.getJdbcTemplate().query(sql,new XinWen());
		if(xinWenList!=null&&xinWenList.size()>0){
			return xinWenList.get(0);
		}
		return null;
	}
	
	/**
	 *查询新闻发布人
	 */
	@SuppressWarnings("unchecked")
	public SysUser findUserByID(int id) throws Exception {
		String sql = " select t2.* from xinwen t1 , sys_user t2 where t1.user_id = t2.user_id and t1.xinwen_id="+id;
		List<SysUser> userList = this.getJdbcTemplate().query(sql,new SysUser());
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}
		return null;
	}
	
	/**
	 *保存新闻 
	 */
	public int saveXinWen(XinWen xinWen) throws Exception {
		final String sql = "insert into xinwen (xinwen_title,xinwen_type,xinwen_content,sub_date,dept_type,user_id,hold) values (?,?,?,?,?,?,?)";
		final Object[] objs = {xinWen.getXinwenTitle(),xinWen.getXinwenType(),xinWen.getXinwenContent(),xinWen.getSubDate(),xinWen.getDeptType()
				,xinWen.getSysUser().getUserID(),xinWen.getHold()};
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
	 *修改新闻 
	 */
	public void editXinWen(XinWen xinWen) throws Exception {
		String sql = "update xinwen set xinwen_title=?,xinwen_content=?,sub_date=?,dept_type=?,user_id=?,hold=?  where xinwen_id=?";
		Object[] objs = {xinWen.getXinwenTitle(),xinWen.getXinwenContent(),xinWen.getSubDate(),xinWen.getDeptType()
				,xinWen.getSysUser().getUserID(),xinWen.getHold(),xinWen.getXinwenID()};
		this.getJdbcTemplate().update(sql,objs);   
	}

	/**
	 *删除新闻 
	 */
	public void deleteXinWenByID(int id) throws Exception {
		String sql = " delete from xinwen where xinwen_id="+id;
		this.getJdbcTemplate().update(sql);
	}
	
	
	
	
	
	
	/**
	 *删除新闻附件 
	 */
	public void deleteXwfjByID(int id) throws Exception {
		String sql = " delete from xwfj where xinwen_id="+id;
		this.getJdbcTemplate().update(sql);
	}
	
	/**
	 *查询新闻的附件
	 */
	@SuppressWarnings("unchecked")
	public List<Xwfj> queryXwfjByXwIDList(int id) throws Exception {
		String sql = " select t2.* from xinwen t1 ,xwfj t2 where  t1.xinwen_id = t2.xinwen_id and  t2.xinwen_id = "+id;
		return this.getJdbcTemplate().query(sql, new Xwfj());
	}
	
	/**
	 *保存新闻 附件
	 */
	public int saveXwfj(Xwfj xwfj) throws Exception {
		final String sql = "insert into xwfj (xwfj_file_name,xwfj_file_type,xwfj_file_url,hold) values (?,?,?,?)";
		final Object[] objs = {xwfj.getXwfjFileName(),xwfj.getXwfjFileType(),xwfj.getXwfjFileUrl(),xwfj.getHold()};
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
	 *保存新闻后插入附件中的外键（新闻的主键） 
	 */
	public void editXwfj(int xinwenID , int xwfjID) throws Exception {
		String sql = "update xwfj set xinwen_id=?  where xwfj_id=?";
		Object[] objs = {xinwenID , xwfjID};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	
}
