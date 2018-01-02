package com.xiaoshu.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xiaoshu.annotation.ClientAuthorization;
import com.xiaoshu.manager.ClientValidManager;

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
 * @Description : 通过AOP的方法，对注解进行拦截操作，主要是验证 请求端的合法性验证
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月19日下午8:02:47
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Aspect
@Component
public class ClientValideInterceptor {
	
	@Autowired(required = false)
	private ClientValidManager clientManager;

	@Pointcut("@annotation(com.xiaoshu.annotation.ClientAuthorization)")
	private void anyMethod(){
		//定义切点
	}
	
	@Around("anyMethod()")
	public Object doExecute(ProceedingJoinPoint joinPoint) throws Throwable{
		 // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        
		// 若目标方法忽略了安全性检查，则直接调用目标方法
        if(!method.isAnnotationPresent(ClientAuthorization.class) 
        		&&  !method.getClass().isAnnotationPresent(ClientAuthorization.class)){
        	return joinPoint.proceed();
        }
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();
       
		//如果客户端无效，则直接返回
		if(!clientManager.checkClientValide(request)){
			response.sendError(HttpServletResponse.SC_FORBIDDEN, " Token is invalid");
			return null;
		}
		//如果app_token 有效则继续执行方法
		return joinPoint.proceed();
	}
}
