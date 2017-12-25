package com.xiaoshu.annotation;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

import com.xiaoshu.enums.LogType;

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
 * @Description : Log 日志信息
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月25日下午5:31:16
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Documented
@Inherited
@Target({METHOD})
public @interface Log {

	/**
	 * 操作说明
	 * @return
	 */
	String value() default "";
	
	/**
	 * 操作类型说明
	 * @return
	 */
	LogType type() default  LogType.NULL;
	
}
