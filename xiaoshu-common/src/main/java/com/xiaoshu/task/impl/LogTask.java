/**
 * 
 */
package com.xiaoshu.task.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * @Description : 专门处理Log的日志类，进行日志的操作处理
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2018年1月13日 下午4:49:29
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */
@Component
public class LogTask<LogInfo> extends Task<LogInfo> {

    /**
     * @param handler
     */
    public LogTask(@Autowired @Qualifier(value ="logHandler") DataHandler<LogInfo> handler) {
        super(handler);
    }
    

}
