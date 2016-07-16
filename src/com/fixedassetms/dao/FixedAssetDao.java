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
	 * @return 影响行数
	 */
 int fixedAssetAdd(FixedAsset FixedAsset);
	/**
	 * @param 固定资产对象
	 * 删除固定资产信息
	 * @return 影响行数
	 */
 int fixedAssetDel(FixedAsset FixedAsset);
	/**
	 * @param 固定资产对象
	 * 修改固定资产信息
	 * @return 影响行数
	 */
 int fixedAssetUpDate();
	/**
	 * @param 固定资产对象
	 * 按大类浏览固定资产信息
	 * @return 按大类分类固定资产链表
	 */
 List<FixedAsset> fixedAssetReadByC(FixedAsset FixedAsset);
	/**
	 * @param 固定资产对象
	 * 按小类浏览固定资产信息
	 *  @return 按小类分类固定资产链表
	 */
 List<FixedAsset>  fixedAssetReadByT(FixedAsset FixedAsset);
	/**
	 * @param 固定资产对象
	 * 按资产编号查询精确查找
	 *  @return 按资产编号查询精确查找所得固定资产
	 */
 FixedAsset fixedAssetSerById(FixedAsset FixedAsset);
	/**
	 * @param 固定资产对象
	 * 按资产类别查询罗列该类别下全部固定资产
	 * @return 按资产类别查询罗列该类别下全部固定资产链表
	 */
 List<FixedAsset>  fixedAssetSerByCNT(FixedAsset FixedAsset);
	/**
	 * @param 固定资产对象
	 * 按使用者罗列使用者所拥有全部固定资产
	 * @return 按使用者罗列使用者所拥有全部固定资产链表
	 */
 List<FixedAsset> fixedAssetSerByAuser(FixedAsset FixedAsset);

}
