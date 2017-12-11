package com.xiaoshu.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/***
 * 
 * code is far away from bug with the animal protecting ┏┓　　　┏┓ ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃ ┃　　　━　　　┃ ┃　┳┛　┗┳　┃ ┃　　　　　　　┃ ┃　　　┻　　　┃ ┃　　　　　　　┃ ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑 　　┃　　　┃代码无BUG！ 　　┃　　　┗━━━┓ 　　┃　　　　　　　┣┓ 　　┃　　　　　　　┏┛ 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫ 　　　┗┻┛　┗┻┛
 *
 *
 * @Description : ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2017年12月11日下午8:22:44
 * 
 *       Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Component
@ConditionalOnProperty(name = "configuration.open.redis", havingValue = "true")
@PropertySource("classpath:redis.properties")
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

	private String hostName;

	private Integer maxIdle;

	private Integer maxTotal;

	private Integer maxWaitMillis;

	private String password;

	private String masterName;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public Integer getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}

	public Integer getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}

	public Integer getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(Integer maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

}
