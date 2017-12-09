package com.xiaoshu.dubbo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

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
 * @Date : Create in 2017年12月9日上午11:47:49
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Component
@ConditionalOnProperty(value ="dubbo", prefix = "dubbo")
@ConditionalOnResource(resources = {"classpath:dubbo.properties"})
@PropertySource(value = "classpath:dubbo.properties")
public class DubboProperties {

	private String applicationName;

	private String logger;

	private String registryProtocol;

	private String registryAddress;

	private String protocolName;

	private int protocolPort;

	private int providerTimeout;

	private int providerRetries;

	private int providerDelay;

	private String scanPackage;

	private String host;

	public String getScanPackage() {
		return scanPackage;
	}

	public void setScanPackage(String scanPackage) {
		this.scanPackage = scanPackage;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getLogger() {
		return logger;
	}

	public void setLogger(String logger) {
		this.logger = logger;
	}

	public String getRegistryProtocol() {
		return registryProtocol;
	}

	public void setRegistryProtocol(String registryProtocol) {
		this.registryProtocol = registryProtocol;
	}

	public String getRegistryAddress() {
		return registryAddress;
	}

	public void setRegistryAddress(String registryAddress) {
		this.registryAddress = registryAddress;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public int getProtocolPort() {
		return protocolPort;
	}

	public void setProtocolPort(int protocolPort) {
		this.protocolPort = protocolPort;
	}

	public int getProviderTimeout() {
		return providerTimeout;
	}

	public void setProviderTimeout(int providerTimeout) {
		this.providerTimeout = providerTimeout;
	}

	public int getProviderRetries() {
		return providerRetries;
	}

	public void setProviderRetries(int providerRetries) {
		this.providerRetries = providerRetries;
	}

	public int getProviderDelay() {
		return providerDelay;
	}

	public void setProviderDelay(int providerDelay) {
		this.providerDelay = providerDelay;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}
