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
import com.jinyu.fdxc.struts.bean.Fdfj;
import com.jinyu.fdxc.struts.bean.Fdyx;
import com.jinyu.fdxc.struts.bean.SysUser;

public class FdyxDAO extends SpringJDBCTemplate{
	
	/**
	 *查询所有的沣东印象
	 */
	@SuppressWarnings("unchecked")
	public List<Fdyx> queryFdyxList(Object[] objs , Page page) throws Exception {
		 String sql  = " select *  from fdyx where 1=1 ";
		 List<Object> list = new ArrayList<Object>();
			if(objs!=null&&objs.length>0){
				if(objs.length>=1&&objs[0]!=null&&!"".equals(objs[0])){
					sql +=" and fdyx_id=? ";
					list.add(objs[0]);	
				}
				if(objs.length>=2&&objs[1]!=null&&!"".equals(objs[1])){
					sql +=" and fdyx_title like  ? ";
					list.add("%"+objs[1]+"%");	
				}
			}
			  sql += " and fdyx_title <> '' order by fdyx_id desc";
			return this.getJdbcTemplate().query(PageUtil.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MYSQL),list.toArray(), new Fdyx());
	}
	
	
	
	/**
	 *按id查询一条记录
	 */
	@SuppressWarnings("unchecked")
	public Fdyx findFdyxByID(int id) throws Exception {
		String sql = "  select *  from fdyx where fdyx_id="+id;
		List<Fdyx> fdyxList = this.getJdbcTemplate().query(sql,new Fdyx());
		if(fdyxList!=null&&fdyxList.size()>0){
			return fdyxList.get(0);
		}
		return null;
	}
	
	
	/**
	 *查询发布人
	 */
	@SuppressWarnings("unchecked")
	public SysUser findUserByID(int id) throws Exception {
		String sql = " select t2.* from fdyx t1 , sys_user t2 where t1.user_id = t2.user_id and t1.fdyx_id="+id;
		List<SysUser> userList = this.getJdbcTemplate().query(sql,new SysUser());
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}
		return null;
	}
	
	
	/**
	 *保存沣东印象
	 */
	public int saveFdyx(Fdyx fdyx) throws Exception {
		final String sql = "insert into fdyx (fdyx_title,fdyx_content,sub_date,dept_type,user_id,hold) values (?,?,?,?,?,?)";
		final Object[] objs = {fdyx.getFdyxTitle(),fdyx.getFdyxContent(),fdyx.getSubDate(),fdyx.getDeptType()
				,fdyx.getSysUser().getUserID(),fdyx.getHold()};
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
	public void editFdyx(Fdyx fdyx) throws Exception {
		String sql = " update fdyx set  fdyx_title=?,fdyx_content=?,sub_date=?,dept_type=?,user_id=?,hold=?  where fdyx_id=? ";
		Object[] objs = {fdyx.getFdyxTitle(),fdyx.getFdyxContent(),fdyx.getSubDate(),fdyx.getDeptType(),fdyx.getSysUser().getUserID()
				,fdyx.getHold(),fdyx.getFdyxID()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	
	/**
	 *删除
	 */
	public void deleteFdyxByID(int id) throws Exception {
		String sql = " delete from fdyx where fdyx_id="+id;
		this.getJdbcTemplate().update(sql);
	}
	
	
	
	/**
	 *删除附件 
	 */
	public void deleteFdfjByID(int id) throws Exception {
		String sql = " delete from fdfj where fdyx_id="+id;
		this.getJdbcTemplate().update(sql);
	}
	
	
	/**
	 *查询附件
	 */
	@SuppressWarnings("unchecked")
	public List<Fdfj> queryFdfjByFdIDList(int id) throws Exception {
		String sql = " select t2.* from fdyx t1 , fdfj t2 where  t1.fdyx_id = t2.fdyx_id and  t2.fdyx_id = "+id;
		return this.getJdbcTemplate().query(sql, new Fdfj());
	}
	
	
	
	/**
	 *保存 附件
	 */
	public int saveFdfj(Fdfj fdfj) throws Exception {
		final String sql = "insert into fdfj (fdfj_file_name,fdfj_file_type,fdfj_file_url,hold) values (?,?,?,?)";
		final Object[] objs = {fdfj.getFdfjFileName(),fdfj.getFdfjFileType(),fdfj.getFdfjFileUrl(),fdfj.getHold()};
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
	 *保存后插入附件中的外键（沣东印象的主键） 
	 */
	public void editFdfj(int fdyxID , int fdfjID) throws Exception {
		String sql = "update fdfj set fdyx_id=?  where fdfj_id=?";
		Object[] objs = {fdyxID , fdfjID};
		this.getJdbcTemplate().update(sql,objs);   
	}
	

}
