package com.fixedassetms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fixedassetms.dao.BaseDao;
import com.fixedassetms.dao.FixedAssetDao;
import com.fixedassetms.entity.FixedAsset;

/**
 * �̶��ʲ���͹̶��ʲ��������ʵ��
 * @author muse and zhaohui
 * create on 2016-7-15 22:57:19
 */
public class FixedAssetDaoImpl extends BaseDao implements FixedAssetDao{
	/**
	 * �̶��ʲ��������𣨴����С�ࣩʵ��
	 * @param category �ʲ����࣬type �ʲ�С��
	 * @return Ӱ������
	 */
	public int cntAddCT(String category,String type) {
		String sql="insert into CategoryAndType(category,type) values(?,?)";
		Object[] param={category,type};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	/**
	 * �̶��ʲ���ɾ����𣨴����С�ࣩʵ��
	 * @param category �ʲ����࣬type �ʲ�С��
	 * @return Ӱ������
	 */
	public int cntDelCT(String category,String type) {
		String sql="delete from CategoryAndType where category=? and type=?";
		Object[] param={category,type};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	/**
	 * �̶��ʲ����ѯС��ʵ��
	 * @param type �ʲ�С��
	 * @return Ӱ������
	 */
	public boolean cntSerT(String type){
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		boolean flag=false;
		try{
			conn=this.getConnection();
			String sql="select * from CategoryAndType where type=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, type);
			
			rs=psmt.executeQuery();
			if(rs.next()){
				flag=true;
			}
		}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			finally{
				this.closeAll(conn, psmt, rs);
			}
		return flag;
	}
	/**
	 * ��ӡĳ�����µ�����С�ࣨcnt means Category and Type �����С�ࣩ
	 * @param category ĳ�ʲ�����
	 * @return �ʲ�С������
	 */
	public List<String> cntShowTuC(String category) {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		List<String> typeuCList=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select type from CategoryAndType where category=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, category);
			
			rs=psmt.executeQuery();
			while(rs.next()){
				typeuCList.add(rs.getString("type"));
			}
		}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			finally{
				this.closeAll(conn, psmt, rs);
			}
			return typeuCList;
	}
	/**
	 * ��ӡ���д��ࣨcnt means Category and Type �����С�ࣩ
	 * @return �ʲ���������
	 */
	public List<String> cntShowC() {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Set<String> categorySet=new HashSet();
		List<String> categoryList=new ArrayList();
		try{
			conn=this.getConnection();
			String sql="select category from CategoryAndType";
			psmt=conn.prepareStatement(sql);
			
			rs=psmt.executeQuery();
			while(rs.next()){
				categorySet.add(rs.getString("category"));
			}
			categoryList.addAll(categorySet);
		}
			catch(SQLException ex){
				ex.printStackTrace();
			}
			finally{
				this.closeAll(conn, psmt, rs);
			}
			return categoryList;
	}

	
	
	/**
	 * ���ӹ̶��ʲ���Ϣ
	 */
		public int fixedAssetAdd(FixedAsset fixedAsset) {
			
			String sql="insert into FixedAsset(name,category,type,price,indate,status,auser,remark) values(?,?,?,?,?,?,?,?)";
			Object[] param={fixedAsset.getName(),fixedAsset.getCategory(),fixedAsset.getType(),fixedAsset.getPrice(),fixedAsset.getIndate(),fixedAsset.getStatus(),fixedAsset.getAuser(),fixedAsset.getRemark()};
			int result=this.exceuteUpdate(sql, param);
			return result;
		}

		/**
		 * ɾ���̶��ʲ���Ϣ
		 */
		public int fixedAssetDel(FixedAsset fixedAsset) {
			String sql="delete from FixedAsset where id=?";
			Object[] param={fixedAsset.getId()};
			int result=this.exceuteUpdate(sql, param);
			return result;
		}
	/**
	 * �޸Ĺ̶��ʲ���Ϣ
	 */
		public int fixedAssetUpDate(FixedAsset fixedAsset) {
			String sql="update FixedAsset set name=?,category=?,type=?,price=?,indate=?,status=?,auser=?,remark=? where id=?";
			Object[] param={fixedAsset.getName(),fixedAsset.getCategory(),fixedAsset.getType(),fixedAsset.getPrice(),fixedAsset.getIndate(),fixedAsset.getStatus(),fixedAsset.getAuser(),fixedAsset.getRemark(),fixedAsset.getId()};
			int result=this.exceuteUpdate(sql,param);
			return result;
		}

	/**
	 * ���ʲ���Ż��ָ���̶��ʲ���Ϣ
	 */
		public FixedAsset fixedAssetSerById(int id) {
			Connection conn=null;
			PreparedStatement psmt=null;
			ResultSet rs=null;
			FixedAsset fixedAsset=null;
			try{
				conn=this.getConnection();
				String sql="select * from FixedAsset where id=?";
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1, id);
				
				rs=psmt.executeQuery();
				if(rs.next()){
					fixedAsset=new FixedAsset();
					fixedAsset.setId(rs.getInt("id"));
					fixedAsset.setName(rs.getString("name"));
					fixedAsset.setCategory(rs.getString("category"));
					fixedAsset.setType(rs.getString("type"));
					fixedAsset.setPrice(rs.getInt("price"));
					fixedAsset.setIndate(rs.getDate("indate"));
					fixedAsset.setStatus(rs.getString("status"));
					fixedAsset.setAuser(rs.getString("auser"));
					fixedAsset.setRemark(rs.getString("remark"));
				}
			}
				catch(SQLException ex){
					ex.printStackTrace();
				}
				return fixedAsset;

		}
		/**
		 * �������ѯ���и������ȫ���̶��ʲ�
		 */
		public List<FixedAsset> fixedAssetSerByC(String category) {
			
			return null;
		}

	/**
	 * ��С���ѯ���и������ȫ���ʲ�
	 */
		public List<FixedAsset> fixedAssetSerByT(String type) {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * ��ʹ��������ʹ������ӵ��ȫ���̶��ʲ�
		 */
		public List<FixedAsset> fixedAssetSerByAuser(String Auser) {
			Connection conn=null;
			PreparedStatement psmt=null;
			ResultSet rs=null;
			FixedAsset fixedAsset=null;
			List<FixedAsset> fixedAssetl= new ArrayList();
			try{
				conn=this.getConnection();
				String sql="select * from FixedAsset where auser=?";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, Auser);
				rs=psmt.executeQuery();
				if(rs.next()){
					fixedAsset=new FixedAsset();
					fixedAsset.setId(rs.getInt("id"));
					fixedAsset.setName(rs.getString("name"));
					fixedAsset.setCategory(rs.getString("category"));
					fixedAsset.setType(rs.getString("type"));
					fixedAsset.setPrice(rs.getInt("price"));
					fixedAsset.setIndate(rs.getDate("indate"));
					fixedAsset.setStatus(rs.getString("status"));
					fixedAsset.setAuser(rs.getString("auser"));
					fixedAsset.setRemark(rs.getString("remark"));
					fixedAssetl.add(fixedAsset);
				}
			}
				catch(SQLException ex){
					ex.printStackTrace();
				}
				return fixedAssetl;


		}


}
