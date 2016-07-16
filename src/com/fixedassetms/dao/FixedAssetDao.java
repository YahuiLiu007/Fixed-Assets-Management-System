package com.fixedassetms.dao;

import java.util.List;

import com.fixedassetms.entity.FixedAsset;
/**
 * 固定资产管理表操作接口
 * @author muse
 *create on 2016-7-15 20:38:04
 */
public interface FixedAssetDao {
	/**
	 * 增加类别 （cnt means Category and Type 大类和小类）
	 * @return 影响行数
	 */
 int cntAdd(Object [] param);
	/**
	 * 删除类（cnt means Category and Type 大类和小类）
	 * @return 影响行数
	 */
 int cntDel(Object [] param);
	/**
	 * 打印所有大类和小类及关系
	 * @return 
	 */
 String cntPrint(Object [] param);
	/**
	 * 增加固定资产信息
<<<<<<< HEAD
	 * @return 影响行数
	 */
 
 int fixedAssetAdd(FixedAsset FixedAsset);
	/**
=======
	 * 
>>>>>>> 0c8c4924fd07bab3b5bc36b07c15eb6d7f2e7967
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
 List<FixedAsset> fixedAssetSerByAuser(FixedAsset FixedAsset);

}
