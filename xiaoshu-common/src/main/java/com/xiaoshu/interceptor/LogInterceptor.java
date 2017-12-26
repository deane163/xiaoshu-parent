package com.xiaoshu.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.xiaoshu.annotation.Log;
import com.xiaoshu.service.SystemLogService;
import com.xiaoshu.util.HttpHelper;
import com.xiaoshu.util.IpHelper;

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
 * @Description : 统一对日志信息做拦截操作
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月26日下午8:10:10
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Aspect
@Component
public class LogInterceptor {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired(required = false)
	private SystemLogService systemLogService;
	
	private static final String LOG_CONTENT = "[类名]:%s,[方法参数]:%s";

	@Pointcut("@annotation(com.xiaoshu.annotation.Log)")
	private void anyMethod() {
		// 定义切入点，Poincut
	}

	@Around("anyMethod()")
	public Object doExecute(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = HttpHelper.getHttpServletRequest();
		logger.info("进行日志信息记录...");
		if (null == request)
			return joinPoint.proceed();

		// 获取ip地址
		String ipAddress = IpHelper.getIpAddr(request);
		// 获取用户id，此处先定义为空，后面再获得用户的id
		//String userId = StringUtils.EMPTY;
		String deviceId = StringUtils.EMPTY;

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Log log = method.getAnnotation(Log.class);
		// 获取操作说明
		String operation = log.value();
		// 获取操作类型
		String operationType = log.type().toString();
		// 获取类名
		String className = joinPoint.getTarget().getClass().getName();
		// 获取参数
		Object[] params = joinPoint.getArgs();
		String paramsStr = getParamStr(params, method);

		String content = String.format(LOG_CONTENT, className, method.getName()
				+ paramsStr);
		// 执行操作
		StopWatch clock = new StopWatch();
		clock.start(); // 计时开始
		Object object = joinPoint.proceed();
		clock.stop(); // 计时结束
		systemLogService.saveLog(content, ipAddress, operation, operationType, clock.getTotalTimeSeconds(), deviceId);
		//返回执行信息
		return object;
	}
	
	private String getParamStr(Object[] params, Method method) {
		StringBuffer bf = new StringBuffer("(");
		Class<?>[] clazzs = method.getParameterTypes();
		for(int i=0;i<params.length;i++){
			Object obj = params[i];
			Class<?> clazz = clazzs[i];
			if(obj instanceof HttpServletRequest){
				continue;
			}
			
			if(obj instanceof MultipartFile)
				obj = ((MultipartFile)obj).getOriginalFilename();
			
			if(obj instanceof MultipartFile[]){
				StringBuilder sb = new StringBuilder();
				MultipartFile[] tmp = ((MultipartFile[])obj);
				for(int j=0; j<tmp.length; j++){
					sb.append(tmp[j].getOriginalFilename()).append(",");
				}
				obj = sb.toString().substring(0, sb.toString().length()-1);
			}
			//如果是基本类型，
			if(clazz.getClass().isPrimitive()){
				String typeName = clazz.getSimpleName();
				bf.append(typeName).append(" ");
				bf.append(obj).append(",");
			}else{
				String typeName = clazz.getName();
				bf.append(typeName).append(" ");
				bf.append(JSONObject.toJSONString(obj)).append(",");
			}
		}
		bf.deleteCharAt(bf.length()-1);
		bf.append(")");
		return bf.toString();
	}

}
