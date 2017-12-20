package com.xiaoshu.model;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4395265852079927985L;

	private int code;

	private String msg;

	public ErrorResponse() {
		super();
	}
	
	public ErrorResponse(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString(){
		  return "ExceptionResponse [code=" + code + ", message=" + msg + "]";
	}

}
