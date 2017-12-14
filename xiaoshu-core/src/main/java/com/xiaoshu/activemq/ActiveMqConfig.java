package com.xiaoshu.activemq;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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
 * @Description : ActiveMq 消息系统接入
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月14日下午8:36:48
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Configuration
@ConditionalOnProperty(name = "configuration.open.activemq", havingValue = "true")
@PropertySource("classpath:activemq.properties")
public class ActiveMqConfig {

	public ActiveMqConfig(){
		System.out.println("====>初始化： ActiveMQ 配置信息");
	}
}
