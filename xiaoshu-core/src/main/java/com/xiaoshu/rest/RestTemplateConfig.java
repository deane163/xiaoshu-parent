package com.xiaoshu.rest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

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
 * @Description : RestTemplate 服务类; 提供 RestFul 服务调用类
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月13日下午3:39:19
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Configuration
public class RestTemplateConfig {

	private RestTemplate restTemplate = new RestTemplate();
	
	@Bean
	@ConditionalOnMissingBean(RestTemplate.class)
	public RestTemplate  restTemplate(){
		System.out.println("====> 初始化:RestTemplate 工具类");
		return this.restTemplate;
	}
}
