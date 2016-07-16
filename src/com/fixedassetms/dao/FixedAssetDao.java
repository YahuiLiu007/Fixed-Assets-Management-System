package com.fixedassetms.dao;

import java.util.List;

import com.fixedassetms.entity.FixedAsset;
/**
 * 固定资产管理表操作接口
 * @author muse and zhaohui
 * create on 2016-7-15 20:38:04
 */
public interface FixedAssetDao {
	/**
	 * 增加大类（cnt means Category and Type 大类和小类） 
	 * @param category 资产大类
	 * @return 影响行数
	 */
	int cntAddC(String category);
	/**
	 * 增加小类(insert)（cnt means Category and Type 大类和小类） 
	 * @param type 资产小类
	 * @return 影响行数
	 */
	int cntAddTi(String category,String type);
	/**
	 * 增加小类(update)（cnt means Category and Type 大类和小类） 
	 * @param type 资产小类
	 * @return 影响行数
	 */
	int cntAddTu(String category,String type);
	/**
	 * 删除大类（cnt means Category and Type 大类和小类）
	 * @param category 资产大类
	 * @return 影响行数
	 */
	int cntDelC(String category);
	/**
	 * 删除小类（cnt means Category and Type 大类和小类）
	 * @param type 资产小类
	 * @return 影响行数
	 */
	int cntDelT(String type);
	/**
	 * 打印某大类下的所有小类（cnt means Category and Type 大类和小类）
	 * @param category 某资产大类
	 * @return 资产小类链表
	 */
	List<String> cntShowTuC(String category);
	/**
	 * 打印所有大类（cnt means Category and Type 大类和小类）
	 * @return 资产大类链表
	 */
	List<String> cntShowT();
	/**
	 * 打印所有小类（cnt means Category and Type 大类和小类）
	 * @return 资产小类链表
	 */
	List<String> cntShowC();

	
	
	/**
	 * 增加固定资产信息
	 * 
	 * @param 固定资产对象
	 * 
	 * @return 影响行数
	 */
	int fixedAssetAdd(FixedAsset fixedAsset);
	/**
	 * 删除固定资产信息
	 * 
	 * @param 固定资产对象
	 * 
	 * @return 影响行数
	 */
	int fixedAssetDel(FixedAsset fixedAsset);
	/**
	 * 修改固定资产信息
	 * 
	 * @param 固定资产对象
	 * 
	 * @return 影响行数
	 */
	int fixedAssetUpDate(FixedAsset fixedAsset);
	/** 
	 * 按资产编号查询精确查找
	 * 
	 * @param 固定资产对象
	 *
	 *  @return 按资产编号查询精确查找所得固定资产
	 */
	FixedAsset fixedAssetSerById(int id);
	/**
	 * 按大类查询罗列该类别下全部固定资产
	 * 
	 * @param String 大类
	 * 
	 * @return 按资产类别查询罗列该类别下全部固定资产链表
	 */
	List<FixedAsset>  fixedAssetSerByC(String category);
	/**
	 * 按小类查询罗列该类别下全部固定资产
	 * 
	 * @param String 小类
	 * 
	 * @return 按资产类别查询罗列该类别下全部固定资产链表
	 */
	List<FixedAsset>  fixedAssetSerByT(String type);
	/**
	 * 按使用者罗列使用者所拥有全部固定资产
	 * 
	 * @param 固定资产对象
	 * 
	 * @return 按使用者罗列使用者所拥有全部固定资产链表
	 */
	List<FixedAsset> fixedAssetSerByAuser(String Auser);

}
