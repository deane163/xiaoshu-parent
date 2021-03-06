/**
 * 
 */
package com.xiaoshu.task.impl;

import java.lang.reflect.Constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.xiaoshu.task.DataHandler;
import com.xiaoshu.task.Task;

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
 * @Description : 专门处理Log的日志类，进行日志的操作处理；
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2018年1月13日 下午4:49:29
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */
@Component("logTask")
public class LogTask<LogInfo> extends Task<LogInfo> {
    /**
     * @param handler
     */
    public LogTask(@Autowired @Qualifier("logHandler") DataHandler<LogInfo> handler) {
        super(handler);
    }

    @SuppressWarnings({"rawtypes"})
	@Override
	public  Task<?> getInstance(Class<? extends Task> taskClass, DataHandler dataHandler) {
		if(null == task){
			try {
				Constructor<? extends Task> constructor = taskClass.getConstructor(DataHandler.class);
				task = constructor.newInstance(handler);
			} catch (NoSuchMethodException e) {
				
				e.printStackTrace();
			} catch (SecurityException e) {
				
				e.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return task;
	}
    
}
