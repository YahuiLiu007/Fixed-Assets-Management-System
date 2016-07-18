/**
 *管理人员dao层实现方法
 * @author wenxing
 * create on 2016-7-15 22:57:19
 */
package com.fixedassetms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fixedassetms.dao.BaseDao;
import com.fixedassetms.dao.ManagerDao;

import com.fixedassetms.entity.Manager;;

public class ManagerDaoImpl extends BaseDao implements ManagerDao{
	/**
	 * 增添管理员信息实现
	 * @param manager
	 * @return 影响行数
	 */
	public int save(Manager manager) {
		String sql="insert into manager(name,password) values(?,?)";
		Object[] param={manager.getName(),manager.getPassword()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	/**
	 * 删除管理员信息实现
	 * @param manager
	 * @return 影响行数
	 */
	public int del(Manager manager) {
		String sql="delete from manager where id=?";
		Object[] param={manager.getId()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	/**
	 * 更新管理员信息实现
	 * @param manager
	 * @return 影响行数
	 */
	public int update(Manager manager) {
		String sql="update manager set name=?,password=? where id=?";
		Object[] param={manager.getName(),manager.getPassword(),manager.getId()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	
	/**
	 * 打印所有管理员信息实现
	 * @param 
	 * @return list
	 */
	public List<Manager> showall(){
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Manager man=null;
		List<Manager> masl=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select * from manager";
			psmt=conn.prepareStatement(sql);
			
			rs=psmt.executeQuery();
			while(rs.next()){
				man=new Manager();
				man.setId(rs.getInt("id"));
				man.setName(rs.getString("name"));
				man.setPassword(rs.getString("password"));
				
				masl.add(man);
			}
		}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			finally{
				this.closeAll(conn, psmt, rs);
			}
			return masl;
	}
	/**
	 * 根据管理员名和密码查找管理员信息实现
	 * @param manager
	 * @return manager对象
	 */
	@Override
	public Manager findManager(Manager manager) {
		// TODO 自动生成的方法存根
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Manager man=null;
		try{
			conn=this.getConnection();
			String sql="select * from manager where name=? and password=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, manager.getName());
			psmt.setString(2, manager.getPassword());
			
			rs=psmt.executeQuery();
			if(rs.next()){
				man=new Manager();
				man.setId(rs.getInt("id"));
				man.setName(rs.getString("name"));
				man.setPassword(rs.getString("password"));
			
			}
		}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			finally{
				this.closeAll(conn, psmt, rs);
			}
			return man;
	}
	/**
	 * 根据管理员名查找管理员
	 * @param 管理员名
	 * @return true 能找到，false，不能找到
	 */
	@Override
	public boolean findManByName(String manName) {
		// TODO 自动生成的方法存根
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Manager man=null;
		try{
			conn=this.getConnection();
			String sql="select * from manager where name=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, manName);
			
			rs=psmt.executeQuery();
			if(rs.next()){
				return true;
			
			}
		}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			finally{
				this.closeAll(conn, psmt, rs);
			}
			return false;
	}
	/**
	 * 根据id查询管理员信息实现
	 * @param id
	 * @return manager对象
	 */
	@Override
	public Manager getByID(int ID) {
		// TODO 自动生成的方法存根
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Manager man=null;
		try{
			conn=this.getConnection();
			String sql="select * from manager where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, ID);
			
			rs=psmt.executeQuery();
			if(rs.next()){
				man=new Manager();
				man.setId(rs.getInt("id"));
				man.setName(rs.getString("name"));
				man.setPassword(rs.getString("password"));

			}
		}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			return man;
	}
}
