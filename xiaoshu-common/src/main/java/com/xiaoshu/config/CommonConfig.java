/**
 * 
 */
package com.xiaoshu.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xiaoshu.task.impl.LogDataHandler;
import com.xiaoshu.task.impl.LogTask;

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
 * @Date : Create in 2018年1月13日 下午4:48:58
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */
@Configuration
@ConditionalOnProperty(name="configuration.open.loginfo", havingValue = "async")
public class CommonConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @SuppressWarnings({"rawtypes"})
    private LogTask logTask;
    
    // 注入处理日志数据的实现类
    @Autowired
    @Qualifier("logHandler")
    private LogDataHandler logDataHandler;
    
    @SuppressWarnings({"rawtypes", "unchecked"})
	@Bean(value = "logTask")
    private LogTask logTask(){
		logTask = new LogTask(logDataHandler);
    	return logTask; 
    }
    
    @PostConstruct
    public void start(){
        logger.info("====> start handle the log information ! ");
        Thread logThread = new Thread(logTask);
        logThread.start();
    }
    
    
    @PreDestroy
    public void destory(){
        logger.info("====> start destroy the context ! ");
    }
   
}
