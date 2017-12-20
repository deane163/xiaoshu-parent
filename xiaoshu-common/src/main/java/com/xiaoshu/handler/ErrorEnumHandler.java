package com.xiaoshu.handler;

public interface ErrorEnumHandler {

    /**
     * 用于 CommonErrorEnum 或 BussinessErrorEnum 中抛出异常
     */
    public void throwsException() throws Exception;
	
}
