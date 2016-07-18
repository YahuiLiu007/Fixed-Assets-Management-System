/**
 *������Աdao��ʵ�ַ���
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
	 * �������Ա��Ϣʵ��
	 * @param manager
	 * @return Ӱ������
	 */
	public int save(Manager manager) {
		String sql="insert into manager(name,password) values(?,?)";
		Object[] param={manager.getName(),manager.getPassword()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	/**
	 * ɾ������Ա��Ϣʵ��
	 * @param manager
	 * @return Ӱ������
	 */
	public int del(Manager manager) {
		String sql="delete from manager where id=?";
		Object[] param={manager.getId()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	/**
	 * ���¹���Ա��Ϣʵ��
	 * @param manager
	 * @return Ӱ������
	 */
	public int update(Manager manager) {
		String sql="update manager set name=?,password=? where id=?";
		Object[] param={manager.getName(),manager.getPassword(),manager.getId()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	
	/**
	 * ��ӡ���й���Ա��Ϣʵ��
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
	 * ���ݹ���Ա����������ҹ���Ա��Ϣʵ��
	 * @param manager
	 * @return manager����
	 */
	@Override
	public Manager findManager(Manager manager) {
		// TODO �Զ����ɵķ������
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
	 * ���ݹ���Ա�����ҹ���Ա
	 * @param ����Ա��
	 * @return true ���ҵ���false�������ҵ�
	 */
	@Override
	public boolean findManByName(String manName) {
		// TODO �Զ����ɵķ������
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
	 * ����id��ѯ����Ա��Ϣʵ��
	 * @param id
	 * @return manager����
	 */
	@Override
	public Manager getByID(int ID) {
		// TODO �Զ����ɵķ������
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
