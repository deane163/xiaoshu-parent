package com.xiaoshu.enums;

/**
 * 
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 *
 * @Description : 
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月25日下午5:31:29
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
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
