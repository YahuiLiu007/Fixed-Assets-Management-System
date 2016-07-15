package com.fixedassetms.dao;
import java.util.Date;
import java.util.List;

import com.fixedassetms.entity.FixedAsset;
/**
 * 
 * @author muse
 *create on 2016-7-15 20:38:04
 */
public interface FixedAssetDao {
	/**
	 * 增加类别 （CNT means Category and Type 大类和小类）
	 */
	public int CNTAdd(Object [] param);
	/**
	 * 删除类（CNT means Category and Type 大类和小类）
	 */
	public int CNTDel(Object [] param);
	/**
	 * 打印所有大类和小类及关系
	 */
	public String CNTPrint(Object [] param);
	/**
	 * 增加固定资产信息
	 */
	public int FixedAssetAdd(FixedAsset FixedAsset);
	/**
	 * 删除固定资产信息
	 */
	public int FixedAssetDel(FixedAsset FixedAsset);
	/**
	 * 按大类浏览固定资产信息
	 */
	public List<FixedAsset> FixedAssetReadByC(FixedAsset FixedAsset);
	/**
	 * 按小类浏览固定资产信息
	 */
	public List<FixedAsset>  FixedAssetReadByT(FixedAsset FixedAsset);
	/**
	 * 按资产编号查询精确查找
	 */
	public List<FixedAsset>  FixedAssetSerById(FixedAsset FixedAsset);
	/**
	 * 按资产类别查询罗列该类别下全部固定资产
	 */
	public List<FixedAsset>  FixedAssetSerByCNT(FixedAsset FixedAsset);
	/**
	 * 按使用者罗列使用者所拥有全部固定资产
	 */

}
