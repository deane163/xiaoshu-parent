package com.xiaoshu.dubbo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
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
 * @Description : Dubbo 信息接入
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月9日下午5:03:48
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Configuration
@ConditionalOnProperty(name = "configuration.open.dubbo", havingValue = "true")
@PropertySource("classpath:dubbo.properties")
@ImportResource("classpath*:dubbo.xml")
public class DubboConfig {

	public DubboConfig(){
		System.out.println("====> initial Dubbo Configure ：Dubbo Configure Information <======");
	}
}
