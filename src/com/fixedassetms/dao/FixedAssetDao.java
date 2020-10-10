package com.fixedassetms.dao;

import java.util.List;
import com.fixedassetms.entity.FixedAsset;
/**
 * 固定资产管理表和固定资产类别表操作接口
 * @author muse and zhaohui
 * create on 2016-7-15
 * modified by muse on 2016-7-17
 */
public interface FixedAssetDao {
	/**
	 * 固定资产表添加类别（大类和小类）
	 * @param category 资产大类，type 资产小类
	 * @return 影响行数
	 */
	int cntAddCT(String category,String type);
	/**
	 * 固定资产表删除类别（大类和小类）
	 * @param category 资产大类，type 资产小类
	 * @return 影响行数
	 */
	int cntDelCT(String category,String type);
	/**
	 * 固定资产表查询类别（大类和小类）
	 * @param category 资产大类，type 资产小类
	 * @return 影响行数
	 */
	boolean cntSerCT(String category,String type);
	/**
	 * 固定资产表打印某大类下的所有小类
	 * @param category 某资产大类
	 * @return 资产小类链表
	 */
	List<String> cntShowTuC(String category);
	/**
	 * 固定资产表打印所有大类
	 * @return 资产大类链表
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
	int fixedAssetUpdate(FixedAsset fixedAsset);
	/** 
	 * 按资产编号查询精确查找
	 * 
	 * @param 固定资产对象
	 *
	 *  @return 按资产编号查询精确查找所得固定资产
	 */
	FixedAsset fixedAssetSerById(int id);
	/**
	 * 按类别查询罗列该类别下全部固定资产
	 * 
	 * @param categoty 大类，type 小类 
	 * 
	 * @return 按资产类别查询罗列该类别下全部固定资产链表
	 */
	List<FixedAsset>  fixedAssetSerByCT(String category,String type);
	/**
	 * 按使用者罗列使用者所拥有全部固定资产
	 * 
	 * @param 固定资产对象
	 * 
	 * @return 按使用者罗列使用者所拥有全部固定资产链表
	 */
	List<FixedAsset> fixedAssetSerByAuser(int Auser_id);

}
