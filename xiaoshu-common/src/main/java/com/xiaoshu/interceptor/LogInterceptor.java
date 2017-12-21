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
