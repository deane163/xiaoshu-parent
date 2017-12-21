package com.xiaoshu.enums;

public enum LogType {
	/**
	 * 查询操作
	 */
	QUERY,
	/**
	 * 更新操作
	 */
	UPDATE,
	/**
	 * 删除操作
	 */
	DELETE,
	/**
	 * 插入操作
	 */
	INSERT,
	/**
	 * 接口调用操作
	 */
	INTERFACE,
	/**
	 * Dubbo接口调用
	 */
	DUBBO,
	/**
	 * 不确定操作类型
	 */
	NULL

}
