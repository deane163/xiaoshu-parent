package com.xiaoshu.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.core.JmsMessagingTemplate;

@Configuration
@ConditionalOnProperty(name = "configuration.open.activemq", havingValue = "true")
@PropertySource("classpath:activemq.properties")
public class ActiveMqConfig {

	// 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	
	@Bean
	@ConditionalOnMissingBean(JmsMessagingTemplate.class)
	public JmsMessagingTemplate jmsMessagingTemplate(){
		System.out.println("配置 ActiveMQ 消息系统... ");
		return jmsTemplate;
	}
}
