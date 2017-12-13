package com.xiaoshu.activemq;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConditionalOnProperty(name = "configuration.open.activemq", havingValue = "true")
@PropertySource("classpath:activemq.properties")
public class ActiveMqConfig {

	public ActiveMqConfig(){
		System.out.println("====>初始化： ActiveMQ 配置信息");
	}
}
