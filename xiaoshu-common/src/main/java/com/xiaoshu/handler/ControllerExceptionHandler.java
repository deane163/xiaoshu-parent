package com.xiaoshu.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoshu.exception.BussinessException;
import com.xiaoshu.model.ErrorResponse;

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
