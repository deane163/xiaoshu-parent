package com.xiaoshu.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xiaoshu.annotation.ClientAuthorization;
import com.xiaoshu.manager.TokenManager;

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
 * @Date : Create in 2017年12月19日下午8:02:47
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Aspect
@Component
public class ClientValideInterceptor {
	
	@Autowired
	private TokenManager tokenManager;

	@Pointcut("@annotation(com.xiaoshu.annotation.ClientAuthorization)")
	private void anyMethod(){
		
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
        String token = getAuthentication(request);
        //如果Token 大小不符合规则，无效则抛出异常
		if(StringUtils.isEmpty(token)){
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "Token is null or Token is invalid");
			return null;
		}
		//如果Token无效，则直接返回
		if(!tokenManager.checkToken(token)){
			response.sendError(HttpServletResponse.SC_FORBIDDEN, " Token is invalid");
			return null;
		}
		//如果app_token 有效则继续执行方法
		return joinPoint.proceed();
	}
	
	
	//从头部或者cookies中获得Token信息
		private String getAuthentication(HttpServletRequest request) {
			String authentication = request.getHeader("authorization");
			if (authentication == null) {
				Cookie[] cookies = request.getCookies();
				if (cookies == null) {
	                return null;
	            }
				for (Cookie cookie : cookies) {
					if ("authorization".equals(cookie.getName())) {
						authentication = cookie.getValue();
						break;
					}
				}
			}
			return authentication;
		}
}
