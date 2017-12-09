package com.xiaoshu.dubbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.spring.AnnotationBean;

@Configuration
@EnableConfigurationProperties(DubboProperties.class)
public class DubboAnnotationConfig extends AnnotationBean {

	private static final long serialVersionUID = 1L;

	public DubboAnnotationConfig() {
		System.out.println("init DubboAnnotationConfig**********************************");
	}

	@Autowired
	private DubboProperties properties;

	/**
	 * 设置dubbo扫描包
	 * 
	 * @return AnnotationBean
	 */
	@Override
	public void setPackage(String annotationPackage) {

		super.setPackage(properties.getScanPackage());
	}

}
