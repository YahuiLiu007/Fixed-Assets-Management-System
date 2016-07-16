package com.fixedassetms.biz;
/**
 * 
 * @author muse
 *create on 2016-7-16 14:54:42
 *
 */

public interface FixedAssetManage {

	/**
	 * 固定资产增加界面
	 */
	public void famAdd();
	/**
	 * 固定资产删除界面
	 */
	public void famDel();
	/**
	 * 固定资产修改界面
	 */
	public void famUpDate();
	/**
	 * 按资产编号查询精确查找界面
	 */
	public void famSerById();
	/**
	 * 按大类查询罗列界面
	 */
	public void famSerByC();
	/**
	 * 按小类查询罗列该类别下全部固定资产界面
	 */
	public void famSerByT();

	/**
	 * 按大类别浏览界面
	 */
	public void famReadByC();
	/**
	 * 按小类浏览界面
	 */
	public void famReadByT();
	/**
	 * 按使用者查询界面
	 */
	public void famSerByAuser();
	
	

}
