package com.fixedassetms.dao.impl;

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
	public int cntAddTu(String type) {
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

	
	
	
	@Override
	public int fixedAssetAdd(FixedAsset FixedAsset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fixedAssetDel(FixedAsset fixedAsset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fixedAssetUpDate(FixedAsset fixedAsset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FixedAsset fixedAssetSerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FixedAsset> fixedAssetSerByC(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FixedAsset> fixedAssetSerByT(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FixedAsset> fixedAssetSerByAuser(String Auser) {
		// TODO Auto-generated method stub
		return null;
	}

}
