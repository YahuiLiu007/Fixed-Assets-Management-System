package com.fixedassetms.biz;
/**
 * 固定资产领用与归还接口
 * @author zhaohui
 *	create 2016-7-15
 */
public interface LendOrReturn {
	/**
	 * 固定资产领用方法
	 */
	boolean alend();
	/**
	 * 固定资产归还方法
	 */
	boolean areturn();
}
