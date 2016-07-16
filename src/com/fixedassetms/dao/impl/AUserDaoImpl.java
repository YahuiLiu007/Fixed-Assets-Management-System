/**
 * 登记人员增删改查接口的实现方法
 * @author banzhuang
 * create on 2016-7-14
 */
package com.fixedassetms.dao.impl;

import com.fixedassetms.dao.AUserDao;
import com.fixedassetms.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fixedassetms.entity.AUser;

public class AUserDaoImpl extends BaseDao implements AUserDao{
	/**
	 * 增加登记人员信息
	 */
	public int save(AUser auser) {
		String sql="insert into auser(name,duty,remark) values(?,?,?)";//向数据库中增添登记人员信息
		Object[] param={auser.getName(),auser.getDuty(),auser.getRemark()};
		int result=this.exceuteUpdate(sql, param);//更新数据库
		return result;
	}
	/**
	 * 通过ID删除登记人员信息
	 */
	public int del(AUser auser) {
		String sql="delete from auser where id=?";
		Object[] param={auser.getId()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

   /**
    * 更新登记人员信息
    */
	public int update(AUser auser) {
		String sql="update auser set name=?,duty=?,remark=? where id=?";
		Object[] param={auser.getName(),auser.getDuty(),auser.getRemark(),auser.getId()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

    /**
     * 根据姓名、职务查找登记人员
     */
	public AUser findUser(AUser auser) {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		AUser use=null;
		try{
			conn=this.getConnection();
			String sql="select * from auser where name=? and duty=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, use.getName());
			psmt.setString(2, use.getDuty());//在数据库中查找相应姓名与职务的登记人员
			
			rs=psmt.executeQuery();
			if(rs.next()){
				use=new AUser();
				use.setId(rs.getInt("id"));
				use.setName(rs.getString("name"));
				use.setDuty(rs.getString("duty"));
				use.setRemark(rs.getString("remark"));
			}
		}
			catch(SQLException ex){
				ex.printStackTrace(); 
			}
			finally{
				this.closeAll(conn, psmt, rs);
			}
			return use;
	}

    /**
     * 根据ID查找登记人员
     */
	public AUser getByID(int ID) {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		AUser user=null;
		try{
			conn=this.getConnection();
			String sql="select * from auser where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, ID);//在数据库中查找特定ID的登记人员
			
			rs=psmt.executeQuery();
			if(rs.next()){
				user=new AUser();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setDuty(rs.getString("duty"));
				user.setRemark(rs.getString("remark"));

			}
		}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			return user;
	}

    /**
     * 打印所有登记人员信息
     */
	public List showall() {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		AUser us=null;
		List<AUser> useshow=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select * from auser";
			psmt=conn.prepareStatement(sql);
			
			rs=psmt.executeQuery();
			while(rs.next()){
				us=new AUser();
				us.setId(rs.getInt("id"));
				us.setName(rs.getString("name"));
				us.setDuty(rs.getString("duty"));
				us.setRemark(rs.getString("remark"));

				useshow.add(us);
			}
		}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			finally{
				this.closeAll(conn, psmt, rs);
			}
			return useshow;

	}
	

}