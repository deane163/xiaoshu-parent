package com.xiaoshu.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoshu.exception.BussinessException;
import com.xiaoshu.model.ErrorResponse;

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
 * @Description : 统一抛出异常处理，返回方式处理
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月20日下午3:31:00
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

	@ExceptionHandler(value = BussinessException.class)
	public ErrorResponse bussessExceptionHandler(HttpServletRequest request,
			HttpServletResponse response,
			BussinessException errors) {
		//设置头部返回状态码
		response.setStatus(errors.getHttpStatus());
		return errors.getErrorResponse();
	}

}
