package com.xiaoshu.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * 功能说明：
 * 
 * SwaggerProperties.java
 * 
 * Original Author: administrator,2017年12月9日上午10:59:25
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

	private String basePackage;

	private String contactName = "XiaoshuShengkai";

	private String contactUrl;

	private String contactEmail = "deane163@126.com";

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactUrl() {
		return contactUrl;
	}

	public void setContactUrl(String contactUrl) {
		this.contactUrl = contactUrl;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

}
