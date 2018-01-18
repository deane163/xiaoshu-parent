/**
 * 
 */
package com.xiaoshu.task.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.xiaoshu.model.LogInfo;
import com.xiaoshu.task.DataHandler;

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
 * @Description : // 批量处理日志数据，批量将日志数据插入到数据库。
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2018年1月13日 下午4:42:37
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */
@Component(value="logHandler")
public class LogDataHandler implements DataHandler<LogInfo> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Override
    public void handlerData(List<LogInfo> t) {
    	logger.info("====> save the Logs into the dataBase, the size is :{}", t.size());
        //LogService.batchSaveLog(List<LogInfo> logs);
    }

}
