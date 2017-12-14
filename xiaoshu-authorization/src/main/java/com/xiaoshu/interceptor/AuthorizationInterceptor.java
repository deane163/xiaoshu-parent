package com.xiaoshu.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xiaoshu.annotation.Authorization;
import com.xiaoshu.config.Constants;

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
 * @Date : Create in 2017年12月14日下午6:23:48
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("AuthorizationInterceptor-----------------------------");
		 //如果不是映射到方法直接通过
		if(!(handler instanceof HandlerMethod)){
			return true;
		}
		HandlerMethod method = (HandlerMethod) handler;
		
		//如果方法和类中都没有@Authorization注解，则直接跳过
		if(method.getBean().getClass().getAnnotation(Authorization.class)==null
				&&method.getMethodAnnotation(Authorization.class)==null){
			return true;
		}
		//从head中获取验证信息
		//String authentication = getAuthentication(request);
		
		//TokenModel tokenModel = tokenManger.getToken(authentication);
		//if(tokenModel==null||!tokenManger.checkToken(tokenModel)){
			// response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			//response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			/* ServletOutputStream os = response.getOutputStream();
			 JSONObject json = new JSONObject();
			 json.put("errCode", "-1");
			 json.put("msg", "token验证错误,请重新登录");
			 json.put("data", null);
			 os.write(json.toJSONString().getBytes("utf-8"));
			 os.close();*/
			//return false;
		//}
		//将userId放入request中
		//request.setAttribute(Constants.CURRENT_USER_ID, tokenModel.getUserId());
		return true;
	}
	
	/**
	 * 从头部获得Authorization 信息
	 * @param request
	 * @return
	 */
	@SuppressWarnings({"unused" })
	private String getAuthentication(HttpServletRequest request) {
		String authentication = request.getHeader(Constants.AUTHORIZATION);
		if (authentication == null) {
			Cookie[] cookies = request.getCookies();
			if (cookies == null) {
                return null;
            }
			for (Cookie cookie : cookies) {
				if (Constants.AUTHORIZATION.equals(cookie.getName())) {
					authentication = cookie.getValue();
					break;
				}
			}
		}
		return authentication;
	}
}
