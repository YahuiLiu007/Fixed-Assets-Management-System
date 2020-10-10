package com.fixedassetms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fixedassetms.dao.BaseDao;
import com.fixedassetms.dao.LendOrReturnDao;
/**
 * 固定资产领用与归还表操作实现
 * @author zhaohui
 *	create on 2016-7-15
 *modify by muse on 2016-7-17
 */
public class LendOrReturnDaoImpl extends BaseDao implements LendOrReturnDao{

	/**
	 * 固定资产领用表增添实现
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组          
	 * @return 影响的行数
	 */
	public int lendAdd(Object[] param) {
		String sql="insert into Lend(fixedasset_id,auser_id,lenddate,purpose,manager_id,remark) values(?,?,?,?,?,?)";
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	/**
	 * 固定资产领用表打印  
	 * @return 固定资产领用表里全部消息
	 */
	public List<String> lendShow(){
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		List<String> lList=new ArrayList();
		
		try{
			conn=this.getConnection();
			String sql="select * from Lend";
			psmt=conn.prepareStatement(sql);
			
			rs=psmt.executeQuery();
			while(rs.next()){
				String s="";
				s+=rs.getInt("fixedasset_id");
				s+="\t\t";
				s+=rs.getInt("auser_id");
				s+="\t\t";
				s+=rs.getString("lenddate");
				s+="\t";
				s+=rs.getString("purpose");
				s+="\t";
				s+=rs.getInt("manager_id");
				s+="\t\t";
				s+=rs.getString("remark");
				
				lList.add(s);
			}
		}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			finally{
				this.closeAll(conn, psmt, rs);
			}
			return lList;
	}
	/**
	 * 固定资产归还表增添实现
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组          
	 * @return 影响的行数
	 */
	public int retAdd(Object[] param) {
		String sql="insert into Ret(fixedasset_id,auser_id,returndate,returnstatus,manager_id,remark) values(?,?,?,?,?,?)";
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	/**
	 * 固定资产归还表打印  
	 * @return 固定资产归还表里全部消息
	 */
	public List<String> retShow(){
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		List<String> rList=new ArrayList();
		
		try{
			conn=this.getConnection();
			String sql="select * from Ret";
			psmt=conn.prepareStatement(sql);
			
			rs=psmt.executeQuery();
			while(rs.next()){
				String s="";
				s+=rs.getInt("fixedasset_id");
				s+="\t\t";
				s+=rs.getInt("auser_id");
				s+="\t\t";
				s+=rs.getString("returndate");
				s+="\t";
				s+=rs.getString("returnstatus");
				s+="\t\t";
				s+=rs.getInt("manager_id");
				s+="\t\t";
				s+=rs.getString("remark");
				
				rList.add(s);
			}
		}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			finally{
				this.closeAll(conn, psmt, rs);
			}
			return rList;
	}
}
