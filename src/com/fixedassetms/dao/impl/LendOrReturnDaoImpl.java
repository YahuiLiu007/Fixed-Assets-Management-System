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
 * �̶��ʲ�������黹�����ʵ��
 * @author zhaohui
 *	create on 2016-7-15
 *modify by muse on 2016-7-17
 */
public class LendOrReturnDaoImpl extends BaseDao implements LendOrReturnDao{

	/**
	 * �̶��ʲ����ñ�����ʵ��
	 * @param param Ԥ����� SQL ����еġ������������ַ�������          
	 * @return Ӱ�������
	 */
	public int lendAdd(Object[] param) {
		String sql="insert into Lend(fixedasset_id,auser_id,lenddate,purpose,manager_id,remark) values(?,?,?,?,?,?)";
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	/**
	 * �̶��ʲ����ñ��ӡ  
	 * @return �̶��ʲ����ñ���ȫ����Ϣ
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
	 * �̶��ʲ��黹������ʵ��
	 * @param param Ԥ����� SQL ����еġ������������ַ�������          
	 * @return Ӱ�������
	 */
	public int retAdd(Object[] param) {
		String sql="insert into Ret(fixedasset_id,auser_id,returndate,returnstatus,manager_id,remark) values(?,?,?,?,?,?)";
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	/**
	 * �̶��ʲ��黹���ӡ  
	 * @return �̶��ʲ��黹����ȫ����Ϣ
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
