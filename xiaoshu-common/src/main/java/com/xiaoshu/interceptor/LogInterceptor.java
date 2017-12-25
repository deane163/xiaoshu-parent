package com.xiaoshu.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xiaoshu.service.SystemLogService;

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
 * @Date : Create in 2017年12月25日下午5:31:44
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Aspect
@Component
public class LogInterceptor {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired(required = false)
	private SystemLogService systemLogService;
	
	@Pointcut("@annotation(com.xiaoshu.annotation.Log)")
	private void anyMethod(){
		//定义切入点，Poincut
	}
	
	@Around("anyMethod()")
	public Object doExecute(ProceedingJoinPoint joinPoint) throws Throwable{
		logger.info("====> 记录日志信息到数据库");
		//保存日志数据到数据库
		return joinPoint.proceed();
	}
	
}
