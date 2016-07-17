package com.fixedassetms.biz;

import com.fixedassetms.entity.Manager;

/**
 * 固定资产领用与归还接口
 * @author zhaohui
 *	create on 2016-7-15
 */
public interface LendOrReturn {
	/**
	 * 固定资产领用方法
	 */
	void aLend(Manager manager);
	/**
	 * 固定资产归还方法
	 */
	void aReturn(Manager manager);
}
