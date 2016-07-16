package com.fixedassetms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fixedassetms.dao.BaseDao;
import com.fixedassetms.dao.FixedAssetDao;
import com.fixedassetms.entity.FixedAsset;

/**
 * 
 * @author muse and zhaohui
 * create on 2016-7-15 22:57:19
 */
public class FixedAssetDaoImpl extends BaseDao implements FixedAssetDao{
	/**
	 * 增加大类（cnt means Category and Type 大类和小类） 
	 * @param category 资产大类
	 * @return 影响行数
	 */
	public int cntAddC(String category) {
		String sql="insert into CategoryAndType(category,type) values(?,?)";
		Object[] param={category,null};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	/**
	 * 增加小类(insert)（cnt means Category and Type 大类和小类） 
	 * @param type 资产小类
	 * @return 影响行数
	 */
	public int cntAddTi(String category,String type){
		String sql="insert into CategoryAndType(category,type) values(?,?)";
		Object[] param={category,type};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	public int cntAddTu(String category,String type) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int cntDelC(String category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cntDelT(String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> cntShowTuC(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> cntShowT() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> cntShowC() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	/**
	 * 增加固定资产信息
	 */
		public int fixedAssetAdd(FixedAsset fixedAsset) {
			
			String sql="insert into FixedAsset(name,category,type,price,indate,status,auser,remark) values(?,?,?,?,?,?,?,?)";
			Object[] param={fixedAsset.getName(),fixedAsset.getCategory(),fixedAsset.getType(),fixedAsset.getPrice(),fixedAsset.getIndate(),fixedAsset.getStatus(),fixedAsset.getAuser(),fixedAsset.getRemark()};
			int result=this.exceuteUpdate(sql, param);
			return result;
		}

		/**
		 * 删除固定资产信息
		 */
		public int fixedAssetDel(FixedAsset fixedAsset) {
			String sql="delete from FixedAsset where id=?";
			Object[] param={fixedAsset.getId()};
			int result=this.exceuteUpdate(sql, param);
			return result;
		}
	/**
	 * 修改固定资产信息
	 */
		public int fixedAssetUpDate(FixedAsset fixedAsset) {
			String sql="update FixedAsset set name=?,category=?,type=?,price=?,indate=?,status=?,auser=?,remark=? where id=?";
			Object[] param={fixedAsset.getName(),fixedAsset.getCategory(),fixedAsset.getType(),fixedAsset.getPrice(),fixedAsset.getIndate(),fixedAsset.getStatus(),fixedAsset.getAuser(),fixedAsset.getRemark(),fixedAsset.getId()};
			int result=this.exceuteUpdate(sql,param);
			return result;
		}

	/**
	 * 按资产编号获得指定固定资产信息
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
		 * 按大类查询罗列该类别下全部固定资产
		 */
		public List<FixedAsset> fixedAssetSerByC(String category) {
			
			return null;
		}

	/**
	 * 按小类查询罗列该类别下全部资产
	 */
		public List<FixedAsset> fixedAssetSerByT(String type) {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * 按使用者罗列使用者所拥有全部固定资产
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
