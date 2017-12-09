package com.xiaoshu.dubbo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.Exporter;

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
 * @Date : Create in 2017年12月9日上午11:51:41
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(value = DubboProperties.class)
@ConditionalOnBean(DubboProperties.class)
@ConditionalOnClass(Exporter.class)
public class DubboConfigration {

	
	@Autowired
	private  DubboProperties properties;
	
	 /**
     * dubbo服务提供
     * 
     * @return
     */
    @Bean
	public ProviderConfig providerConfig(){
    	ProviderConfig config = new ProviderConfig();
    	
    	config.setTimeout(properties.getProviderTimeout());
    	
    	config.setRetries(properties.getProviderRetries());
    	
    	config.setDelay(properties.getProviderDelay());
    	
    	config.setFilter("-exception");
    	
    	//config.setApplication(applicationConfig());
    	
    	//config.setRegistry(registryConfig());
    	
    	//config.setProtocols(protocolConfig());
    	
		return config;
	}

	/*private List<ProtocolConfig> protocolConfigs() {
		 // 服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(properties.getProtocolName());
        protocolConfig.setPort(properties.getProtocolPort());
        protocolConfig.setThreads(200);
        System.out.println("默认protocolConfig：" + protocolConfig.hashCode());
        List<ProtocolConfig> list = new ArrayList<ProtocolConfig>();
        list.add(protocolConfig);
        return list;
	}*/
	
    // 协议配置
	@Bean
	public ProtocolConfig protocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName(properties.getProtocolName());
		protocolConfig.setPort(properties.getProtocolPort());
		protocolConfig.setThreads(200);
		//主要解决阿里云服务器，hosts文件中的地址跟提供的外网地址不一致，其他服务器不需要此属性配置
		if(StringUtils.isNotEmpty(properties.getHost())){
			protocolConfig.setHost(properties.getHost());
		}
		System.out.println("默认protocolConfig：" + protocolConfig.hashCode());
		return protocolConfig;
	}

	// 连接注册中心配置
	@Bean
	public  RegistryConfig registryConfig() {
        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol(properties.getRegistryProtocol());
        registry.setAddress(properties.getRegistryAddress());
        registry.setRegister(true);
        registry.setSubscribe(true);
        return registry;
	}

	// 当前应用配置
	@Bean
	public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(properties.getApplicationName());
        return applicationConfig;
	}

//		/*@Bean
//		public ConsumerConfig consumerConfig(){
//			ConsumerConfig config = new ConsumerConfig();
//			config.setApplication(applicationConfig());
//			return config;
//		}*/
	
//		/**
// 		* 设置dubbo扫描包
// 		* @return AnnotationBean
// 		*/
//		/*@Bean
//		public static  AnnotationBean annotationBean(){
//	
//			//annotation.setPackage(properties.getScanPackage());
//			annotation.setPackage("com.ubtechinc.service");
//			//annotation.setPackage(packageName);
//			return annotation;
//		}*/
	
}
