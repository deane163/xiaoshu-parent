package com.xiaoshu.rest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {

	private RestTemplate restTemplate = new RestTemplate();
	
	@Bean
	@ConditionalOnMissingBean(RestTemplate.class)
	public RestTemplate  restTemplate(){
		System.out.println("====> 初始化RestTemplate 工具类");
		return this.restTemplate;
	}
}
