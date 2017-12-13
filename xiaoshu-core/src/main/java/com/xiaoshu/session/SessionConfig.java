package com.xiaoshu.session;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

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
 * @Date : Create in 2017年12月13日下午6:11:23
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@ConditionalOnProperty(name = "configuration.open.session", havingValue = "true")
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 24 * 60 * 60)
public class SessionConfig {

	public SessionConfig(){
		System.out.println("====>初始化： Spring Session 配置信息");
	}
}
